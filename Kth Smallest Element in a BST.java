class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] result = new int[2]; // Using an array to hold both the count and the result
        
        // Start the in-order traversal
        inorder(root, k, result);
        
        return result[1]; // Return the kth smallest element
    }
    
    private void inorder(TreeNode node, int k, int[] result) {
        if (node == null || result[0] == k) {
            return;
        }
        
        // Traverse the left subtree
        inorder(node.left, k, result);
        
        // Increment the count of visited elements
        result[0]++;
        
        // If we have visited k elements, set the result
        if (result[0] == k) {
            result[1] = node.val;
            return;
        }
        
        // Traverse the right subtree
        inorder(node.right, k, result);
    }
}
