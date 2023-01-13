package org.acme.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnveloppeBuilder {
    private List<Double> xVals = new ArrayList<Double>();
    private List<Double> yVals = new ArrayList<Double>();

    public void insert(Coordinate coordinate){
      this.xVals.add(coordinate.getX());
      this.yVals.add(coordinate.getY());
    }

    public Enveloppe build(){
        double xmin = Collections.min(xVals);
        double xmax = Collections.max(xVals);
        double ymin = Collections.min(yVals);
        double ymax = Collections.max(yVals);
        Coordinate bottomLeft = new Coordinate(xmin,ymin);
        Coordinate topRight = new Coordinate(xmax,ymax);
        return new Enveloppe(bottomLeft, topRight);
    }

    public List<Double> getxVals() {
        return xVals;
    }

    public List<Double> getyVals() {
        return yVals;
    }
}
