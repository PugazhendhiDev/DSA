//LEETCODE 653. Two Sum IV - Input is a BST

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
    public ArrayList<Integer> inorder(TreeNode root, ArrayList list) {
        if (root == null) return list;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        return list;
    }
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = inorder(root, list);
        
        int start = 0, end = list1.size()-1;
        
        while(start<end) {
            if (list.get(start) + list.get(end) == k) return true;
            if (list.get(start) + list.get(end) > k) end--;
            else start++;
        }
        return false;
    }
}