package org.acme.geometry;

public class Point implements Geometry{
    private Coordinate coordinate;

    public Point(){
        this.coordinate = new Coordinate();
    }

    public Point(Coordinate coordinate){
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String getType() {
        return "Point";
    }

    @Override
    public Boolean isEmpty() {
        return coordinate.isEmpty();
    }

    @Override
    public void translate(double dx, double dy) {
        if(!coordinate.isEmpty()) {
            Coordinate coordinate1 = new Coordinate(coordinate.getX() + dx, coordinate.getY() + dy);
            this.coordinate = coordinate1;
        }
    }

    @Override
    public Point clone() {
        return new Point(new Coordinate(coordinate.getX(), coordinate.getY()));
    }

    @Override
    public Enveloppe getEnveloppe() {
        return new Enveloppe(coordinate, coordinate);
    }

    @Override
    public void accept(GeometryVisitor visitor) {
            visitor.visit(this);
    }

}
