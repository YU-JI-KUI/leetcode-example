package easy;

import common.TreeNode;

/**
617. Merge Two Binary Trees

Given two binary trees and imagine that when you put one of them to cover the other, 
some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, 
then sum node values up as the new value of the merged node. 
Otherwise, the NOT null node will be used as the node of new tree.

key：递归实现，想清楚结束的条件。将目光定在一个节点上，思考一个节点怎么处理。
 */
public class Test617 {

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        TreeNode t = new TreeNode(0);
        t.val = t1.val + t2.val;
        t.left = mergeTrees(t1.left, t2.left);
        t.right = mergeTrees(t1.right, t2.right);
        return t;
    }
}
