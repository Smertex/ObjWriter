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
}
