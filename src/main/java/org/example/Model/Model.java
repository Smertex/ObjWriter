package org.example.Model;

import org.example.Math.Vector2f;
import org.example.Math.Vector3f;

import java.util.ArrayList;

public class Model {
    private ArrayList<Vector3f> vertices = new ArrayList<Vector3f>();
    private ArrayList<Vector2f> textureVertices = new ArrayList<Vector2f>();
    private ArrayList<Vector3f> normals = new ArrayList<Vector3f>();
    private ArrayList<Polygon> polygons = new ArrayList<Polygon>();
    public void setNormals(ArrayList<Vector3f> normals) {
        this.normals = normals;
    }
    public void setPolygons(ArrayList<Polygon> polygons) {
        this.polygons = polygons;
    }
    public void setTextureVertices(ArrayList<Vector2f> textureVertices) {
        this.textureVertices = textureVertices;
    }
    public void setVertices(ArrayList<Vector3f> vertices) {
        this.vertices = vertices;
    }
    public ArrayList<Vector3f> getVertices() {
        return vertices;
    }
    public ArrayList<Vector2f> getTextureVertices() {
        return textureVertices;
    }
    public ArrayList<Vector3f> getNormals() {
        return normals;
    }
    public ArrayList<Polygon> getPolygons() {
        return polygons;
    }
}
