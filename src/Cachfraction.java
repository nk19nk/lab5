public class Cachfraction {
    private final Fraction fraction;
    private Double cachedValue = null;

    public Cachfraction(Fraction fraction) {
        this.fraction = fraction;
    }

    public double doublevalue() {
        if (this.cachedValue == null) {
            this.cachedValue = fraction.doublevalue();
        }
        return this.cachedValue;
    }

    public void updateNumerator(int a) {
        fraction.seta(a);
        this.cachedValue = null;
    }

    public void updateDenominator(int b) {
        fraction.setb(b);
        this.cachedValue = null;
    }

    public Fraction getFraction() {
        return this.fraction;
    }

    @Override
    public String toString() {
        return fraction.toString();
    }
}
