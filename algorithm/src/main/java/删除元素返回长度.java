public class 删除元素返回长度 {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
    }

    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
