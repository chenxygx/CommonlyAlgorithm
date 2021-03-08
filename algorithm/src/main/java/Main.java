import java.util.*;
import java.util.LinkedList;

/**
 * 测试使用
 *
 * @author chenx
 */
public class Main {
    public static void main(String[] args) {
        int[] initNumOrder = initNumOrder();
        int[] initNums = initNums();
        System.out.println(searchNumsMax(initNums)); //543
        System.out.println(removeElement(initNums, 3)); //20
        System.out.println(searchInsert(initNumOrder, 3)); //2
        System.out.println(maxArea(initNumOrder)); //10
        Arrays.stream(twoSum(initNumOrder, 11)).forEach(System.out::print); //34
        System.out.println("");
        selectSort(initNums);
        Arrays.stream(initNums).forEach(s -> {
            System.out.print(s + ",");
        });
    }

    //获取数组最大值
    public static int searchNumsMax(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }

    //移除元素
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
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

    //搜索插入位置
    public static int searchInsert(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int result = n;
        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            if (val <= nums[mid]) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    //盛最多的水
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
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

    //两数之和
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int compare = target - nums[i];
            if (map.containsKey(compare) && map.get(compare) != i) {
                return new int[]{i, map.get(compare)};
            }
        }
        throw new IllegalArgumentException("目标数据没有两数之和");
    }

    //选择排序
    public static void selectSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = minIndex + 1; j < nums.length; j++) {
                minIndex = nums[minIndex] > nums[j] ? j : minIndex;
            }
            swap(nums, minIndex, i);
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] initNumRandom() {
        List<Integer> list = new LinkedList<>();
        Random random = new Random(10);
        for (int i = 0; i < 50; i++) {
            list.add(random.nextInt(100));
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static int[] initNumOrder() {
        return new int[]{1, 2, 3, 5, 6, 7};
    }

    public static int[] initNums() {
        return new int[]{10, 20, 3, 4, 2, 6, 54, 5, 45, 32, 87, 92, 6, 7, 5, 343, 5, 45, 45, 543, 365};
    }
}
