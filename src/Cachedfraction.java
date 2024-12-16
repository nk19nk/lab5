public class Cachedfraction {
    private final Fraction fraction;
    private Double cached = null;

    public Cachedfraction(Fraction fraction) {
        this.fraction = fraction;
    }

    public double doublevalue() {
        if (this.cached == null) {
            this.cached = fraction.doublevalue();
        }
        return this.cached;
    }

    public void updatechisl(int chisl) {
        fraction.setChisl(chisl);
        this.cached = null;
    }

    public void updateznam(int znam) {
        fraction.setZnam(znam);
        this.cached = null;
    }

    public Fraction getFraction() {
        return this.fraction;
    }

    public String toString() {
        return fraction.toString();
    }
}