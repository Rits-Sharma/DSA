package Leetcode.June;

import java.util.HashMap;
import java.util.HashSet;

public class L2196_Create_Binary_Tree {
    public static void main(String[] args) {
        int[][] descriptions = {{20,15,1}, {20,17,0}, {50,20,1}, {50,80,0}, {80,19,1}};
        TreeNode ans = createBinaryTree(descriptions);
        System.out.println(ans);
    }

    public static TreeNode createBinaryTree(int[][] nodes) {
        HashSet<Integer> children = new HashSet<>();
        HashMap<Integer, TreeNode> map = new HashMap<>();

        for (int[] node : nodes) {
            int parent = node[0], child = node[1], isLeft = node[2];
            children.add(child);

            TreeNode parentNode = map.computeIfAbsent(parent, TreeNode::new);
            TreeNode childNode = map.computeIfAbsent(child, TreeNode::new);

            if (isLeft == 1)
                parentNode.left = childNode;
            else
                parentNode.right = childNode;
        }

        for (int[] node : nodes) {
            if (!children.contains(node[0]))
                return map.get(node[0]);
        }

        return null;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }
