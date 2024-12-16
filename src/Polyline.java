import java.util.ArrayList;
import java.util.List;

public class Polyline {
    private List<Point> points;

    public Polyline() {
        this.points = new ArrayList<>();
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public List<Point> getPoints() {
        return points;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Линия: ");
        for (int i = 0; i < points.size(); i++) {
            sb.append(points.get(i).getPointString());
            if (i < points.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}

