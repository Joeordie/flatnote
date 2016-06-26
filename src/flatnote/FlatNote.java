/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flatnote;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author joeordie
 */
public class FlatNote {

    /**
     * @param args the command line arguments
     */
    public static String strFilePath = "/home/joeordie/";
        
    public static void main(String[] args) {
        //construct the windows we need. 
        FrmMainWindow mainwindow = new FrmMainWindow();
        FrmFileBrowser selector = new FrmFileBrowser();
        //hide the file selector till we need it. 
        selector.hide();
        
        
    }    
    
    public static void SelectDirectory(){
        //This selects the top directory for all notebooks. 
    }
    
    public static void NewNotebook(String varNotbookloc){
        try {
            //This method creates a new "notebook"  which is just a folder. 
            String strNotebookName = strFilePath+varNotbookloc;
            //look to see if the notbook exists
            File objNote = new File(strNotebookName);
            //Sanity check to see if the folder is already there.
            if(objNote.exists()) { 
                objMessage alertbox = new objMessage();
                alertbox.infoBox("File: " + strNotebookName + " exists!", "Warning!");    
            }
            else {
                objNote.mkdir();
            }    
        }    
        catch(Exception e){
             e.printStackTrace();   
        }
    }
    
    public static int NewNote(String[] NoteComp){
        String strNoteLocation = strFilePath+NoteComp[0]+"/"+NoteComp[1]+".txt";
        int rtnInt = 0;
        try{
            objMessage alertBox = new objMessage();
            File objNote = new File(strNoteLocation);

            //Check to see if your destroying another note with same name!
            if (objNote.exists() && !objNote.isDirectory()) { 
                alertBox.infoBox("File " + NoteComp[1] + " exists!\nDo you want to open the note? ", "Warning!"); 

                //Ask if you want to continue. 
                if (alertBox.confirmBox()==0)rtnInt = 1;
            }
            else objNote.createNewFile();
        }
        catch(Exception e){
        e.printStackTrace();
        } 
        return rtnInt;
    }
    
    public static String[] readNote(String[] NoteComp){
        String strNoteLocation = strFilePath+NoteComp[0]+"/"+NoteComp[1]+".txt";
        String[] rtnNoteComp = new String[3];
        rtnNoteComp[0] = NoteComp[0];
        rtnNoteComp[1] = NoteComp[1]; 
        //rtnNoteComp[2] = NoteComp[2];
        try {
            BufferedReader noteRead = new BufferedReader(new FileReader(strNoteLocation));
                        
                        String line = noteRead.readLine();
                        String lineAssembly = line; 
                        line = noteRead.readLine();
                        while(line != null){
                            lineAssembly = (lineAssembly + "\n"+ line);
                            line = noteRead.readLine();
                            
                            
                        }
                        rtnNoteComp[2] = lineAssembly;
        }
        catch(Exception e){
            e.printStackTrace();
                }    
        return rtnNoteComp;
    }
    
    
    
    public static void SaveNote(String[] NoteComp){
        //This method makes the magic happen!!!
        //Create full filepath for note.txt
        String strNoteLocation = strFilePath+NoteComp[0]+"/"+NoteComp[1]+".txt";

        try{

            objMessage alertBox = new objMessage();
            File objNote = new File(strNoteLocation);
            //Check to see if your destroying another note with same name!
            if (objNote.exists() && !objNote.isDirectory()) { 
                alertBox.infoBox("File " + NoteComp[1] + " exists!", "Warning!"); 
                //Confirmation box 0 = overwrite. 
                if (alertBox.confirmBox()==0){
                    objNote.createNewFile();
                FileWriter writer = new FileWriter(objNote);
                writer.write(NoteComp[2]);
                writer.flush();
                writer.close();
                }    
            }

            else{
                objNote.createNewFile();
                FileWriter writer = new FileWriter(objNote);
                writer.write(NoteComp[2]);
                writer.flush();
                writer.close();
            }
        }  

        catch(Exception e){
        e.printStackTrace();
        }
    }
    
    public static void Search(){
            
        }
    
    public static void DeleteNote(String[] NoteComp){
        try{ 
            String strNoteAddress = NoteComp[0]+NoteComp[1];
            File objNote = new File(strNoteAddress);
            objNote.delete();      
        }
        catch(Exception e ){  
        e.printStackTrace();
        }
    }
    public static class objMessage{
        
         public void infoBox(String infoMessage, String titleBar)
        {
            JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
            
        }
         public int confirmBox(){
             
             return (JOptionPane.showConfirmDialog(null, "Do you want to Continue?", "Confirmation Needed.", JOptionPane.OK_CANCEL_OPTION));
           }
    }
   
    
}

