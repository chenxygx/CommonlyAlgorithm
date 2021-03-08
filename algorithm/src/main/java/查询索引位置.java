public class 查询索引位置 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 4, 6}, 6));
    }

    public static int searchInsert(int[] nums, int val) {
        int n = nums.length;
        int result = n, left = 0, right = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (val <= nums[mid]) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
