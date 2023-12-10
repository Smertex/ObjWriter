package org.example.Math;

public class Vector2f {
    private float x, y;
    public Vector2f(float x, float y) {
        setX(x);
        setY(y);
    }
    public void setX(float x){
        this.x = x;
    }
    public void setY(float y){
        this.y = y;
    }
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
