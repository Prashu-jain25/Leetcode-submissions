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
        int col;
        int row;
        TreeNode node;

        public Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        } 
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mpp = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.col;

            if(!mpp.containsKey(col)) {
                mpp.put(col, new TreeMap<>());
            } 

            if(!mpp.get(col).containsKey(row)) {
                mpp.get(col).put(row, new PriorityQueue<>());
            }

            mpp.get(col).get(row).add(node.val);

            if(node.left != null) {
                q.add(new Pair(node.left, row + 1, col - 1));
            }

            if(node.right != null) {
                q.add(new Pair(node.right, row + 1, col + 1));
            }

        }

        List<List<Integer>> res = new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> rows : mpp.values()) {
            List<Integer> temp = new ArrayList<>();

            for(PriorityQueue<Integer> pq : rows.values()) {
                while(!pq.isEmpty()) {
                    temp.add(pq.poll());
                }
            }

            res.add(temp);
        }

        return res;

    }
}