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
    public class Pair{
        TreeNode node;
        int row; 
        int col;

        public Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) {
            return ans;
        }

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mpp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0, 0));

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            TreeNode currNode = curr.node;
            int currRow = curr.row;
            int currCol = curr.col;

            if(!mpp.containsKey(currCol)) {
                mpp.put(currCol, new TreeMap<>());
            }

            if(!mpp.get(currCol).containsKey(currRow)) {
                mpp.get(currCol).put(currRow, new PriorityQueue<>());
            }

            mpp.get(currCol).get(currRow).add(currNode.val);

            if(currNode.left != null) {
                q.add(new Pair(currNode.left, currRow + 1, currCol - 1));
            }

            if(currNode.right != null) {
                q.add(new Pair(currNode.right, currRow + 1, currCol + 1));
            }
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> rows : mpp.values()) {
            List<Integer> colList = new ArrayList<>();
            for(PriorityQueue<Integer> pq : rows.values()) {
                while(!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }

            ans.add(colList);
        }

        return ans;
    }
}