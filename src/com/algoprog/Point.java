package com.algoprog;

class Point {
    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(String x, String y, String z) {
        this.x = Double.parseDouble(x);
        this.y = Double.parseDouble(y);
        this.z = Double.parseDouble(z);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double distance(Point other) {
        return Math.sqrt(
                Math.pow(x-other.getX(),2)+
                        Math.pow(y-other.getY(),2)+
                        Math.pow(z-other.getZ(),2)
        );
    }

    @Override
    public boolean equals(Object o) {
        Point other = (Point) o;
        return x == other.getX() && y == other.getY() && z == other.getZ();
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
