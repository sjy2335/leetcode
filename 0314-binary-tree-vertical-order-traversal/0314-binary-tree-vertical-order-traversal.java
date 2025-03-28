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

    private Map<Integer, List<Integer>> colToNodes;
    private int minColumn = Integer.MAX_VALUE;
    private int maxColumn = Integer.MIN_VALUE;

    private class WrapperNode {
        TreeNode node;
        int column;

        WrapperNode(TreeNode node, int column) {
            this.node = node;
            this.column = column;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        colToNodes = new HashMap<>();
        BFS(root);

        List<List<Integer>> answer = new ArrayList<>();
        for (int i = minColumn; i <= maxColumn; i++)  {
            answer.add(colToNodes.get(i));
        }

        return answer;
    }

    private void BFS(TreeNode root) {
        Queue<WrapperNode> q = new ArrayDeque<>();
        q.add(new WrapperNode(root, 0));

        while (!q.isEmpty()) {
            WrapperNode curr = q.poll();

            if (!colToNodes.containsKey(curr.column)) 
                colToNodes.put(curr.column, new ArrayList<>());
            colToNodes.get(curr.column).add(curr.node.val);

            minColumn = Math.min(minColumn, curr.column);
            maxColumn = Math.max(maxColumn, curr.column);

            TreeNode left = curr.node.left;
            TreeNode right = curr.node.right;
            if (left != null) {
                q.add(new WrapperNode(left, curr.column - 1));
            }
            if (right != null) {
                q.add(new WrapperNode(right, curr.column + 1));
            }
        }
    }

}
