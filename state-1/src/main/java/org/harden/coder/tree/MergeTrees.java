package org.harden.coder.tree;

import org.harden.coder.TreeNode;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/8 18:34
 * 文件说明：
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
 * 否则不为 NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }
        TreeNode node=new TreeNode(root1.val+root2.val);
        TreeNode left = mergeTrees(root1.left, root2.left);
        TreeNode right = mergeTrees(root1.right, root2.right);
        node.left=left;
        node.right=right;
        return node;
    }
}