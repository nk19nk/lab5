import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    //3.2
    public static List<String> replace(List<String> L, List<String> L1, List<String> L2) {
        int index = Collections.indexOfSubList(L, L1);
        if (index != -1) {
            List<String> newL = new ArrayList<>(L.subList(0, index));
            newL.addAll(L2);
            newL.addAll(L.subList(index + L1.size(), L.size()));
            return newL;
        } else {
            throw new IllegalArgumentException("Список L1 не найден в L");
        }
    }

    //4.2
    public static Map<String, List<Integer>> reader(String filePath) throws IOException {
        Map<String, List<Integer>> people = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String n1 = reader.readLine();
            if (n1 == null || n1.isEmpty()) {
                throw new IllegalArgumentException("Файл пустой.");
            }

            int n;
            try {
                n = Integer.parseInt(n1);
                if (n <= 0 || n > 250) {
                    throw new IllegalArgumentException("Количество участников должно быть от 1 до 250.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Неверный формат количества участников.");
            }

            for (int i = 0; i < n; i++) {
                String line = reader.readLine();
                if (line == null || line.isEmpty()) {
                    throw new IllegalArgumentException("В файле недостаточно строк для всех участников.");
                }

                String[] mas = line.split(" ");
                if (mas.length != 5) {
                    throw new IllegalArgumentException("Неверный формат строки: " + line);
                }

                String name = mas[0] + " " + mas[1];
                List<Integer> marks = new ArrayList<>();
                marks.add(Integer.parseInt(mas[2]));
                marks.add(Integer.parseInt(mas[3]));
                marks.add(Integer.parseInt(mas[4]));

                people.put(name, marks);
            }
        }
        return people;
    }

    //5.2
    public static List<Character> find(List<Character> list, String file) {
        Set<Character> letters = new HashSet<>(list);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
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
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + file);
            return Collections.emptyList(); // Возвращаем пустой список в случае ошибки
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            return Collections.emptyList(); // Возвращаем пустой список в случае ошибки
        }

        // Сортируем оставшиеся буквы
        List<Character> rez = new ArrayList<>(letters);
        Collections.sort(rez);

        return rez;
    }

    //6.2
    // Метод для создания очереди, содержащей элементы списка и его обратный порядок
    public static Queue<Integer> method(List<Integer> list) {
        Queue<Integer> queue = new LinkedList<>();
        for (Integer i : list) {
            queue.add(i);
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            queue.add(list.get(i));
        }
        return queue;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        //1.1
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
//        Fraction drob = new Fraction(ch, zn);
//        Cachedfraction f = new Cachedfraction(drob);
//        System.out.println(f);
//
//        while (true) {
//            System.out.println("Выберите операцию:");
//            System.out.println("0) Выход");
//            System.out.println("1) Изменить числитель");
//            System.out.println("2) Изменить знаменатель");
//            System.out.println("3) Привести дробь к вещественному числу");
//            System.out.print("Введите номер операции: ");
//            int oper = -1;
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
//                f.updatechisl(newch);
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
//                f.updateznam(newzn);
//                System.out.println(f);
//            }
//
//            if (oper == 3) {
//                System.out.println("Вещественное число: " + f.doublevalue());
//            }
//        }
//
//        //1.2
//        System.out.println("Задание 1.2");
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
//        //2.1
//        System.out.println("Задание 2.1");
//        try {
//            System.out.println("Введите элементы списка L через пробел:");
//            String inputL = in.nextLine();
//            String[] elemL = inputL.split(" ");
//            List<String> L = new ArrayList<>(Arrays.asList(elemL));
//
//            System.out.println("Введите элементы списка L1 через пробел:");
//            String inputL1 = in.nextLine();
//            String[] elemL1 = inputL1.split(" ");
//            List<String> L1 = new ArrayList<>(Arrays.asList(elemL1));
//
//            System.out.println("Введите элементы списка L2 через пробел:");
//            String inputL2 = in.nextLine();
//            String[] elemL2 = inputL2.split(" ");
//            List<String> L2 = new ArrayList<>(Arrays.asList(elemL2));
//
//            List<String> newL = replace(L, L1, L2);
//            System.out.println("Новый список:");
//            System.out.println(newL);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }

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

            List<String> newL = replace(L, L1, L2);
            System.out.println("Новый список:");
            System.out.println(newL);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        //4.2
        System.out.println("Задание 4.2");
        String file = "src/file.txt";
        Map<String, List<Integer>> people = new HashMap<>();

        try {
            people = reader(file);

            int maximum = 0;
            System.out.println("Участники, набравшие максимальное количество баллов:");

            Map<String, Integer> rezpeople = new HashMap<>();
            for (Map.Entry<String, List<Integer>> entry : people.entrySet()) {
                String name = entry.getKey();
                List<Integer> marks = entry.getValue();

                // Проверка диапазона баллов
                for (int mark : marks) {
                    if (mark < 0 || mark > 25) {
                        System.out.println("Баллы должны быть в диапазоне от 0 до 25, ошибка у участника: " + name);
                        return;
                    }
                }

                // Суммируем баллы участника
                int sum = marks.get(0) + marks.get(1) + marks.get(2);
                if (sum > maximum) {
                    maximum = sum;  // Обновляем максимальное значение
                }
                rezpeople.put(name, sum);
            }

            // Выводим участников с максимальными баллами
            for (Map.Entry<String, Integer> entry : rezpeople.entrySet()) {
                if (entry.getValue() == maximum) {
                    System.out.println(entry.getKey());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + file);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }


//        //5.2
//        System.out.println("Задание 5.2");
//        List<Character> list = Arrays.asList('к', 'п', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ');
//        String file2 = "src/file2.txt";
//        List<Character> rez = find(list, file2);
//        if (rez.isEmpty()) {
//            System.out.println("Нет глухих согласных");
//        } else {
//            System.out.println("Глухие согласные, которые не входят ни в одно слово:");
//            for (char i : rez) {
//                System.out.println(i);
//            }
//        }
//
//        //6.2
//        System.out.println("Задание 6.2");
//        System.out.println("Введите элементы списка (целые числа), для завершения ввода введите 'stop':");
//        List<Integer> L = new ArrayList<>();
//        while (true) {
//            if (in.hasNextInt()) {
//                int num = in.nextInt();
//                L.add(num);
//            } else {
//                String input = in.next();
//                if (input.equals("stop")) {
//                    break;
//                } else {
//                    System.out.println("Введите либо целое число, либо 'stop' для завершения ввода");
//                }
//            }
//        }
//        in.nextLine();
//
//        if (L.isEmpty()) {
//            System.out.println("Очередь пуста. Завершение программы.");
//            return;
//        }
//        Queue<Integer> queue = method(L);
//        System.out.println("Полученная очередь:");
//        for (Integer i : queue) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//
//        //7.1
//        List<Point> points = new ArrayList<>();
//        System.out.println("Введите количество точек:");
//        int amount = 0;
//        while (true) {
//            if (in.hasNextInt()) {
//                amount = in.nextInt();
//                if (amount <= 0) {
//                    System.out.println("Количество точек должно быть положительным числом!");
//                } else {
//                    break;
//                }
//            } else {
//                System.out.println("Введите целое число!");
//                in.next();
//            }
//        }
//        for (int i = 0; i < amount; i++) {
//            double x = 0;
//            double y = 0;
//            while (true) {
//                try {
//                    System.out.println("Введите координаты " + (i + 1) + " точки");
//                    System.out.println("Координата х: ");
//                    x = in.nextDouble();
//                    System.out.println("Координата у: ");
//                    y = in.nextDouble();
//                    break;
//                } catch (InputMismatchException e) {
//                    System.out.println("Введите целое число или дробное (нпр, 1.2)");
//                    in.next();
//                }
//            }
//            Point point = new Point(x, y);
//            points.add(point);
//        }
//
//        Polyline polyline = points.stream()
//                // Убираем дубликаты (по x и y)
//                .distinct()
//                // Отрицательные Y делаем положительными
//                .map(point -> new Point(point.getX(), Math.abs(point.getY())))
//                // Сортируем точки по координате X
//                .sorted(Comparator.comparingDouble(point -> point.getX()))
//                // Собираем результат в ломаную (Polyline)
//                .collect(Collectors.collectingAndThen(
//                        Collectors.toList(),
//                        pointList -> new Polyline(pointList)
//
//                ));
//
//        System.out.println(polyline);

        in.close();
    }
}