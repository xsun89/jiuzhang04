public class Main {

    public static void main(String[] args) {
        Solutions solutions = new Solutions();
        System.out.println(solutions.climbStairs(3));

        calculateMaxByRecursive(2);
    }

    /**
     * 通过递归计算钢条的切割算法
     * @author Aaron
     * 2015年8月3日
     */
    private static void calculateMaxByRecursive(int n) {
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        Solutions solutions = new Solutions();
        int max = solutions.getMax(p, n);

        System.out.println("max = " + max);
    }
}
