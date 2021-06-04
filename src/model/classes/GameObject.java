package model.classes;

import java.io.Serializable;

public class GameObject  implements Serializable {

    private double x1;
    private double x2;
    private double y1;
    private double y2;
    private boolean transferable;


    public GameObject(double x1, double x2, double y1, double y2, boolean transferable, double nearConst){
        this.x1 = x1 + nearConst;
        this.y1 = y1 + nearConst;
        this.x2 = x2 + nearConst;
        this.y2 = y2 + nearConst;
        this.transferable = transferable;
    }

    public boolean isNear(double x, double y){
        boolean touch = false;
        if((x >= x1 && x <= x2 ) && (y >= y1 && y <= y2)){
            touch = true;
        }
        return touch;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public boolean isTransferable() {
        return transferable;
    }

    public void setTransferable(boolean transferable) {
        this.transferable = transferable;
    }

}
