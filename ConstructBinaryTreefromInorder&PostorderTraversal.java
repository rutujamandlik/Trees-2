//TC: O(n) -- for finding the root in inorder traversal
//SC: O(n) -- hashmap
// faced issue at index because i did not initialized to last index value but later it ran successfully

//for postorder, we are starting from last index and traversing first from right then left 
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
    
    HashMap<Integer, Integer> map;
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        //null check
        if(postorder == null || postorder.length == 0) return null;
        index = postorder.length - 1;
        map = new HashMap<>();
        //inserting inorder array elements in hashmap
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(postorder, inorder.length - 1, 0);      
    }
    
    public TreeNode helper(int[] postorder, int start, int end ){
        
        //base case
        if(start < end ) return null;
        
        //logic
        int rootVal = postorder[index];
        index --;
        TreeNode root = new TreeNode(rootVal);
        
        //recursive func
        int rootIndex = map.get(rootVal);
        root.right = helper(postorder,   start, rootIndex+1);
        root.left = helper(postorder,  rootIndex - 1,end);
        return root;
        
    }
    
}