package org.example.ObjWriter;

import org.example.Math.Vector2f;
import org.example.Math.Vector3f;
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
    public void recordModel() throws IOException {

    }
    //Добавление комментария
    public void recordComment(String objFile, String comment) throws IOException {
        FileWriter fileWriter = ObjWriterException.fileCorrectness(objFile);

        fileWriter.write(OBJ_COMMENT_TOKEN + comment + "\n");
        fileWriter.flush();
        fileWriter.close();
    }
    //Добавление вершин
    public void recordVertices(String objFile, ArrayList<Vector3f> vertices) throws IOException {
        FileWriter fileWriter = ObjWriterException.fileCorrectness(objFile);

        if(vertices.isEmpty()){
            try {
                throw new ObjWriterException("Array of vertices is empty!");
            }
            catch (ObjWriterException e) {
                throw new RuntimeException(e);
            }
        }

        for(int i = 0; i < vertices.size(); i++) {
            if(vertices.get(i) == null) {
                try {
                    int errorLine = i + 1;
                    throw new ObjWriterException("The element is null.", errorLine);
                }
                catch (ObjWriterException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                fileWriter.write(OBJ_VERTEX_TOKEN + " " + vertices.get(i).getX() + " " + vertices.get(i).getY() + " " + vertices.get(i).getZ() + "\n");
            }
        }
        fileWriter.flush();
        fileWriter.close();
    }
    //Добавление UV
    public void recordTextureVertices(String objFile, ArrayList<Vector2f> textureVertices) throws IOException {
        FileWriter fileWriter = ObjWriterException.fileCorrectness(objFile);

        if(textureVertices.isEmpty()){
            try {
                throw new ObjWriterException("Array of vertices is empty!");
            }
            catch (ObjWriterException e) {
                throw new RuntimeException(e);
            }
        }

        for(int i = 0; i < textureVertices.size(); i++) {
            if(textureVertices.get(i) == null) {
                try {
                    int errorLine = i + 1;
                    throw new ObjWriterException("The element is null.", errorLine);
                }
                catch (ObjWriterException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                fileWriter.write(OBJ_TEXTURE_TOKEN + " " + textureVertices.get(i).getX() + " " + textureVertices.get(i).getY() + "\n");
            }
        }
        fileWriter.flush();
        fileWriter.close();
    }
    //Добавление нормали
    public void recordNormals(String objFile, ArrayList<Vector3f> normals) throws IOException {
        FileWriter fileWriter = ObjWriterException.fileCorrectness(objFile);

        if(normals.isEmpty()){
            try {
                throw new ObjWriterException("Array of vertices is empty!");
            }
            catch (ObjWriterException e) {
                throw new RuntimeException(e);
            }
        }

        for(int i = 0; i < normals.size(); i++) {
            if(normals.get(i) == null) {
                try {
                    int errorLine = i + 1;
                    throw new ObjWriterException("The element is null.", errorLine);
                }
                catch (ObjWriterException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                fileWriter.write(OBJ_NORMAL_TOKEN + " " + normals.get(i).getX() + " " + normals.get(i).getY() + " " + normals.get(i).getZ() + "\n");
            }
        }
        fileWriter.flush();
        fileWriter.close();
    }
    //Добавление Полигона
    public void recordPolygons(String objFile, ArrayList<Polygon> polygons) throws IOException {
        FileWriter fileWriter = ObjWriterException.fileCorrectness(objFile);

        for(int i = 0; i < polygons.size(); i++){
            if(polygons.get(i) == null){
                try {
                    int errorLine = i + 1;
                    throw new ObjWriterException("The element is null.", errorLine);
                }
                catch (ObjWriterException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                fileWriter.write(polygonBuilder(polygons.get(i)) + "\n");
            }
        }

        fileWriter.flush();
        fileWriter.close();
    }
    //Конструктор строки
    public String polygonBuilder(Polygon polygon){
        StringBuilder returnString = new StringBuilder(OBJ_FACE_TOKEN + " ");

        for(int i = 0; i < polygon.getAmountOfPoints(); i++){
            if(polygon.getVertexIndices().size() < polygon.getAmountOfPoints()){
                try {
                    throw new ObjWriterException("A polygon cannot have fewer than two vertices");
                }
                catch (ObjWriterException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                returnString.append(polygon.getVertexIndices().get(i) + "/");
            }

            if(polygon.getTextureVertexIndices().isEmpty()){
                returnString.append("/");
            }
            else if(polygon.getTextureVertexIndices().size() != polygon.getVertexIndices().size()){
                try {
                    throw new ObjWriterException("The number of vertices and UV is not equivalent");
                }
                catch (ObjWriterException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                returnString.append(polygon.getTextureVertexIndices().get(i) + "/");
            }

            if(polygon.getNormalIndices().isEmpty()){
                if(i < polygon.getAmountOfPoints() - 1) {
                    returnString.append(" ");
                }
            }
            else if(polygon.getNormalIndices().size() != polygon.getVertexIndices().size()){
                try {
                    throw new ObjWriterException("The number of vertices and normals is not equivalent");
                }
                catch (ObjWriterException e) {
                    throw new RuntimeException(e);
             }
            }
            else{
                if(i < polygon.getAmountOfPoints() - 1) {
                    returnString.append(polygon.getNormalIndices().get(i) + " ");
                }
                else{
                    returnString.append(polygon.getNormalIndices().get(i));
                }
            }


        }
        return returnString.toString();
    }
}
