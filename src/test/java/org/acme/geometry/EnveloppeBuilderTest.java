package org.acme.geometry;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.acme.geometry.CoordinateTest.EPSILON;

public class EnveloppeBuilderTest {
    @Test
    public void testInsert(){
        EnveloppeBuilder envB = new EnveloppeBuilder();
        envB.insert(new Coordinate(2.0,3.0));
        Assert.assertEquals(2.0, envB.getxVals().get(0), EPSILON);
        Assert.assertEquals(3.0, envB.getyVals().get(0), EPSILON);

    }
    @Test
    public void testBuild(){
        EnveloppeBuilder envB = new EnveloppeBuilder();
        envB.insert(new Coordinate(2.0,3.0));
        envB.insert(new Coordinate(-1.0,1.0));
        Enveloppe env = envB.build();
        Boolean bool = env.isEmpty();
        Assert.assertEquals(-1.0,env.getXmin(),EPSILON);
        Assert.assertEquals(1.0,env.getYmin(),EPSILON);
        Assert.assertEquals(2.0,env.getXmax(),EPSILON);
        Assert.assertEquals(3.0,env.getYmax(),EPSILON);
        Assert.assertFalse(bool);
    }

    @Test
    public void testDefaultConstructorEnveloppe(){
        Enveloppe env = new Enveloppe();
        Assert.assertTrue(env.isEmpty());
    }

}
