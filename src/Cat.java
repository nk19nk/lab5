public class Cat implements Meowable{
    private final String name;
    private int count = 0;

    int getCount() {
        return count;
    }

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        count++;
        System.out.println(name + ": мяу!");
    }

    public String toString() {
        return "кот: " + name;
    }
}
