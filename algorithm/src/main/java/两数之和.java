import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    public static void main(String[] args) {
        Arrays.stream(twoSum(new int[]{2, 7, 11, 15}, 9)).forEach(System.out::print);
    }

    public static int[] twoSum(int[] nums, int val) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = val - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("Not two sum");
    }
}
