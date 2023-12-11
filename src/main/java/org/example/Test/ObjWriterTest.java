package org.example.Test;

import org.example.Math.Vector2f;
import org.example.Math.Vector3f;
import org.example.Model.Polygon;
import org.example.ObjWriter.ObjWriter;

import java.io.IOException;
import java.util.ArrayList;

public class ObjWriterTest{
    //В тестах применяется файл с данным путем: C:/Users/kirat/Desktop/Test.obj
    public static void testFileCorrectness(){
        ObjWriter testObjWriter = new ObjWriter();

        try {
            testObjWriter.recordComment("C:/Users/kirat/Desktop/Test" + ".obj","Съешь ещё этих мягких французских булок");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void testRecordVertices(){
        ObjWriter testObjWriter = new ObjWriter();

        ArrayList<Vector3f> vertices = new ArrayList<>();
        vertices.add(new Vector3f(0.2f, 0.3f, 0.5f));
        vertices.add(new Vector3f(0.4f, 0.7f, 0.9f));
        //vertices.add(null);
        vertices.add(new Vector3f(0.1f, 0.8f, 0.3f));

        try {
            testObjWriter.recordVertices("C:/Users/kirat/Desktop/Test.obj", vertices);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void testRecordTextureVertices(){
        ObjWriter testObjWriter = new ObjWriter();

        ArrayList<Vector2f> textureVertices = new ArrayList<>();
        textureVertices.add(new Vector2f(0.5f, 0.2f));
        textureVertices.add(new Vector2f(0.1f, 0.3f));
        textureVertices.add(new Vector2f(0.4f, 0.2f));
        //textureVertices.add(null);

        try {
            testObjWriter.recordTextureVertices("C:/Users/kirat/Desktop/Test.obj", textureVertices);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void testNormals(){
        ObjWriter testObjWriter = new ObjWriter();

        ArrayList<Vector3f> normals = new ArrayList<>();
        //vertices.add(null);
        normals.add(new Vector3f(0.22f, 0.31f, 0.53f));
        normals.add(new Vector3f(-0.44f, 0.72f, 0.99f));
        normals.add(new Vector3f(0.21f, 0.64f, 0.23f));

        try {
            testObjWriter.recordNormals("C:/Users/kirat/Desktop/Test.obj", normals);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void testPolygons(){
        ObjWriter testObjWriter = new ObjWriter();

        ArrayList<Polygon> polygons = new ArrayList<>();
        polygons.add(new Polygon());

        ArrayList<Integer> vertexIndices = new ArrayList<>();
        vertexIndices.add(1);
        vertexIndices.add(2);
        vertexIndices.add(3);

        ArrayList<Integer> textureVertexIndices = new ArrayList<>();
        textureVertexIndices.add(3);
        textureVertexIndices.add(4);
        textureVertexIndices.add(5);

        ArrayList<Integer> normalIndices = new ArrayList<>();
        normalIndices.add(7);
        normalIndices.add(8);
        normalIndices.add(9);

        polygons.get(0).setVertexIndices(vertexIndices);
        polygons.get(0).setTextureVertexIndices(textureVertexIndices);
        polygons.get(0).setNormalIndices(normalIndices);

        try {
            testObjWriter.recordPolygons("C:/Users/kirat/Desktop/Test.obj", polygons);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
