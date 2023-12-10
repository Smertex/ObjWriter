package org.example.ObjWriter;

import org.example.Math.Vector3f;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ObjWriterException extends Exception{
    public ObjWriterException(String message, int line){
        super("Error when writing a file in a line: " + line + ". " + message);
    }
    public ObjWriterException(String message){
        super(message);
    }
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
}
