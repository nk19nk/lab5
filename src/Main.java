import java.io.*;
import java.util.*;

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
        List<Meowable> meowables = new ArrayList<>();
        meowables.add(cat);
        System.out.print("Сколько раз кот должен мяукнуть? ");
        int kolv;
        while (true) {
            if (in.hasNextInt()) {
                kolv = in.nextInt();
                if (kolv > 0){
                    break;
                } else {
                    System.out.print("Введите положительное число: ");
                }
            } else {
                System.out.print("Введите корректное число: ");
                in.next();
            }
        }

        System.out.println("Кот начинает мяукать ...");
        for (int i = 0; i < kolv; i++) {
            Funs.meowables(meowables);
        }
        System.out.println(cat + " мяукал " + cat.getCount() + " раз(а)");


        //3.2
        System.out.println("Задание 3.2");
        try {
            System.out.println("Введите элементы списка L через пробел:");
            String inputL = in.nextLine();
            String[] elemL = inputL.split(" ");
            List<String> L = new ArrayList<>(Arrays.asList(elemL));

            System.out.println("Введите элементы списка L1 через пробел:");
            String inputL1 = in.nextLine();
            String[] elemL1 = inputL1.split(" ");
            List<String> L1 = new ArrayList<>(Arrays.asList(elemL1));

            System.out.println("Введите элементы списка L2 через пробел:");
            String inputL2 = in.nextLine();
            String[] elemL2 = inputL2.split(" ");
            List<String> L2 = new ArrayList<>(Arrays.asList(elemL2));

            int index = Collections.indexOfSubList(L, L1);
            if (index != -1) {
                List<String> newL = new ArrayList<>(L.subList(0, index));
                newL.addAll(L2);
                newL.addAll(L.subList(index + L1.size(), L.size()));
                System.out.println("Новый список:");
                System.out.println(newL);
            } else {
                System.out.println("Списка L1 нет в L");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        //4.2
        System.out.println("Задание 4.2");
        String file = "src/file.txt";
        Map<String, List<Integer>> people = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String n1 = reader.readLine();
            if (n1 == null || n1.isEmpty()) {
                System.out.println("Файл пустой");
                return;
            }
            int n;
            try {
                n = Integer.parseInt(n1);
                if (n <= 0 || n > 250) {
                    System.out.println("Количество участников не может быть отрицательным или больше 250");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат количества участников");
                return;
            }

            for (int i = 0; i < n; i++) {
                String line = reader.readLine();
                if (line == null || line.isEmpty()) {
                    System.out.println("В файле нет " + n + " участников");
                    return;
                }
                String[] mas = line.split(" ");
                if (mas.length != 5) {
                    System.out.println("Неверный формат строки: " + line);
                    return;
                }

                String name1 = mas[0] + " " + mas[1];
                List<Integer> marks = Arrays.asList(Integer.parseInt(mas[2]), Integer.parseInt(mas[3]), Integer.parseInt(mas[4]));
                people.put(name1, marks);
            }
            int maximum = 0;
            System.out.println("Участники, набравшие максимальное количество баллов:");
            Map<String, Integer> rezpeople = new HashMap<>();
            for (Map.Entry<String, List<Integer>> i : people.entrySet()) {
                // Извлекаем имя участника и его баллы
                String name1 = i.getKey();
                List<Integer> marks = i.getValue();

                // Проверка диапазона баллов для каждого задания
                int mark1 = marks.get(0);
                int mark2 = marks.get(1);
                int mark3 = marks.get(2);

                if (mark1 < 0 || mark1 > 25 || mark2 < 0 || mark2 > 25 || mark3 < 0 || mark3 > 25) {
                    System.out.println("Баллы должны быть в диапазоне от 0 до 25, ошибка у участника: " + name1);
                    continue;
                }
                int sum = mark1 + mark2 + mark3;
                if (sum > maximum) {
                    maximum = sum;
                }
                rezpeople.put(name1, sum);
            }
            for (Map.Entry<String, Integer> i : rezpeople.entrySet()) {
                if (i.getValue() == maximum) {
                    System.out.println(i.getKey());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + file);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }


        //5.2
        System.out.println("Задание 5.2");
        List<Character> list = Arrays.asList('к', 'п', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ');
        Set<Character> letters = new HashSet<>(list);
        String file2 = "src/file2.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file2))) {
            String line;
            Set<Character> use = new HashSet<>();
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\s+");
                for (String word : words) {
                    for (char i : word.toCharArray()) {
                        if (letters.contains(i)) {
                            use.add(i);
                        }
                    }
                }
            }
            letters.removeAll(use);
            if (use.isEmpty()) {
                System.out.println("Нет глухих согласных");
            } else {
                List<Character> rez = new ArrayList<>(letters);
                Collections.sort(rez);
                System.out.println("Глухие согласные, которые не входят ни в одно слово:");
                for (char i : rez) {
                    System.out.println(i);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + file2);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }

        //6.2
        System.out.println("Задание 6.2");
        System.out.println("Введите элементы списка (целые числа), для завершения ввода введите 'stop':");
        List<Integer> L = new ArrayList<>();
        while (true) {
            if (in.hasNextInt()) {
                int num = in.nextInt();
                L.add(num);
            } else {
                String input = in.next();
                if (input.equals("stop")) {
                    break;
                } else {
                    System.out.println("Введите либо целое число, либо 'stop' для завершения ввода");
                }
            }
        }
        in.nextLine();

        if (L.isEmpty()) {
            System.out.println("Очередь пуста. Завершение программы.");
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Integer i : L) {
            queue.add(i);
        }
        for (int i = L.size() - 1; i >= 0; i--) {
            queue.add(L.get(i));
        }
        System.out.println("Полученная очередь:");
        for (Integer i : queue) {
            System.out.print(i + " ");
        }
        System.out.println();
        in.close();
    }
}