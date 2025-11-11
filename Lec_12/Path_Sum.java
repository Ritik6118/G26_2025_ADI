package Lec_12;

public class Path_Sum {
	public boolean hasPathSum(TreeNode root, int targetSum) {
	        if(root==null){
	            return false;
	        }
	        if(root.left==null && root.right==null){
	            if(targetSum-root.val==0){
	                return true;
	            }
	            return false;
	        }
	        boolean left=hasPathSum(root.left,targetSum-root.val);
	        boolean right=hasPathSum(root.right,targetSum-root.val);
	        return left || right;
	    }
	}
}

