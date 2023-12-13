package org.example.ObjWriter;

import junit.framework.TestCase;
import org.example.Math.Vector2f;
import org.example.Math.Vector3f;
import org.example.Model.Model;
import org.example.Model.Polygon;
import org.example.ObjReader.ObjReader;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ObjWriterTest extends TestCase {
    private static final String NAME_FILE = "Test.obj";
    @Test
    public static void testСreateFile() {
        FileWriter fileWriter = ErrorHandled.fileCorrectness(NAME_FILE);
    }
    @Test
    public static void testRecordNull() {
        FileWriter fileWriter = ErrorHandled.fileCorrectness(NAME_FILE);
        ObjWriter objWriter = new ObjWriter();

        ArrayList<Vector3f> vertices = new ArrayList<>();
        vertices.add(new Vector3f(0.22f, 0.33f, 0.11f));
        vertices.add(new Vector3f(0.22f, 0.35f, 0.12f));
        vertices.add(null);
        vertices.add(new Vector3f(0.1f, 0.23f, 0.14f));
        vertices.add(new Vector3f(0.50f, 0.11f, 0.85f));

        try {
            objWriter.recordVertices(fileWriter, vertices);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public static void testRecordComment() {
        FileWriter fileWriter = ErrorHandled.fileCorrectness(NAME_FILE);
        ObjWriter objWriter = new ObjWriter();
        String message = "Съешь ещё этих мягких французских булок, да выпей же чаю";
        String line;

        try {
            objWriter.recordComment(fileWriter, message);
            BufferedReader reader = new BufferedReader(new FileReader(NAME_FILE));
            line = reader.readLine();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertEquals("#" + message, line);
    }
    @Test
    public static void testRecordVertices() {
        FileWriter fileWriter = ErrorHandled.fileCorrectness(NAME_FILE);
        ObjWriter objWriter = new ObjWriter();
        String strokeInfo = "v 0.22 0.33 0.11" + "v 0.22 0.35 0.12" + "v 0.1 0.23 0.14" + "v 0.5 0.11 0.85";
        String line = "";

        ArrayList<Vector3f> vertices = new ArrayList<>();
        vertices.add(new Vector3f(0.22f, 0.33f, 0.11f));
        vertices.add(new Vector3f(0.22f, 0.35f, 0.12f));
        vertices.add(new Vector3f(0.1f, 0.23f, 0.14f));
        vertices.add(new Vector3f(0.50f, 0.11f, 0.85f));

        try {
            objWriter.recordVertices(fileWriter, vertices);
            BufferedReader reader = new BufferedReader(new FileReader(NAME_FILE));
            BufferedReader readerNull = new BufferedReader(new FileReader(NAME_FILE));

            while(readerNull.readLine() != null){
                line += reader.readLine();
            }
            reader.close();
            readerNull.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertEquals(strokeInfo, line);
    }
    @Test
    public static void testRecordTextureVertices() {
        FileWriter fileWriter = ErrorHandled.fileCorrectness(NAME_FILE);
        ObjWriter objWriter = new ObjWriter();

        ArrayList<Vector2f> textureVertices = new ArrayList<>();

        textureVertices.add(new Vector2f( 0.33f, 0.11f));
        textureVertices.add(new Vector2f( 0.35f, 0.12f));
        textureVertices.add(new Vector2f( 0.23f, 0.14f));
        textureVertices.add(new Vector2f( 0.11f, 0.85f));

        try {
            objWriter.recordTextureVertices(fileWriter, textureVertices);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public static void testRecordNormals() {
        FileWriter fileWriter = ErrorHandled.fileCorrectness(NAME_FILE);
        ObjWriter objWriter = new ObjWriter();
        ArrayList<Vector3f> normals = new ArrayList<>();

        normals.add(new Vector3f(0.1f, 0.2f, 0.3f));
        normals.add(new Vector3f(0.4f, 0.5f, 0.6f));
        normals.add(new Vector3f(0.7f, 0.8f, 0.9f));
        normals.add(new Vector3f(0.11f, 0.12f, 0.13f));

        try {
            objWriter.recordNormals(fileWriter, normals);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public static void testRecordPolygons() {
        FileWriter fileWriter = ErrorHandled.fileCorrectness(NAME_FILE);
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
            objWriter.recordPolygons(fileWriter, polygons);
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