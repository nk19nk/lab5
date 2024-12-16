public class Cachfraction extends Fraction {
    private Double doubval;

    public Cachfraction(int chis, int znam) {
        super(chis, znam);
    }

    public double doublevalue() {
        if (doubval == null) {
            doubval = (double) getChisl() / getZnam();
        }
        return doubval;
    }

    public int setChisl(int chisl) {
        doubval = null;
        return super.setChisl(chisl);
    }

    public int setZnam(int znam) {
        doubval = null;
        return super.setZnam(znam);
    }
}
