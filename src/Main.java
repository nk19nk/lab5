import java.io.*;
import java.util.*;

public class Main {
    //3.4
    public static <T> List<T> addAfter(List<T> L, T E) {
        if (L == null || L.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть пустым или null");
        }

        int index = L.indexOf(E);
        if (index == -1) {
            throw new IllegalArgumentException("Элемента нет в списке");
        }

        List<T> newL = new ArrayList<>(L);
        newL.addAll(index + 1, L);
        return newL;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //1.1
//        System.out.println("Задание 1.1");
//        System.out.println("Введите дробь");
//        System.out.print("числитель: ");
//        int ch;
//        while (true) {
//            if (in.hasNextInt()) {
//                ch=in.nextInt();
//                break;
//            } else {
//                System.out.println("Ошибка: введите целое число!");
//                in.next();
//            }
//        }
//        System.out.print("знаменатель: ");
//        int zn;
//        while (true) {
//            if (in.hasNextInt()) {
//                zn=in.nextInt();
//                break;
//            } else {
//                System.out.println("Ошибка: введите целое число!");
//                in.next();
//            }
//        }
//        System.out.println("Введенная дробь:");
//        Fraction f = new Fraction(ch, zn);
//        System.out.println(f);
//
//        while (true) {
//            System.out.println("Выберите операцию:");
//            System.out.println("0) Выход");
//            System.out.println("1) Изменить числитель");
//            System.out.println("2) Изменить знаменатель");
//            System.out.println("3) Привести дробь к вещественному числу");
//            System.out.print("Введите номер операции: ");
//            int oper = 0;
//            while (true) {
//                if (in.hasNextInt()) {
//                    oper = in.nextInt();
//                    if (oper < 0 || oper > 3) {
//                        System.out.println("Операции с таким номером нет!");
//                        continue;
//                    }
//                    break;
//                } else {
//                    System.out.println("Введите целое число!");
//                    in.next();
//                }
//            }
//
//            if (oper == 0) {
//                break;
//            }
//
//            if (oper == 1) {
//                System.out.print("Введите новый числитель: ");
//                int newch;
//                while (true) {
//                    if (in.hasNextInt()) {
//                        newch = in.nextInt();
//                        break;
//                    } else {
//                        System.out.println("Ошибка: введите целое число!");
//                        in.next();
//                    }
//                }
//                System.out.print("Новая дробь: ");
//                f.setChisl(newch);
//                System.out.println(f);
//            }
//
//            if (oper == 2) {
//                System.out.print("Введите новый знаменатель: ");
//                int newzn;
//                while (true) {
//                    if (in.hasNextInt()) {
//                        newzn = in.nextInt();
//                        break;
//                    } else {
//                        System.out.println("Ошибка: введите целое число!");
//                        in.next();
//                    }
//                }
//                System.out.print("Новая дробь: ");
//                f.setZnam(newzn);
//                System.out.println(f);
//            }
//
//            if (oper == 3) {
//                System.out.println("Вещественное число: " + f.doublevalue());
//            }
//        }
//
//        //2.1
//        System.out.println("Задание 2.1");
//        System.out.print("Введите имя кота: ");
//        String name = in.nextLine();
//        Cat cat = new Cat(name);
//        List<Meowable> meowables = new ArrayList<>();
//        meowables.add(cat);
//        System.out.print("Сколько раз кот должен мяукнуть? ");
//        int kolv;
//        while (true) {
//            if (in.hasNextInt()) {
//                kolv = in.nextInt();
//                if (kolv > 0){
//                    break;
//                } else {
//                    System.out.print("Введите положительное число: ");
//                }
//            } else {
//                System.out.print("Введите корректное число: ");
//                in.next();
//            }
//        }
//
//        System.out.println("Кот начинает мяукать ...");
//        for (int i = 0; i < kolv; i++) {
//            Funs.meowables(meowables);
//        }
//        System.out.println(cat + " мяукал " + cat.getCount() + " раз(а)");
//
//
//        //3.4
//        System.out.println("Задание 3.4");
//        try {
//            System.out.println("Введите элементы списка через пробел:");
//            String input = in.nextLine();
//            String[] elements = input.split(" ");
//            List<String> list = new ArrayList<>();
//            for (String el : elements) {
//                list.add(el);
//            }
//            System.out.println("Введенный список:");
//            System.out.println(list);
//            System.out.println("Введите элемент, после которого надо вставить копию списка:");
//            String element = in.nextLine();
//            List<String> newList = addAfter(list, element);
//            System.out.println("Новый список: " + newList);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }
//
//        //4.4
//        System.out.println("Задание 4.4");
//        String file = "src/file.txt";
//        Map<String, List<Integer>> people = new HashMap<>();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            String n1 = reader.readLine();
//            if (n1 == null || n1.isEmpty()) {
//                System.out.println("Файл пустой");
//                return;
//            }
//            int n;
//            try {
//                n = Integer.parseInt(n1);
//                if (n <= 0 || n > 500) {
//                    System.out.println("Количество абитуриентов не может быть отрицательным или больше 500");
//                    return;
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Неверный формат количества абитуриентов");
//                return;
//            }
//
//            for (int i = 0; i < n; i++) {
//                String line = reader.readLine();
//                if (line == null || line.isEmpty()) {
//                    System.out.println("В файле нет " + n + " абитуриентов");
//                    return;
//                }
//                String[] mas = line.split(" ");
//                if (mas.length != 4) {
//                    System.out.println("Неверный формат строки: " + line);
//                    return;
//                }
//
//                String name = mas[0] + " " + mas[1];
//                List<Integer> marks = Arrays.asList(Integer.parseInt(mas[2]), Integer.parseInt(mas[3]));
//                people.put(name, marks);
//            }
//
//
//            System.out.println("Абитуриенты, не допущенные к экзаменам:");
//            for (Map.Entry<String, List<Integer>> entry : people.entrySet()) {
//                List<Integer> marks = entry.getValue();
//                int mark1 = marks.get(0);
//                int mark2 = marks.get(1);
//                if (mark1 < 30 || mark2 < 30) {
//                    System.out.println(entry.getKey());
//                }
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println("Файл не найден: " + file);
//        } catch (IOException e) {
//            System.out.println("Ошибка при чтении файла: " + e.getMessage());
//        }
//
//
        //5.4
        System.out.println("Задание 5.4");
        List<Character> list = Arrays.asList('к', 'п', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ');
        Set<Character> letters = new HashSet<>(list);
        String file2 = "src/file2.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(file2))) {
            String line;
            Set<Character> rez = null; // Множество для глухих согласных

            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\s+");
                for (int i = 0; i < words.length; i++) {
                    if ((i + 1) % 2 != 0) {
                        Set<Character> curcharacters = new HashSet<>();
                        for (char j : words[i].toCharArray()) {
                            if (letters.contains(j)) {
                                curcharacters.add(j);
                            }
                        }
                        if (rez == null) {
                            rez = new HashSet<>(curcharacters);
                        } else {
                            Set<Character> chars = new HashSet<>();
                            for (char j : rez) {
                                if (curcharacters.contains(j)) {
                                    chars.add(j);
                                }
                            }
                            rez = chars;
                        }
                    }
                }
            }

            if (rez == null || rez.isEmpty()) {
                System.out.println("Нет глухих согласных");
            } else {
                List<Character> sortrez = new ArrayList<>(rez);
                Collections.sort(sortrez);
                System.out.println("Глухие согласные, которые входят в каждое нечетное слово:");
                for (char i : sortrez) {
                    System.out.println(i);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + file2);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }


//        //6.4
//        Queue<Object> queue = new LinkedList<>();
//        // Ввод элементов очереди
//        while (queue.isEmpty()) {
//            System.out.println("Введите данные через пробел:");
//            String input = in.nextLine();
//            if (!input.trim().isEmpty()) {
//                String[] elements = input.split(" ");
//                queue.addAll(Arrays.asList(elements));
//            }
//        }
//
//        int i;
//        while (true) {
//            System.out.println("Введите индекс i (начало диапазона):");
//            if (in.hasNextInt()) {
//                i = in.nextInt();
//                if (i < 0 || i >= queue.size()) {
//                    System.out.println("Индекс должен быть в диапазоне от 0 до " + (queue.size() - 1));
//                } else {
//                    break;
//                }
//            } else {
//                System.out.println("Введите корректное целое число");
//                in.next();
//            }
//        }
//
//        int j;
//        while (true) {
//            System.out.println("Введите индекс j (конец диапазона):");
//            if (in.hasNextInt()) {
//                j = in.nextInt();
//                if (j <= i || j >= queue.size()) {
//                    System.out.println("Индекс должен быть больше i и меньше " + queue.size());
//                } else {
//                    break;
//                }
//            } else {
//                System.out.println("Введите корректное целое число");
//                in.next();
//            }
//        }
//
//        // Проверка равенства элементов в диапазоне [i, j]
//        LinkedList<Object> list = new LinkedList<>(queue);
//        boolean flag = true;
//        for (int k = i; k < j; k++) {
//            if (!list.get(k).equals(list.get(k + 1))) {
//                flag = false;
//                break;
//            }
//        }
//        if (flag) {
//            System.out.println("Элементы диапазона равны");
//        } else {
//            System.out.println("Элементы диапазона не равны");
//        }
    }
}