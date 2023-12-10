package org.example;

import org.example.Math.Vector3f;
import org.example.ObjWriter.ObjWriter;
import org.example.Test.ObjWriterTest;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //ObjWriterTest.testFileCorrectness();
        //ObjWriterTest.testRecordVertices();
        //ObjWriterTest.testRecordTextureVertices();
        //ObjWriterTest.testNormals();
        ObjWriterTest.testPolygons();

    }
}