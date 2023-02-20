import java.util.ArrayList;
import java.util.Scanner;

public class lab15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите n:");
        int n = in.nextInt();
        ArrayList<ArrayList<Integer>> pascalTriangle = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    ArrayList<Integer> prevRow = pascalTriangle.get(i - 1);
                    int num = prevRow.get(j - 1) + prevRow.get(j);
                    row.add(num);
                }
            }
            pascalTriangle.add(row);
        }

        System.out.println("Трекгольник Паскаля");
        for (ArrayList<Integer> integers : pascalTriangle) {
            System.out.println(integers);
        }
    }
}