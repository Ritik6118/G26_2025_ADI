package Lec_06;
class Word_Search {
    public boolean exist(char[][] arr, String s) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==s.charAt(0)){
                    boolean ans=search(arr,s,i,j,0);
                    if(ans==true){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean search(char[][]arr,String s,int row,int col,int idx){
        if(idx==s.length()){
            return true;
        }
        if(row<0||col<0||row>=arr.length||col>=arr[0].length||arr[row][col]!=s.charAt(idx)){
            return false;
        }
        int[] r={-1,1,0,0};
        int[] c={0,0,1,-1};
        for(int i=0;i<r.length;i++){
            arr[row][col]='*';
            boolean ans=search(arr,s,row+r[i],col+c[i],idx+1);
            arr[row][col]=s.charAt(idx);
            if(ans==true){
                return true;
            }
        }
        return false;
    }
}