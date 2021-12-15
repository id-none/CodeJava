package company;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTree {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversal(root, ans);
        return ans;
    }

    public void inorderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, ans);
        inorderTraversal(root.right, ans);
        ans.add(root.val);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            root = root.val > val ? root.left : root.right;
        }
        return null;
    }

    int addDigits(int num) {
        while (num >= 10) {
            String s = num + "";
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += Integer.parseInt(s.charAt(i) + "");
            }
            num = sum;
        }
        return num;
    }
}
