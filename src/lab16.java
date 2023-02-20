public class lab16 {
    public static void main(String[] args) {
        double[] arr1 = {5, 6, 7, 8, 9};
        System.out.println(average(arr1));

        double[] arr2 = {};
        System.out.println(average(arr2));

        double[] arr3 = {1};
        System.out.println(average(arr3));
    }

    public static double average(double... values) {
        double sum = 0;
        for (double v : values) sum += v;
        return sum / Math.max(1, values.length);
    }
}