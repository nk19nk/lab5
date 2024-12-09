import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //1.1
        System.out.println("Задание 1.1");
        System.out.println("Введите дробь");
        System.out.print("числитель: ");
        int ch;
        while (true) {
            if (in.hasNextInt()) {
                ch=in.nextInt();
                break;
            } else {
                System.out.println("Ошибка: введите целое число!");
                in.next();
            }
        }
        System.out.print("знаменатель: ");
        int zn;
        while (true) {
            if (in.hasNextInt()) {
                zn=in.nextInt();
                break;
            } else {
                System.out.println("Ошибка: введите целое число!");
                in.next();
            }
        }
        System.out.println("Введенная дробь:");
        Fraction f = new Fraction(ch, zn);
        System.out.println(f);

        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("0) Выход");
            System.out.println("1) Изменить числитель");
            System.out.println("2) Изменить знаменатель");
            System.out.println("3) Привести дробь к вещественному числу");
            System.out.print("Введите номер операции: ");
            int oper = 0;
            while (true) {
                if (in.hasNextInt()) {
                    oper = in.nextInt();
                    if (oper < 0 || oper > 3) {
                        System.out.println("Операции с таким номером нет!");
                        continue;
                    }
                    break;
                } else {
                    System.out.println("Введите целое число!");
                    in.next();
                }
            }

            if (oper == 0) {
                break;
            }

            if (oper == 1) {
                System.out.print("Введите новый числитель: ");
                int newch;
                while (true) {
                    if (in.hasNextInt()) {
                        newch = in.nextInt();
                        break;
                    } else {
                        System.out.println("Ошибка: введите целое число!");
                        in.next();
                    }
                }
                System.out.print("Новая дробь: ");
                f.setChisl(newch);
                System.out.println(f);
            }

            if (oper == 2) {
                System.out.print("Введите новый знаменатель: ");
                int newzn;
                while (true) {
                    if (in.hasNextInt()) {
                        newzn = in.nextInt();
                        break;
                    } else {
                        System.out.println("Ошибка: введите целое число!");
                        in.next();
                    }
                }
                System.out.print("Новая дробь: ");
                f.setZnam(newzn);
                System.out.println(f);
            }

            if (oper == 3) {
                System.out.println("Вещественное число: " + f.doublevalue());
            }
        }

        //2.1
        System.out.println("Задание 2.1");
        System.out.print("Введите имя кота: ");
        String name = in.nextLine();
        Cat cat = new Cat(name);
        System.out.print("Сколько раз кот должен мяукнуть? ");
        int kolv;
        while (true) {
            if (in.hasNextInt()) {
                kolv = in.nextInt();
                if (kolv > 0){
                    break;
                } else{
                    System.out.print("Введите положительное число: ");
                }
            } else {
                System.out.print("Введите корректное число: ");
                in.next();
            }
        }

        List<Meowable> meowables = new ArrayList<>();
        meowables.add(cat);

        System.out.println("Кот начинает мяукать...");
        for (int i = 0; i < kolv; i++) {
            Funs.meowsCare(meowables);
        }
        System.out.println(cat + " мяукал " + cat.getCount() + " раз(а).");
    }
}