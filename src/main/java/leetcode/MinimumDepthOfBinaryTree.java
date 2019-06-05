package leetcode;

import java.util.LinkedList;
import java.util.Queue;

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

    public int run1(TreeNode root) {
        if(null == root){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode currentNode = queue.poll();
                if(null == currentNode.left && null == currentNode.right){
                    return level;
                }
                if(null != currentNode.left){
                    queue.add(currentNode.left);
                }
                if(null != currentNode.right){
                    queue.add(currentNode.right);
                }
            }
            level++;
        }
        return level;
    }

}
