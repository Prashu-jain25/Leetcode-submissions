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
    private class Pair {
        TreeNode node;
        int index;

        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int width = 0;

        if(root == null) {
            return width;
        }

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while(!q.isEmpty()) {
            int size = q.size();
            int levelMinInd = q.peek().index;
            int first = -1, last = -1 ;

            for(int i = 0; i < size; i++) {
                // for 0 based marking of all nodes of particular level
                int currInd = q.peek().index - levelMinInd;
                TreeNode node = q.peek().node;
                q.poll();

                if(i == 0) {
                    first = currInd;
                }

                if(i == size - 1) {
                    last = currInd;
                }

                if(node.left != null) {
                    q.add(new Pair(node.left, currInd * 2  + 1));
                }

                if(node.right != null) {
                    q.add(new Pair(node.right, currInd * 2 + 2));
                }

            }

            width = Math.max(width, last - first + 1);  
        }

        return width;

        
    }


}