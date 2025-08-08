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
    public TreeNode deleteNode(TreeNode root, int key) {
        // root is null there is nothing to delete
        if(root == null) {
            return null;
        }

        // delete root
        if(root.val == key) {
            return helper(root); // delete root
        }

        TreeNode curr = root;

        // Traverse till last
        while(curr != null) {
            // key is smaller than curr
            if(key < curr.val) {
                // left exist and need to delete left
                if(curr.left != null && curr.left.val == key) {
                    curr.left = helper(curr.left); // delete left
                    break;
                }
                else { // not a node to delete

                    curr = curr.left; // go left
                }
            }
            else { // key is greater than curr

                // right exist and need to delete right
                if(curr.right != null && curr.right.val == key) {
                    curr.right = helper(curr.right); // delete right
                    break;
                }
                else { // not a node to delete

                    curr = curr.right; // go right
                }
            }
        }

        return root;
    }

    // helper method to delete a particular node
    private TreeNode helper(TreeNode root) {
        // tree don't have left part
        if(root.left == null) {
            return root.right; // return right part
        }

        // tree don't have right part
        if(root.right == null) {
            return root.left; // return left part
        }

        TreeNode rightchild = root.right; // keep track of right subtree
        TreeNode lastRight = findLastRight(root.left); // find rightmost node of left subtree

        lastRight.right = rightchild; // attach right subtree with rightmost node of left subtree

        return root.left; // return left subtree
    }

    // helper method to find rightmost node of left subtree
    private TreeNode findLastRight(TreeNode root) {
        // go until we find rightmost node
        while(root.right != null) {
            root = root.right;
        }

        return root; // rightmost node
    }
}