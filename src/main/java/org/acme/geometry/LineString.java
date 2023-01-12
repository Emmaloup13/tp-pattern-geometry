package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry{
    private List<Point> points;

    public LineString(){
        this.points = new ArrayList<>();
    }

    public LineString(List<Point> points){

        this.points = points;
    }

    public int getNumPoints(){

        return this.points.size();
    }

    public Point getPointN(int n){

        return this.points.get(n);
    }
    @Override
    public String getType() {

        return "LineString";
    }

    @Override
    public Boolean isEmpty() {
        return points.isEmpty();
    }

    @Override
    public void translate(double dx, double dy) {
        for (int i = 0; i < points.size(); i++) {
            points.get(i).translate(dx, dy);
        }

    }

    @Override
    public LineString clone() {
        List<Point> points1 = new ArrayList<>();
        for (int i = 0; i < points.size();i++) {
            points1.add(points.get(i));
        }
        LineString ls2 = new LineString(points1);
        return ls2;
    }
}
