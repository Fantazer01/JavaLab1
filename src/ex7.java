package ch01.sec01;
import java.util.Scanner;
public class ex7 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите первое число: "); short var1 = (short) in.nextInt();
        System.out.print("Введите второе число: "); short var2 = (short) in.nextInt();
        System.out.printf("Первое число как short:       %6d , и как int: %10d\n",
                var1, (0x0000FFFF & var1));
        System.out.printf("Второе число как short:       %6d , и как int: %10d\n",
                var2, (0x0000FFFF & var2));
        short sum = (short) ((0x0000FFFF & var1)  + (0x0000FFFF & var2));
        System.out.printf("Сумма чисел как short:        %6d , и как int: %10d\n",
                sum, (0x0000FFFF & var1) + (0x0000FFFF & var2));
        short diff = (short) ((0x0000FFFF & var1) - (0x0000FFFF & var2));
        System.out.printf("Разность чисел как short:     %6d , и как int: %10d\n",
                diff, (0x0000FFFF & var1) - (0x0000FFFF & var2));
        short mult = (short) ((0x0000FFFF & var1) * (0x0000FFFF & var2));
        System.out.printf("Произведение чисел как short: %6d , и как int: %10d\n",
                mult, (0x0000FFFF & var1) * (0x0000FFFF & var2));
        short div = (short) ((0x0000FFFF & var1) / (0x0000FFFF & var2));
        System.out.printf("Частное чисел как short:      %6d , и как int: %10d\n",
                div, (0x0000FFFF & var1) / (0x0000FFFF & var2));
        short rem = (short) ((0x0000FFFF & var1) % (0x0000FFFF & var2));
        System.out.printf("Остаток от деления как short: %6d , и как int: %10d\n",
                rem, (0x0000FFFF & var1) % (0x0000FFFF & var2));

    }
}
