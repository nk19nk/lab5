import java.util.ArrayList;
import java.util.List;

public class Polyline {
    private List<Point> points;


    public Polyline(List<Point> points) {
        this.points = points;
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public List<Point> getPoints() {
        return points;
    }

    public String toString() {
        return "Ломаная линия " + points;
    }
}

