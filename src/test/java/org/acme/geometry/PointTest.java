package org.acme.geometry;


import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    public static final double EPSILON = 1.0e-15;

    @Test
    public void testDefaultConstructor(){
        Point p = new Point();
        Assert.assertEquals(Double.NaN, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(Double.NaN, p.getCoordinate().getY(), EPSILON);
    }
    @Test
    public void testConstructorXY(){
        Coordinate c = GeometryFactory.createCoordinate();
        Point p = new Point(c);
        Assert.assertSame(c, p.getCoordinate());

    }

    @Test
    public void testGetType(){
        Point p = new Point();
        Assert.assertEquals("Point", p.getType());
    }

    @Test
    public void testIsEmpty(){
        Point p = new Point();
        Assert.assertTrue(p.isEmpty());
    }

    @Test
    public void testTranslate(){
        Point p = new Point(new Coordinate(3.0, 4.0));
        Point p2 = new Point(new Coordinate(5.0, 7.0));
        p.translate(2.0,3.0);
        Assert.assertEquals(p2.getCoordinate().getX(), p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(p2.getCoordinate().getY(), p.getCoordinate().getY(), EPSILON);

    }

    @Test
    public void testClone1(){
        Point p = new Point(new Coordinate(3.0, 4.0));
        Point p2 = p.clone();
        Assert.assertEquals(p.getCoordinate().getX(), p2.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(p.getCoordinate().getY(), p2.getCoordinate().getY(), EPSILON);
    }
    @Test
    public void testClone2(){
        Point p = new Point();
        Point p2 = p.clone();
        Assert.assertEquals(p.getCoordinate().getX(), p2.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(p.getCoordinate().getY(), p2.getCoordinate().getY(), EPSILON);
    }
}
