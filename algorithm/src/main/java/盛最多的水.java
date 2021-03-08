public class 盛最多的水 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 2, 3, 4, 5, 2}));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
