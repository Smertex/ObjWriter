package org.example.Math;

public class Vector2f {
    private float x, y;
    public Vector2f(float x, float y) {
        setXY(x, y);
    }
    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
