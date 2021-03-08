import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class 排序算法 {
    public static void main(String[] args) {
        int[] nums = initNum();
        heapSort(nums);
        Arrays.stream(nums).forEach(s -> {
            System.out.print(s + ",");
        });
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int[] initNum() {
        List<Integer> list = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 51; i++) {
            list.add(random.nextInt(100));
        }
        return list.stream().mapToInt(Integer::new).toArray();
    }

    public static void searchSort(int[] nums) {
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

    public static void insertSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; nums[j] > nums[j + 1]; j--) {
                swap(nums, j, j + 1);
                if (j == 0) {
                    break;
                }
            }
        }
    }

    public static void bubbleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int mid = i + ((j - i) >> 1);
        mergeSort(nums, i, mid);
        mergeSort(nums, mid + 1, j);
        merge(nums, i, mid, j);
    }

    private static void merge(int[] nums, int i, int mid, int j) {
        int[] help = new int[j - i + 1];
        int index = 0;
        int p1 = i;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= j) {
            help[index++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= mid) {
            help[index++] = nums[p1++];
        }
        while (p2 <= j) {
            help[index++] = nums[p2++];
        }
        for (int n = 0; n < help.length; n++) {
            nums[i + n] = help[n];
        }
    }

    public static void quickSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int left, int right) {
        int start = left;
        int end = right;
        int key = nums[left];
        while (end > start) {
            while (end > start && nums[end] >= key) {
                end--;
            }
            if (nums[end] <= key) {
                swap(nums, end, start);
            }
            while (end > start && nums[start] <= key) {
                start++;
            }
            if (nums[start] >= key) {
                swap(nums, start, end);
            }
        }
        if (start > left) {
            quickSort(nums, left, start - 1);
        }
        if (end < right) {
            quickSort(nums, end + 1, right);
        }
    }

    public static void heapSort(int[] nums) {
        //构建大根堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子节点从下至上，从右至左调整结构
            heapJust(nums, i, nums.length);
        }
        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = nums.length - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            swap(nums, 0, i);
            //重新对堆进行调整
            heapJust(nums, 0, i);
        }
    }

    /**
     * 调整大顶堆
     * @param nums
     * @param i
     * @param length
     */
    public static void heapJust(int[] nums, int i, int length) {
        int temp = nums[i];
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && nums[j] < nums[j + 1]) {
                j++;
            }
            if (nums[j] > temp) {
                nums[i] = nums[j];
                i = j;
            } else {
                break;
            }
        }
        nums[i] = temp;
    }
}
