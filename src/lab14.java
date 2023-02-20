//Напиши программу на java, используя динамический массив:
//        Напишите программу, вводящую двумерный массив целочисленных значений
//        и определяющую, содержится ли в нем магический квадрат (т.е. одинаковая
//        сумма значений во всех строках, столбцах и диагоналях). Принимая строки
//        вводимых данных, разбивайте их на отдельные целочисленные значения, прекратив этот процесс, когда пользователь введет пустую строку. Например, на
//        следующие вводимые данные:
//        16 3 2 13
//        3 10 11 8
//        9 6 7 12
//        4 15 14 1
//        (Пустая строка)

import  java.util.*;
import java.util.stream.Collectors;

public class lab14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<List<Integer>> matrix = new ArrayList<>();
        int minX = Integer.MAX_VALUE;
        int minY = 0;

        // Ввод массива
        System.out.println("Введите массив:");
        String str = in.nextLine();
        while (!str.isEmpty()) {
            String[] numbers = str.trim().split("\\s+");

            matrix.add(Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));

            if (minX > numbers.length) minX = numbers.length;
            minY++;
            str = in.nextLine();
        }

        // Проверка на магические квадраты
        boolean isMagicSquare = checkMatrix(matrix, minX, minY);
        if (isMagicSquare) {
            System.out.println("Магический квадрат");
        } else {
            System.out.println("Не магический квадрат");
        }
    }

    public static boolean checkMatrix(List<List<Integer>> matrix, int minX, int minY) {
        //проходимся по всей матрице
        for (int x = 0; x < minX; x++) {
            for (int y = 0; y < minY; y++) {
                //выбираем все стороны
                for (int size = 2; size <= Math.min(minX - x, minY - y); size++) {
                    //просматриваем квадрат по определенным координатам с определенной стороной
                    if (checkMagicSquare(matrix, x, y, size)) return true;
                }
            }
        }
        return false;
    }

    public static boolean checkMagicSquare(List<List<Integer>> matrix, int x, int y, int size) {
        int countMagicValues = checkRightToLeftDiagonal(matrix, x, y, size);
        if (countMagicValues == checkLeftToRightDiagonal(matrix, x, y, size)) {
            for (int j = y; j < size + y; j++) {
                if (checkRow(matrix, x, j, size) != countMagicValues) {
                    return false;
                }
            }
            for (int i = x; i < size + x; i++) {
                if (checkColumn(matrix, i, y, size) != countMagicValues) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static int checkRow(List<List<Integer>> matrix, int x, int y, int size) {
        int countMagicValues = 0;
        for (int i = x; i < size + x; i++) {
            countMagicValues += matrix.get(y).get(i);
        }
        return countMagicValues;
    }

    public static int checkColumn(List<List<Integer>> matrix, int x, int y, int size) {
        int countMagicValues = 0;
        for (int j = y; j < size + y; j++) {
            countMagicValues += matrix.get(j).get(x);
        }
        return countMagicValues;
    }

    public static int checkRightToLeftDiagonal(List<List<Integer>> matrix, int x, int y, int size) {
        int countMagicValues = 0;
        for (int i = x, j = y; i < size + x && j < size + y; i++, j++) {
            countMagicValues += matrix.get(j).get(i);
        }
        return countMagicValues;
    }

    public static int checkLeftToRightDiagonal(List<List<Integer>> matrix, int x, int y, int size) {
        int countMagicValues = 0;
        for (int i = size + x - 1, j = size + y - 1; i >= x && j >= y; i--, j--) {
            countMagicValues += matrix.get(j).get(i);
        }
        return countMagicValues;
    }
}

