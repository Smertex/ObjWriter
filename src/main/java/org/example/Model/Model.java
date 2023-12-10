package org.example.Model;

import org.example.Math.Vector2f;
import org.example.Math.Vector3f;

import java.util.ArrayList;

public class Model {
    public ArrayList<Vector3f> vertices = new ArrayList<Vector3f>();
    public ArrayList<Vector2f> textureVertices = new ArrayList<Vector2f>();
    public ArrayList<Vector3f> normals = new ArrayList<Vector3f>();
    public ArrayList<Polygon> polygons = new ArrayList<Polygon>();



}
