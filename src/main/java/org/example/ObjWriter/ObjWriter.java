package org.example.ObjWriter;

import org.example.Math.Vector3f;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ObjWriter {
    private static final String OBJ_COMMENT_TOKEN = "#";
    private static final String OBJ_VERTEX_TOKEN = "v";
    private static final String OBJ_TEXTURE_TOKEN = "vt";
    private static final String OBJ_NORMAL_TOKEN = "vn";
    private static final String OBJ_FACE_TOKEN = "f";

    //Записывает информацию из необходимого файла в формат .obj
    public void recordFromAFile(String fileForRecord, String initialFile){
    }
    public void recordComment(String objFile, String comment) throws IOException {
        FileWriter fileWriter = ObjWriterException.fileCorrectness(objFile);

        fileWriter.write(OBJ_COMMENT_TOKEN + comment + "\n");
        fileWriter.flush();
        fileWriter.close();
    }
    //Добавление вершин вручную в необходимый файл. В качестве файла принимает ссылку
    public void recordVertices(String objFile, ArrayList<Vector3f> vertices) throws IOException {
        FileWriter fileWriter = ObjWriterException.fileCorrectness(objFile);

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


}
