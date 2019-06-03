package leetcode;

/**
 * Given a binary tree, find its minimum depth.The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * @author Flaming
 * @date 2019/6/3 17:18
 */
public class MinimumDepthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int run(TreeNode root) {
        // 判空
        if(null == root){
            return 0;
        }

        int minLeft = run(root.left);
        int minRight = run(root.right);
        // 若单空子树，最小深度为非空子树的最小深度加自身
        // 若双空子树，最小深度为本身
        if(null == root.left || null == root.right){
            return minLeft + minRight + 1;
        }
        return Math.min(minLeft, minRight) + 1;
    }

}
