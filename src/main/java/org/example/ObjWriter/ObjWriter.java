package org.example.ObjWriter;

import org.example.Math.Vector2f;
import org.example.Math.Vector3f;
import org.example.Model.Model;
import org.example.Model.Polygon;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ObjWriter {
    private static final String OBJ_COMMENT_TOKEN = "#";
    private static final String OBJ_VERTEX_TOKEN = "v";
    private static final String OBJ_TEXTURE_TOKEN = "vt";
    private static final String OBJ_NORMAL_TOKEN = "vn";
    private static final String OBJ_FACE_TOKEN = "f";

    //Добавление модели
    protected void recordModel(String objFile, Model model) throws IOException {
        if (model == null) {
            throw new IllegalArgumentException("Model illegal argument");
        }
        FileWriter fileWriter = ErrorHandled.fileCorrectness(objFile);

        if (model == null) {
            try {
                throw new ObjWriterException("Model is null");
            } catch (ObjWriterException e) {
                throw new RuntimeException(e);
            }
        } else {
            recordVertices(fileWriter, model.getVertices());
            recordTextureVertices(fileWriter, model.getTextureVertices());
            recordNormals(fileWriter, model.getNormals());
            recordPolygons(fileWriter, model.getPolygons());
        }
    }

    //Добавление комментария
    protected void recordComment(FileWriter fileWriter, String comment) throws IOException {
        fileWriter.write(OBJ_COMMENT_TOKEN + comment + "\n");
        fileWriter.flush();
    }

    //Добавление вершин
    protected void recordVertices(FileWriter fileWriter, ArrayList<Vector3f> vertices) throws IOException {
        for (int i = 0; i < vertices.size(); i++) {
            ErrorHandled.checkingForNull(vertices, i);
            fileWriter.write(OBJ_VERTEX_TOKEN + " " + vertices.get(i).getX() + " " + vertices.get(i).getY() + " " + vertices.get(i).getZ() + "\n");
        }
        fileWriter.flush();
    }

    //Добавление UV
    protected void recordTextureVertices(FileWriter fileWriter, ArrayList<Vector2f> textureVertices) throws IOException {
        for (int i = 0; i < textureVertices.size(); i++) {
            ErrorHandled.checkingForNull(textureVertices, i);
            fileWriter.write(OBJ_TEXTURE_TOKEN + " " + textureVertices.get(i).getX() + " " + textureVertices.get(i).getY() + "\n");
        }
        fileWriter.flush();
    }

    //Добавление нормали
    protected void recordNormals(FileWriter fileWriter, ArrayList<Vector3f> normals) throws IOException {
        for (int i = 0; i < normals.size(); i++) {
            ErrorHandled.checkingForNull(normals, i);
            fileWriter.write(OBJ_NORMAL_TOKEN + " " + normals.get(i).getX() + " " + normals.get(i).getY() + " " + normals.get(i).getZ() + "\n");
        }
        fileWriter.flush();
    }

    //Добавление Полигона
    protected void recordPolygons(FileWriter fileWriter, ArrayList<Polygon> polygons) throws IOException {
        for (int i = 0; i < polygons.size(); i++) {
            ErrorHandled.checkingForNull(polygons, i);
            fileWriter.write(polygonBuilder(polygons.get(i)) + "\n");
        }
        fileWriter.flush();
    }

    //Конструктор строки
    private String polygonBuilder(Polygon polygon) {
        StringBuilder returnString = new StringBuilder(OBJ_FACE_TOKEN + " ");
        ErrorHandled.structurePolygon(polygon);
        int  vertexIndices = polygon.getVertexIndices().size();

        if (polygon.getTextureVertexIndices().isEmpty() && polygon.getNormalIndices().isEmpty()) {
            for (int i = 0; i < vertexIndices; i++) {
                returnString.append(polygon.getVertexIndices().get(i));
                if (i < vertexIndices - 1) {
                    returnString.append(" ");
                }
            }
        }
        else if (polygon.getTextureVertexIndices().isEmpty()) {
            for (int i = 0; i < vertexIndices; i++) {
                returnString.append(polygon.getVertexIndices().get(i));
                returnString.append("/");
                returnString.append("/").append(polygon.getNormalIndices().get(i));
                if (i < vertexIndices - 1) {
                    returnString.append(" ");
                }
            }
        }
        else if (polygon.getNormalIndices().isEmpty()) {
            for (int i = 0; i < vertexIndices; i++) {
                returnString.append(polygon.getVertexIndices().get(i));
                returnString.append("/").append(polygon.getTextureVertexIndices().get(i));
                if (i < vertexIndices - 1) {
                    returnString.append(" ");
                }
            }
        }
        else {
            for (int i = 0; i < vertexIndices; i++) {
                returnString.append(polygon.getVertexIndices().get(i));
                returnString.append("/").append(polygon.getTextureVertexIndices().get(i));
                returnString.append("/").append(polygon.getNormalIndices().get(i));
                if (i < vertexIndices - 1) {
                    returnString.append(" ");
                }

            }
        }
        return returnString.toString();
    }
}


