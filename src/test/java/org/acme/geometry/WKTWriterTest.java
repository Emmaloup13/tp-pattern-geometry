package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WKTWriterTest {
    @Test
    public void testWriter1(){
        Geometry g = new Point(new Coordinate(3.0,4.0));
        WKTWriter writer = new WKTWriter();
        Assert.assertEquals("POINT(3.0 4.0)", writer.write(g));
    }
    @Test
    public void testWriter2(){
        Geometry g = new Point();
        WKTWriter writer = new WKTWriter();
        Assert.assertSame("POINT EMPTY", writer.write(g));
    }
    @Test
    public void testWriter3(){
        Point a = new Point(new Coordinate(-3.0, 4.0));
        Point b = new Point(new Coordinate(1.0, 0.0));
        Point c = new Point(new Coordinate(2.0, 0.0));
        List<Point> points = new ArrayList<>();
        points.add(a);
        points.add(b);
        points.add(c);
        Geometry g = new LineString(points);
        WKTWriter writer = new WKTWriter();
        Assert.assertEquals("LINESTRING(-3.0 4.0,1.0 0.0,2.0 0.0)", writer.write(g));
    }
    @Test
    public void testWriter4(){
        Geometry g = new LineString();
        WKTWriter writer = new WKTWriter();
        Assert.assertSame("LINESTRING EMPTY", writer.write(g));
    }
}
