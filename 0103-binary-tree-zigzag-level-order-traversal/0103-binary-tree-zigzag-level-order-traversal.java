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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean lToR = true;

        while(!q.isEmpty()) {
            int limit = q.size();
            LinkedList<Integer> level = new LinkedList<>();

            for(int i = 0; i < limit; i++) {
                TreeNode temp = q.poll();

                if(lToR) {
                    level.addLast(temp.val);
                }
                else {
                    level.addFirst(temp.val);
                }

                if(temp.left != null) {
                    q.add(temp.left);
                }

                if(temp.right != null) {
                    q.add(temp.right);
                }
            }

            lToR = !(lToR);

            ans.add(level);
        }

        return ans;

    }
}