package org.acme.geometry;

public class Enveloppe {
    private Coordinate bottomLeft;
    private Coordinate topRight;

    public Enveloppe(){
        this.bottomLeft = new Coordinate();
        this.topRight = new Coordinate();
    }

    public Enveloppe(Coordinate bottomLeft, Coordinate topRight){
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Boolean isEmpty(){
        return bottomLeft.isEmpty() || topRight.isEmpty();
    }

    public double getXmin(){
        return bottomLeft.getX();
    }

    public double getXmax(){
        return topRight.getX();
    }

    public double getYmin(){
        return bottomLeft.getY();
    }

    public double getYmax(){
        return topRight.getY();
    }
}
