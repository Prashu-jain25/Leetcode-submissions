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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // if root is null insert new node(val) at root
        if(root == null) {
            return new TreeNode(val);
        }

        // make copy of root
        TreeNode curr = root;

        while(true) {
            // val is greater than curr node
            if(val >= curr.val) {
                // curr's right exist go to right 
                if(curr.right != null) {
                    curr = curr.right;
                }
                else { // not exist = create new node at curr's right
                    curr.right = new TreeNode(val);
                    break;
                }
            }
            // val is smaller than curr node
            else {
                // curr's left exist go to left
                if(curr.left != null) {
                    curr = curr.left;
                }
                else {// not exist = create new node at curr's left
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }
}