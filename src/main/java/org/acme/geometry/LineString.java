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
        for(Point p : points){
            p.translate(dx,dy);
        }
    }

    @Override
    public LineString clone() {
        List<Point> points1 = new ArrayList<>();
        for(Point p: points){
            points1.add(p);
        }
        return new LineString(points1);
    }

    @Override
    public Enveloppe getEnveloppe() {
        EnveloppeBuilder builder = new EnveloppeBuilder();
        for (int i = 0; i < getNumPoints(); i++) {
            builder.insert(getPointN(i).getCoordinate());
        }
        return builder.build();
    }

    @Override
    public void accept(GeometryVisitor visitor) {
            visitor.visit(this);
    }


}
