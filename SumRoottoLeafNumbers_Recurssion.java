//using recurssion
//TC: O(n)
//SC: O(n) -- worst case height = number of nodes in tree
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
    int sum;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    
    public void helper( TreeNode root, int number){
        //base case
        if(root == null) return;
         
        //logic
        //inorder traversal -- we can do all 3 types of traversals
        helper(root.left, number*10 + root.val);
        //root = st.pop()[0] num =st.pop()[1]
        
        if(root.left == null && root.right == null){
            sum += number*10 + root.val;
        }
        
        helper(root.right, number*10 + root.val);
        
    }
}