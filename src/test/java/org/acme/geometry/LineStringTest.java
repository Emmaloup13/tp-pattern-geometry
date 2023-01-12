package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;

public class LineStringTest {
    public static final double EPSILON = 1.0e-15;
    @Test
    public void testDefaultConstructor(){
        LineString ls = new LineString();
        Assert.assertEquals(0,ls.getNumPoints());
    }

    @Test
    public void testGetPoints(){
        Point a = new Point(new Coordinate(3.0, 4.0));
        Point b = new Point(new Coordinate(0.0, 0.0));
        List<Point> points = new ArrayList<>();
        points.add(a);
        points.add(b);
        LineString ls = new LineString(points);
        Assert.assertEquals(2,ls.getNumPoints());
        Assert.assertSame(a,ls.getPointN(0));
        Assert.assertSame(b, ls.getPointN(1));
    }

    @Test
    public void testGetType(){
       LineString ls = new LineString();
        Assert.assertEquals("LineString", ls.getType());
    }

    @Test
    public void testIsEmpty(){
        LineString ls = new LineString();
        Assert.assertTrue(ls.isEmpty());
    }

    @Test
    public void testTranslate(){
        LineString ls = GeometryFactory.createLineString();
        for (int i = 0; i < ls.getNumPoints(); i++) {
            Point pi = ls.getPointN(i);
            double xi = pi.getCoordinate().getX()+2.0;
            double yi = pi.getCoordinate().getY()+3.0;
            pi.translate(2.0,3.0);
            Assert.assertEquals(xi, pi.getCoordinate().getX(), EPSILON);
            Assert.assertEquals(yi, pi.getCoordinate().getY(), EPSILON);
        }
    }
}
