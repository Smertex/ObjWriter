package org.example.ObjWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class ErrorHandled {
    public static FileWriter fileCorrectness(String objFile){
        try {
            if (objFile.toLowerCase().endsWith(".obj"))
                return new FileWriter(objFile, true);
            else
                throw new ObjWriterException("The format of this file is not .obj");
        }
        catch (IOException e) {
            System.err.println("This file not found");
            throw new RuntimeException(e);
        }
        catch (ObjWriterException e) {
            throw new RuntimeException(e);
        }
    }
    public static void checkingForEmptiness(ArrayList currentList){
        if(currentList.isEmpty()){
            try {
                throw new ObjWriterException("Array of vertices is empty!");
            }
            catch (ObjWriterException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void checkingForNull(ArrayList currentList, int i){
        if(currentList.get(i) == null) {
            try {
                int errorLine = i + 1;
                throw new ObjWriterException("The element is null.", errorLine);
            }
            catch (ObjWriterException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
