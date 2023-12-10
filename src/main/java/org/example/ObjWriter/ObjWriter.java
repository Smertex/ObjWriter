package org.example.ObjWriter;

import org.example.Math.Vector3f;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ObjWriter {
    private static final String OBJ_VERTEX_TOKEN = "v";
    private static final String OBJ_TEXTURE_TOKEN = "vt";
    private static final String OBJ_NORMAL_TOKEN = "vn";
    private static final String OBJ_FACE_TOKEN = "f";

    //Записывает информацию из необходимого файла в формат .obj
    public void recordFromAFile(String fileForRecord, String initialFile){
    }

    //Добавление вершин вручную в необходимый файл. В качестве файла принимает ссылку
    public void recordVertices(String objFile, ArrayList<Vector3f> vertices) throws IOException {
        FileWriter fileWriter;

        try {
            if (objFile.toLowerCase().endsWith(".obj"))
                fileWriter = new FileWriter(objFile, true);
            else
                throw new ObjWriterException("The format of this file is not .obj");
        }
        catch (IOException e) {
            System.err.println("This file not found");
            throw new RuntimeException(e);
        }
        catch (ObjWriterException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i < vertices.size(); i++) {
            if(vertices.get(i) == null) {
                try {
                    int errorLine = i + 1;
                    throw new ObjWriterException("The element is null in the line:" + " " + errorLine);
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
