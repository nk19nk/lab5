import java.util.List;

public class People2 {
    private final People name;
    
    private final int summarks;

    public People2(People name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public int summarks() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum;
    }

    public boolean proverka() {
        for (int mark : marks) {
            if (mark < 0 || mark > 25) {
                return false;
            }
        }
        return true;
    }
}
