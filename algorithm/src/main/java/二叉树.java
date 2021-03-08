import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.LinkedList;

public class 二叉树 {
    public static void main(String[] args) {
        Preorder(initTree());
    }

    public static TreeNode initTree() {
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);
        TreeNode right = new TreeNode(7);
        right.left = new TreeNode(6);
        TreeNode root = new TreeNode(5);
        root.left = left;
        root.right = right;
        return root;
    }

    /**
     * 递归实现
     */
    public static int binarySearch(int[] nums, int left, int right, int x) {
        if (right >= left) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == x) {
                return middle;
            } else if (nums[middle] > x) {
                return binarySearch(nums, left, middle - 1, x);
            } else {
                return binarySearch(nums, middle + 1, right, x);
            }
        }
        return -1;
    }

    public static int binarySearch2(int[] nums, int left, int right, int x) {
        while (right >= left) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == x) {
                return middle;
            } else if (nums[middle] > x) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static int GetTreeDept(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = GetTreeDept(root.left);
        int right = GetTreeDept(root.right);
        return left >= right ? left + 1 : right + 1;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int d = computeDepth(root);
        int left = 1, right = (int) Math.pow(2, d) - 1;
        int pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (exists(pivot, d, root)) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return (int) Math.pow(2, d) - 1 + left;
    }

    public int computeDepth(TreeNode node) {
        int d = 0;
        while (node.left != null) {
            node = node.left;
            ++d;
        }
        return d;
    }

    public boolean exists(int idx, int d, TreeNode node) {
        int left = 0, right = (int) Math.pow(2, d) - 1;
        int pivot;
        for (int i = 0; i < d; ++i) {
            pivot = ((right - left) >> 1) + left;
            if (idx <= pivot) {
                node = node.left;
                right = pivot;
            } else {
                node = node.right;
                left = pivot + 1;
            }
        }
        return node != null;
    }

    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode left;
        TreeNode right;
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            left = tmp.left;
            right = tmp.right;
            if (right != null && left == null) {
                return false;
            }
            if (flag && (left != null || right != null)) {
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
        }
        return true;
    }


    public static void Preorder(TreeNode root, List<Integer> res) {
        if (root != null) {
            System.out.println("当前遍历的是" + root.val);
            res.add(root.val);
            Preorder(root.left, res);
            Preorder(root.right, res);
        }
    }

    public static List<Integer> Preorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr != null) {
                System.out.println("当前遍历的是" + curr.val);
                res.add(curr.val);
                stack.push(curr.right);
                stack.push(curr.left);
            }
        }
        return res;
    }

    public List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public List<Integer> poster(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr = null;
        while (root != null || !stack.isEmpty()) {
            curr = stack.peek();
            if (curr.left != null && root != curr.left && root != curr.right) {
                stack.push(curr.left);
            } else if (curr.right != null && root != curr.right) {
                stack.push(curr.right);
            } else {
                res.add(stack.pop().val);
                root = curr;
            }
        }
        return res;
    }
}
