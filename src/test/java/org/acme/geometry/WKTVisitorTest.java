package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WKTVisitorTest {
    @Test
    public void testVisitPoint(){
        WKTVisitor visitor = new WKTVisitor();
        Geometry geometry = new Point(new Coordinate(3.0,4.0));
        geometry.accept(visitor);
        Assert.assertEquals( "POINT(3.0 4.0)", visitor.getResult() );
    }

    @Test
    public void testVisitLineString(){
        WKTVisitor visitor = new WKTVisitor();
        Point a = new Point(new Coordinate(3.0, 4.0));
        Point b = new Point(new Coordinate(0.0, 0.0));
        List<Point> points = new ArrayList<>();
        points.add(a);
        points.add(b);
        Geometry geometry = new LineString(points);
        geometry.accept(visitor);
        Assert.assertEquals( "LINESTRING(3.0 4.0,0.0 0.0)", visitor.getResult() );
    }
}
