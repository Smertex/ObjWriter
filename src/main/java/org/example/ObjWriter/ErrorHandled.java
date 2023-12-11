package org.example.ObjWriter;

import org.example.Model.Polygon;

import java.io.File;
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
            System.err.println("This file not found, therefore a file was created in a directory called 'objFile'");
            File file = new File("objFile");
            try {
                return new FileWriter(objFile, true);
            }
            catch (IOException ex) {
                throw new RuntimeException(ex);
            }
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

    public static void structurePolygon(Polygon polygon){
        if (polygon.getVertexIndices().size() < 3) {
            try {
                throw new ObjWriterException("A polygon cannot have fewer than two vertices");
            }
            catch (ObjWriterException e) {
                throw new RuntimeException(e);
            }
        }
        else if (!polygon.getTextureVertexIndices().isEmpty() && polygon.getTextureVertexIndices().size() != polygon.getVertexIndices().size()) {
            try {
                throw new ObjWriterException("The number of vertices and UV is not equivalent");
            }
            catch (ObjWriterException e) {
                throw new RuntimeException(e);
            }
        }
        else if (!polygon.getNormalIndices().isEmpty() && polygon.getNormalIndices().size() != polygon.getVertexIndices().size()) {
            try {
                throw new ObjWriterException("The number of vertices and normals is not equivalent");
            }
            catch (ObjWriterException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
