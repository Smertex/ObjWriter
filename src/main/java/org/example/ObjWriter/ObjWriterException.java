package org.example.ObjWriter;
public class ObjWriterException extends Exception{
    public ObjWriterException(String message, int line){
        super("Error when writing a file in a line: " + line + ". " + message);
    }
    public ObjWriterException(String message){
        super(message);
    }
}
