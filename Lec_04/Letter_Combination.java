package Lec_04;
class Letter_Combination {
    List<String> li=new ArrayList<>();
    String [] arr={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return li;
        }
        solve(digits,"");
        return li;
    }

    public void solve(String s,String ans){
        if(s.length()==0){
            li.add(ans);
            return;
        }
        int n=s.charAt(0)-'0';
        for(int j=0;j<arr[n].length();j++){
            solve(s.substring(1),ans+arr[n].charAt(j));
        }  
    }

}