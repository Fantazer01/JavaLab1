
import java.util.Scanner;

public class Task15_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите n:");
        int n = in.nextInt();

        int[][] s = new int [n][];
        for (int i = 0; i < n; i++) {
            s[i] = new int[i+1];
            s[i][0] = 1;
            for (int j = 1; j < i; j++)
                s[i][j] = s[i-1][j-1] + s[i-1][j];
            s[i][i] =  1;
        }

        // найдём самое широкое число
        // по свойству треугольника Паскаля, это число в середине нижнего ряда
        int maxNum = s[n - 1][(n - 1)/2];
        int maxNumWidth = Integer.toString(maxNum).length();

        // теперь цикл вывода
        for (int i = 0; i < n; i++) {
            // насколько ширина данной колонки не дотягивает до наибольшей?
            // для центрирования делим пополам
            int stringPad = (n - 1 - i) * (maxNumWidth + 1) / 2;
            if (stringPad > 0) // не нашёл лучше способа создать строку пробелов
                System.out.print(String.format("%" + stringPad + "s", ""));
            for (int j = 0; j <= i; j++) {
                String paddedNum = Integer.toString(s[i][j]);
                // центрируем число в своей колонке тоже
                int totalPad = maxNumWidth - paddedNum.length();
                int rPad = totalPad / 2;
                if (rPad > 0)
                    paddedNum = String.format("%s%" + rPad + "s", paddedNum, "");
                int lPad = totalPad - rPad;
                if (lPad > 0)
                    paddedNum = String.format("%" + lPad + "s%s", "", paddedNum);
                System.out.print(paddedNum);
                if (j < i)
                    System.out.print(" ");
                else
                    System.out.println();
            }
        }
    }
}