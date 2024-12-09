import java.util.Collection;

public class Funs {
    public static void meowsCare(Collection<Meowable> meowables) {
        for (Meowable meowable : meowables) {
            meowable.meow();
        }
    }
}
