package easy;

import common.TreeNode;

/**
 * Range Sum of BST(binary search tree) 二叉搜索树,即为 左中右从小到大排序的树
 * 
 * Given the root node of a binary search tree, 
 * return the sum of values of all nodes with value between L and R (inclusive).
 * 
 * The binary search tree is guaranteed to have unique values.
 * 
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15 
 * Output: 32
 * 
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 * 
 * Note:
 * The number of nodes in the tree is at most 10000.
 * The final answer is guaranteed to be less than 2^31.
 * 
 * 
 * 
BST 的特性性质：时间复杂度是O(N)，空间复杂度是O(1)
使用递归思想，递归基本条件是 root 为空，返回 sum。另外分三种情况考虑。
如果 root 节点在[L,R]内，那么把结果加上 root 的值，然后再分别递归左右子树的值。
如果root的值比L还小，说明左子树一定不会满足[L,R]区间，那么直接向右边找就行。
如果root的值比R还大，说明右子树一定不会满足[L,R]区间，那么直接向左边找就行。

另外一种思想是：如果root节点小于R，说明右边可以继续搜索；如果root节点大于L，说明左边可以继续搜索。
 */
public class Test938 {
	
	public static void main(String[] args) {
		/**
		 * 这里自己构建一个最简单的 BST，既按照先序排列（左中右）是从小到大的一个二叉树。
		 */
		TreeNode root = new TreeNode(10);
		TreeNode r1 = new TreeNode(7);
		TreeNode r2 = new TreeNode(15);
		root.left = r1;
		root.right = r2;
		System.out.println(rangeSumBST(root,7,15)); // 32
	}
	
	static int ans;
    public static int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        dfs(root, L, R);
        return ans;
    }
    
    // 这里使用的是第二种思想，只找肯定存在的，而不是找可能存在的，所以性能会更好。
    public static void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R)
                ans += node.val;
            if (node.val > L)
                dfs(node.left, L, R);
            if (node.val < R)
                dfs(node.right, L, R);
        }
    }
}
