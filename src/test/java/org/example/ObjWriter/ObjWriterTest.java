package org.example.ObjWriter;

import junit.framework.TestCase;
import org.example.Math.Vector2f;
import org.example.Math.Vector3f;
import org.example.Model.Model;
import org.example.Model.Polygon;
import org.example.ObjReader.ObjReader;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ObjWriterTest extends TestCase {
    private static final String NAME_FILE = "C:/Users/kirat/Desktop/Test.obj";
    private static final String NAME_FILE_FOR_ERROR = "C:/Users/kirat/Desktop/Test.txt";
    private static final String NAME_FILE_CREATE = "Object.obj";
    private static final String NAME_FILE_CREATE_FOR_ERROR = "Object.txt";
    @Test
    public static void testRecordComment() {
        ObjWriter objWriter = new ObjWriter();
        try {
              objWriter.recordComment(NAME_FILE, "Съешь ещё этих мягких французских булок, да выпей же чаю");
//            objWriter.recordComment(NAME_FILE_FOR_ERROR, "Съешь ещё этих мягких французских булок, да выпей же чаю");
//            objWriter.recordComment(NAME_FILE_CREATE, "Съешь ещё этих мягких французских булок, да выпей же чаю");
//            objWriter.recordComment(NAME_FILE_CREATE_FOR_ERROR, "Съешь ещё этих мягких французских булок, да выпей же чаю");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public static void testRecordVertices() {
        ObjWriter objWriter = new ObjWriter();
        ArrayList<Vector3f> vertices = new ArrayList<>();

        //vertices.add(null);
        vertices.add(new Vector3f(0.22f, 0.33f, 0.11f));
        vertices.add(new Vector3f(0.22f, 0.35f, 0.12f));
        //vertices.add(null);
        vertices.add(new Vector3f(0.1f, 0.23f, 0.14f));
        vertices.add(new Vector3f(0.50f, 0.11f, 0.85f));
        //vertices.add(null);

        try {
            objWriter.recordVertices(NAME_FILE, vertices);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public static void testRecordTextureVertices() {
        ObjWriter objWriter = new ObjWriter();

        ArrayList<Vector2f> textureVertices = new ArrayList<>();

        textureVertices.add(new Vector2f( 0.33f, 0.11f));
        textureVertices.add(new Vector2f( 0.35f, 0.12f));
        textureVertices.add(new Vector2f( 0.23f, 0.14f));
        textureVertices.add(new Vector2f( 0.11f, 0.85f));

        try {
            objWriter.recordTextureVertices(NAME_FILE, textureVertices);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public static void testRecordNormals() {
        ObjWriter objWriter = new ObjWriter();
        ArrayList<Vector3f> normals = new ArrayList<>();

        normals.add(new Vector3f(0.1f, 0.2f, 0.3f));
        normals.add(new Vector3f(0.4f, 0.5f, 0.6f));
        normals.add(new Vector3f(0.7f, 0.8f, 0.9f));
        normals.add(new Vector3f(0.11f, 0.12f, 0.13f));

        try {
            objWriter.recordNormals(NAME_FILE, normals);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public static void testRecordPolygons() {
        ObjWriter objWriter = new ObjWriter();
        ArrayList<Polygon> polygons = new ArrayList<>();

        ArrayList<Integer> vertexIndices = new ArrayList<>();
        vertexIndices.add(1);
        vertexIndices.add(2);
        vertexIndices.add(3);
        vertexIndices.add(4);

        ArrayList<Integer> textureVertexIndices = new ArrayList<>();
        textureVertexIndices.add(5);
        textureVertexIndices.add(6);
        textureVertexIndices.add(7);
        textureVertexIndices.add(8);

        ArrayList<Integer> normalIndices = new ArrayList<>();
        normalIndices.add(9);
        normalIndices.add(10);
        normalIndices.add(11);
        normalIndices.add(12);

        polygons.add(new Polygon());
        polygons.get(0).setVertexIndices(vertexIndices);
        polygons.get(0).setTextureVertexIndices(textureVertexIndices);
        polygons.get(0).setNormalIndices(normalIndices);


        try {
            objWriter.recordPolygons(NAME_FILE, polygons);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public static void testRecordModel() {
        ObjWriter objWriter = new ObjWriter();

        Path fileName = Path.of("src/3DModelsForTest/Test05.obj");
        String fileContent;
        try {
            fileContent = Files.readString(fileName);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        Model model = ObjReader.read(fileContent);

        try {
            objWriter.recordModel(NAME_FILE, model);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}