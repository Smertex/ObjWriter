package org.example;

import org.example.Math.Vector3f;
import org.example.ObjWriter.ObjWriter;
import org.example.ObjWriter.ObjWriterException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ObjWriter objWriter = new ObjWriter();

        ArrayList<Vector3f> vertices = new ArrayList<>();
        vertices.add(new Vector3f(0.2f, 0.3f, 0.5f));
        vertices.add(new Vector3f(0.3f, 0.4f, 0.6f));

        try {
            objWriter.recordVertices("C:/Users/kirat/Desktop/Test" + ".obj", vertices);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //"C:/Users/kirat/Desktop/Test" + ".obj"

    }
}