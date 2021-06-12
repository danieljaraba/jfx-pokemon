package model.classes;

import model.abstractClasses.Pokemon;

import java.io.Serializable;

/**
 * The type Game object.
 */
public class GameObject  implements Serializable {

    private double x1;
    private double x2;
    private double y1;
    private double y2;
    private boolean transferable;
    private boolean pokemon;


    /**
     * Instantiates a new Game object.
     *
     * @param x1           the x 1
     * @param x2           the x 2
     * @param y1           the y 1
     * @param y2           the y 2
     * @param transferable the transferable
     * @param nearConst    the near const
     * @param pokemon      the pokemon
     */
    public GameObject(double x1, double x2, double y1, double y2, boolean transferable, double nearConst, boolean pokemon){
        this.x1 = x1 - nearConst;
        this.y1 = y1 - nearConst;
        this.x2 = x2 + nearConst;
        this.y2 = y2 + nearConst;
        this.transferable = transferable;
        this.pokemon = pokemon;
    }

    /**
     * Is near boolean.
     *
     * @param x the x
     * @param y the y
     * @return the boolean
     */
    public boolean isNear(double x, double y){
        boolean touch = false;
        if((x >= x1 && x <= x2 ) && (y >= y1 && y <= y2)){
            touch = true;
        }
        return touch;
    }

    /**
     * Execute option string.
     *
     * @return the string
     */
    public String executeOption(){
        if(pokemon == false){
            return "Method";
        }else{
            return "Pokemon";
        }
    }

    /**
     * Gets x 1.
     *
     * @return the x 1
     */
    public double getX1() {
        return x1;
    }

    /**
     * Sets x 1.
     *
     * @param x1 the x 1
     */
    public void setX1(double x1) {
        this.x1 = x1;
    }

    /**
     * Gets x 2.
     *
     * @return the x 2
     */
    public double getX2() {
        return x2;
    }

    /**
     * Sets x 2.
     *
     * @param x2 the x 2
     */
    public void setX2(double x2) {
        this.x2 = x2;
    }

    /**
     * Gets y 1.
     *
     * @return the y 1
     */
    public double getY1() {
        return y1;
    }

    /**
     * Sets y 1.
     *
     * @param y1 the y 1
     */
    public void setY1(double y1) {
        this.y1 = y1;
    }

    /**
     * Gets y 2.
     *
     * @return the y 2
     */
    public double getY2() {
        return y2;
    }

    /**
     * Sets y 2.
     *
     * @param y2 the y 2
     */
    public void setY2(double y2) {
        this.y2 = y2;
    }

    /**
     * Is transferable boolean.
     *
     * @return the boolean
     */
    public boolean isTransferable() {
        return transferable;
    }

    /**
     * Sets transferable.
     *
     * @param transferable the transferable
     */
    public void setTransferable(boolean transferable) {
        this.transferable = transferable;
    }

}
