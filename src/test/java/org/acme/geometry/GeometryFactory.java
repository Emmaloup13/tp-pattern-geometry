package org.acme.geometry;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;

public class GeometryFactory {
    public static Coordinate createCoordinate(){
        return  new Coordinate(3.0,4.0);
    }

    public static Point createPoint(){
        return new Point(createCoordinate());
    }

    public static LineString createLineString(){
        List<Point> points = new ArrayList<>();
        Point p1 = new Point(new Coordinate(1.0,2.0));
        for (int i = 0; i < 10; i++) {
            points.add(new Point(new Coordinate(p1.getCoordinate().getX()+1.0, p1.getCoordinate().getY()+1.0)));
        }
        return new LineString(points) ;
    }
}
