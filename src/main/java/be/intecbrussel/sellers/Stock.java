package be.intecbrussel.sellers;

public class Stock {
    private int iceRockets;
    private int cones;
    private int balls;
    private int magni;

    public Stock() {
        this.iceRockets = 5;
        this.cones = 5;
        this.balls = 5;
        this.magni = 5;
    }

    public Stock(int iceRockets, int cones, int balls, int magni) {
        this.iceRockets = iceRockets;
        this.cones = cones;
        this.balls = balls;
        this.magni = magni;
    }

    public int getIceRockets() {
        return iceRockets;
    }

    public void setIceRockets(int iceRockets) {
        this.iceRockets = iceRockets;
    }

    public int getCones() {
        return cones;
    }

    public void setCones(int cones) {
        this.cones = cones;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getMagni() {
        return magni;
    }

    public void setMagni(int magni) {
        this.magni = magni;
    }

    @Override
    public String toString() {
        return "Stock -> " +
                "Ice Rockets: " + iceRockets +
                " -> Cones: " + cones +
                " -> Balls: " + balls +
                " -> Magnum: " + magni;
    }
}
