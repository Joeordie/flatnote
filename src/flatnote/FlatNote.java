/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flatnote;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author joeordie
 */
public class FlatNote {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FrmMainWindow main = new FrmMainWindow();
        
      
        
    }
    
    public static void SelectDirectory(){
        //This selects the top directory for all notebooks. 
    }
    
    public static void NewNotebook(String varNotbookloc){
        try {
            //This creates a folder with the name given in the  tbxNotebookName
            String strNotebookName = varNotbookloc;
            //look to see if the notbook exists
            File objNote = new File(strNotebookName);
            if(objNote.exists() && !objNote.isDirectory()) { 
                objNote.createNewFile();
            }
        }    
        catch(Exception e){
             e.printStackTrace();   
        }
                
    
    }
    
    public static void NewNote(String varNoteName){
            
    }
    
    public static void SaveNote(Object NoteComp){
            
    }
    
    public static void Search(){
            
        }
    
    public static void Delete(String varNotbookloc){
            
        }
    
}
