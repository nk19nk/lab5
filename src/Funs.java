import java.util.Collection;

public class Funs {
    public static void meowables(Collection<Meowable> meowables) {
        for (Meowable cat : meowables) {
            cat.meow();
        }
    }
}
