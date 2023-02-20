public class lab16 {
    public static void main(String[] args) {
        double[] arr1 = {5, 6, 7, 8, 9};
        System.out.println(average(arr1[0], arr1[1], arr1[2], arr1[3], arr1[4]));

        // при отсутствии хотя бы одного параметра будет ошибка
        //System.out.println(average());

        double[] arr2 = {1};
        System.out.println(average(arr2[0]));
    }

    public static double average(double first_value, double... values) {
        double sum = first_value;
        for (double v : values) sum += v;
        return sum / Math.max(1, 1+values.length);
    }
}