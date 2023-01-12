package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

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

    @Test
    public void testGetEnveloppe(){
        Point p = new Point(new Coordinate(3.0, 4.0));
        Enveloppe env = p.getEnveloppe();
        Assert.assertEquals(3.0, env.getXmin(), EPSILON);
        Assert.assertEquals(3.0, env.getXmax(), EPSILON);
        Assert.assertEquals(4.0, env.getYmin(), EPSILON);
        Assert.assertEquals(4.0, env.getYmax(), EPSILON);
    }

    @Test
    public void testAccept() throws UnsupportedEncodingException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);

        Geometry geometry = new Point(new Coordinate(3.0, 4.0));
        geometry.accept(visitor);
        // result contiendra ce qui est écrit dans la console
        String result = os.toString("UTF-8");
        Assert.assertEquals("Je suis un point avec x=3.0 et y=4.0.",result.trim());
    }
}
