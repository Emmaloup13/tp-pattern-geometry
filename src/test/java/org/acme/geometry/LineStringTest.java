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
        Point a = new Point(new Coordinate(3.0, 4.0));
        Point b = new Point(new Coordinate(1.0, 0.0));
        List<Point> points = new ArrayList<>();
        points.add(a);
        points.add(b);
        LineString ls = new LineString(points);
        ls.translate(1.0,1.0);
        Assert.assertEquals(4.0,ls.getPointN(0).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(5.0,ls.getPointN(0).getCoordinate().getY(), EPSILON);

        Assert.assertEquals(2.0,ls.getPointN(1).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(1.0,ls.getPointN(1).getCoordinate().getY(), EPSILON);
    }

    @Test
    public void testClone1(){
        LineString ls = GeometryFactory.createLineString();
        LineString ls2 = ls.clone();
        for (int i = 0; i < ls.getNumPoints(); i++) {
            Point pi = ls.getPointN(i);
            Point pi2 = ls2.getPointN(i);
            Assert.assertEquals(pi.getCoordinate().getX(),pi2.getCoordinate().getX(), EPSILON);
            Assert.assertEquals(pi.getCoordinate().getY(),pi2.getCoordinate().getY(),EPSILON);
        }
    }

    @Test
    public void testClone2(){
        LineString ls = new LineString();
        LineString ls2 = ls.clone();
        for (int i = 0; i < ls.getNumPoints(); i++) {
            Point pi = ls.getPointN(i);
            Point pi2 = ls2.getPointN(i);
            Assert.assertEquals(pi.getCoordinate().getX(),pi2.getCoordinate().getX(), EPSILON);
            Assert.assertEquals(pi.getCoordinate().getY(),pi2.getCoordinate().getY(),EPSILON);
        }
    }

    @Test
    public void testGetEnveloppe(){
        Point a = new Point(new Coordinate(-3.0, 4.0));
        Point b = new Point(new Coordinate(1.0, 0.0));
        List<Point> points = new ArrayList<>();
        points.add(a);
        points.add(b);
        LineString ls = new LineString(points);
        Enveloppe env = ls.getEnveloppe();
        Assert.assertEquals(-3.0, env.getXmin(), EPSILON);
        Assert.assertEquals(1.0, env.getXmax(), EPSILON);
        Assert.assertEquals(0.0, env.getYmin(), EPSILON);
        Assert.assertEquals(4.0, env.getYmax(), EPSILON);
    }
}
