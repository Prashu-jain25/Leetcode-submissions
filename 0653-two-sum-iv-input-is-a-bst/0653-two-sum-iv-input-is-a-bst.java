/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
       return bruteForce(root, k);
    }

    private boolean bruteForce(TreeNode root, int k) {
        ArrayList<Integer> temp = new ArrayList<>();
        inOrder(root, temp);

        int start = 0, end = temp.size() - 1;
        int sum = 0;

        while(start < end) {
            sum = temp.get(start) + temp.get(end);

            if(sum == k) {
                return true;
            }
            else if(sum < k) {
                start++;
            }
            else {
                end--;
            }
        }

        return false;
    }

    private void inOrder(TreeNode root, ArrayList<Integer> temp) {
        if(root == null) {
            return;
        }

        inOrder(root.left, temp);
        temp.add(root.val);
        inOrder(root.right, temp);
    }
}