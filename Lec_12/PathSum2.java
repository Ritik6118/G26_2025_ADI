package Lec_12;

public class PathSum2 {	
	List<List<Integer>> ans=new ArrayList<>();
    List<Integer>li=new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        trav(root,targetSum);
        return ans;
    }

    public void trav(TreeNode root, int t){
        if(root==null){
            return ;
        }
        if(root.left==null && root.right==null){
            
            if(t-root.val==0){
                //li->ans
                li.add(root.val);
                ans.add(new ArrayList(li));
                li.remove(li.size()-1);
            }

            return ;
        }
        li.add(root.val);
        trav(root.left,t-root.val);
        trav(root.right,t-root.val);
        li.remove(li.size()-1);
    }

}	
