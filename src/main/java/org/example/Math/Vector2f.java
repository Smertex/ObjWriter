package org.example.Math;


import java.util.Objects;

public class Vector2f {
    private float x, y;

    public Vector2f(float x, float y) {
        setX(x);
        setY(y);
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2f vector2f = (Vector2f) o;
        return Float.compare(x, vector2f.x) == 0 && Float.compare(y, vector2f.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
