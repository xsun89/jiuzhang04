public class Main {

    public static void main(String[] args) {
        Solutions solutions = new Solutions();
        System.out.println(solutions.climbStairs(3));

        calculateMaxByRecursive(2);
    }

    /**
     * ͨ���ݹ����������и��㷨
     * @author Aaron
     * 2015��8��3��
     */
    private static void calculateMaxByRecursive(int n) {
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        Solutions solutions = new Solutions();
        int max = solutions.getMax(p, n);

        System.out.println("max = " + max);
    }
}
