public class Polaczenie {

    private double punktMocowania;
    private Sprezyna sprezyna;
    private static final double G = 9.81;
    private static final double dt = 0.01;
    private double newV;
    private double newX;
    private double a;


    public Polaczenie(double punktMocowania, Sprezyna sprezyna) {
        this.punktMocowania = punktMocowania;
        this.sprezyna = sprezyna;
        this.newX = sprezyna.getKulka().getX();
    }

    public void setSprezyna(Sprezyna sprezyna) {
        this.sprezyna = sprezyna;
    }

    public void setX(double newX) {
        this.newX = newX;

    }

    public double getG() {
        return G;
    }

    public double getNewX() {
        return newX;
    }

    /**
     * Zwraca siłe ciężkości Fg = m * g
     */
    public double getFg() {
        return sprezyna.getKulka().getMass() * getG();
    }

    /**
     * Zwraca siłę sprężystosci Fs = -k * x
     */
    public double getFs() {
        double x = sprezyna.getKulka().getX() - sprezyna.getL0();
        return -sprezyna.getStalaSprezystosciK() * x;
    }

    /**
     * Zwraca siłę wypadkową Fw = Fg - Fs
     */
    public double getFw() {
        return getFg() + getFs();
    }

    public void update() {
         a = getFw() / sprezyna.getKulka().getMass();
         newV = sprezyna.getKulka().getV() + a * dt;
         newX = sprezyna.getKulka().getX() + newV * dt;
         sprezyna.setKulka(new Kulka(sprezyna.getKulka().getMass(), newX, newV));
    }
}
