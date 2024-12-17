import java.util.List;

public class People {
    private final String name;
    private final List<Integer> marks;

    public People(String name, List<Integer> marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getMarks() {
        return marks;
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
