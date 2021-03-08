import java.util.Scanner;

public class 获取数组最大值 {
    public static void main(String[] args) {
        int[] salary = {10, 20, 3, 4, 2, 6, 54, 5, 45, 32, 87, 92, 6, 7, 5, 343, 5, 45, 45, 543, 365};
        int max = salary[0];
        for (int i : salary) {
            if (max < i){
                max = i;
            }
        }
        System.out.println(max);
    }
}
