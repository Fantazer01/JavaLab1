import java.util.Scanner;

public class Task3 {
    public void invoke()
    {
        Scanner in = new Scanner(System.in);
        int max, a;

        max = in.nextInt();
        for (int i = 0; i < 2; ++i)
        {
            a = in.nextInt();
            if (a > max)
                max = a;
            // тоже самое с медотом Math.max()
            // max = Math.max(max, a);
        }

        System.out.println(max);
    }

    private int abc(int el, int ... array)
    {
        int max = el;

        for (Integer i : array)
            if (max < i)
                max = i;

        return max;
    }
}
