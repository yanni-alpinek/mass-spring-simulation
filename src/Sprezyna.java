public class Sprezyna {

    private double stalaSprezystosciK;
    private double l0;
    private Kulka kulka;

    public Sprezyna(double stalaSprezystosciK, double l0, Kulka kulka) {
        this.stalaSprezystosciK = stalaSprezystosciK;
        this.l0 = l0;
        this.kulka = kulka;
    }


    public double getStalaSprezystosciK() {
        return stalaSprezystosciK;
    }

    public double getL0() {
        return l0;
    }

    public Kulka getKulka() {
        return kulka;
    }

    public void setKulka(Kulka kulka) {
        this.kulka = kulka;
    }
}
