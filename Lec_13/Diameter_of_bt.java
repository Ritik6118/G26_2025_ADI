package Lec_13;

public class Diameter_of_bt {
	int max;
    public int diameterOfBinaryTree(TreeNode root) {
        trav(root);
        // pair p=height(root);
        // return p.d;
        return max;
    }
    public void trav(TreeNode root){
        if(root==null){
            return ;
        }
        max=Math.max(max,dia(root));
        trav(root.left);
        trav(root.right);
    }
    public int dia(TreeNode root){
        int l=height(root.left);
        int r=height(root.right);
        // System.out.println("l= "+l+" r="+r);
        return l+r+2;
    }
    
    public int height(TreeNode root){
        if(root==null){
            return -1;
        }
        int l=height(root.left);
        int r=height(root.right);
        max=Math.max(max,l+r+2);
        return Math.max(l,r)+1;
    }

    // public pair height(TreeNode root){
    //     if(root==null){
    //         pair p=new pair();
    //         p.d=0;;
    //         p.h=-1;
    //         return p;
    //     }
    //     pair l=height(root.left);
    //     pair r=height(root.right);
    //     pair p=new pair();
        
    //     p.h=Math.max(l.h,r.h)+1;
    //     p.d=Math.max(l.h+r.h+2,Math.max(l.d,r.d));
    //     return p; 
    // }
}


// class pair{
//     int h;
//     int d;
// }
