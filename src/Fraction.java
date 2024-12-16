public class Fraction implements Frac{
    private int chisl;
    private int znam;

    public int getChisl(){
        return this.chisl;
    }

    public int getZnam(){
        return this.znam;
    }

    public int setChisl(int chisl) {
        this.chisl = chisl;
        return chisl;
    }

    public int setZnam(int znam) {
        if (znam == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        if (znam < 0) {
            this.chisl = -this.chisl;
            this.znam = -znam;
        } else {
            this.znam = znam;
        }
        return znam;
    }

    public Fraction(int chisl, int znam) {
        if (znam == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        if (znam < 0) {
            this.chisl = -chisl;
            this.znam = -znam;
        } else {
            this.chisl = chisl;
            this.znam = znam;
        }
    }

    public String toString() {
        return chisl + "/" + znam;
    }

    public double doublevalue() {
        return (double) chisl / znam;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fraction fracobj = (Fraction) obj;
        return this.chisl * fracobj.znam == fracobj.chisl * this.znam;
    }
}

