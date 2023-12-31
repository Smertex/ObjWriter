package org.example.ObjWriter;

import org.example.Model.Polygon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class ErrorHandled {
    public static FileWriter fileCorrectness(String objFile) {
        try {
            return new FileWriter(objFile);
        } catch (IOException e) {
            System.err.println("This file not found, therefore a file was created in a directory called 'objFile'");
            File file = new File("objFile");
            try {
                return new FileWriter(objFile);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void checkingForNull(ArrayList<?> currentList, int i) {
        if (currentList.get(i) == null) {
                int errorLine = i + 1;
                throw new ObjWriterException("The element is null.", errorLine);
        }
    }

    public static void structurePolygon(Polygon polygon) {
        if (polygon.getVertexIndices().size() < 3) {
            try {
                throw new ObjWriterException("A polygon cannot have fewer than two vertices");
            } catch (ObjWriterException e) {
                System.err.println(e.getMessage());
            }
        } else if (!polygon.getTextureVertexIndices().isEmpty() && polygon.getTextureVertexIndices().size() != polygon.getVertexIndices().size()) {
            try {
                throw new ObjWriterException("The number of vertices and UV is not equivalent");
            } catch (ObjWriterException e) {
                System.err.println(e.getMessage());
            }
        } else if (!polygon.getNormalIndices().isEmpty() && polygon.getNormalIndices().size() != polygon.getVertexIndices().size()) {
            try {
                throw new ObjWriterException("The number of vertices and normals is not equivalent");
            } catch (ObjWriterException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
