package com.yangfan.leetcode.datastructures.trees;

import com.sun.source.tree.Tree;
import com.yangfan.dataobject.TreeNode;
import com.yangfan.playground.util.BinaryTreeUtil;

import java.util.*;

/**
 * 662. Maximum Width of Binary Tree
 * Given the root of a binary tree, return the maximum width of the given tree.
 * The maximum width of a tree is the maximum width among all levels.
 * The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.
 * It is guaranteed that the answer will in the range of a 32-bit signed integer.
 *
 * 求二叉树的最大宽度, 包含中间的null
 *         1
 *      2    3
 *   4   5     6
 *  7 n n 8   n 9
 *
 *  最大宽度为8 [7nn8nnn9]
 *
 *  这题用BFS的方式更好理解一些
 *
 */
public class Maximum_Width_of_Binary_Tree {

    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};
        TreeNode tree = BinaryTreeUtil.createBinaryTree(arr);

    }

    /**
     * 这个方法更妙
     *
     * 队列中的TreeNode不再保存以前树各个节点的值，
     * 而是利用其存储位置信息
     */
    public int widthOfBinaryTreePro(TreeNode root) {
        int max = 0;
        Queue<TreeNode> helper = new LinkedList<>();
        helper.add(new TreeNode(0, root.left, root.right));
        while(!helper.isEmpty()) {
            int currentLayerSize = helper.size();
            int start = helper.peek().val, end = -1;
            for(int i = 1; i <= currentLayerSize; i++) {
                TreeNode cur = helper.poll(); // 并非原始node，只保留了原始node之间的关系
                int position = cur.val;
                if(i == currentLayerSize) end = position;
                if(cur.left != null) {
                    helper.add(new TreeNode(2 * position + 1, cur.left.left, cur.left.right));
                }
                if(cur.right != null) {
                    helper.add(new TreeNode(2 * position + 2, cur.right.left, cur.right.right));
                }
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    /**
     * 提示：
     *
     * 树中节点的数目范围是 [1, 3000]
     * -100 <= Node.val <= 100
     *
     * 最大宽度即为每层宽度的最大值。
     * 设一个max，
     * 然后每层的宽度则是最右侧节点position - 最左侧节点position + 1
     * 每层更新max
     * 最后返回max值
     */
    class AnnotatedNode {
        TreeNode node;
        int position;
        AnnotatedNode(TreeNode n, int p) {
            node = n;
            position = p;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList<>();
        queue.add(new AnnotatedNode(root, 0));
        int max = 0;
        // 逐层弹出处理
        while(!queue.isEmpty()) {
            int layerSize = queue.size();
            int left = queue.peek().position; // 每层最左值
            int right = 0;
            for(int i = 1; i <= layerSize; i++) {
                AnnotatedNode cur = queue.poll();
                int position = cur.position;
                if(i == layerSize) right = position;
                if(cur.node.left != null) {
                    queue.add(new AnnotatedNode(cur.node.left, 2 * position + 1));
                }
                if(cur.node.right != null) {
                    queue.add(new AnnotatedNode(cur.node.right, 2 * position + 2));
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    /**
     * 深度优先方式
     * 了解一下思路即可， 毕竟比广度要慢很多
     */
    int result = 0;
    Map<Integer, Integer> minValue = new HashMap();
    public int widthOfBinaryTreeRecur(TreeNode root) {
        depth(root, 0, 1); //
        return result;
    }

    public void depth(TreeNode node, int nodeIndex, int level) {
        if(node == null) return;
        minValue.putIfAbsent(level, nodeIndex);
        result = Math.max(result, nodeIndex - minValue.get(level) + 1);
        depth(node.left, 2 * nodeIndex + 1, level + 1);
        depth(node.right, 2 * nodeIndex + 2, level + 1);
    }


}
