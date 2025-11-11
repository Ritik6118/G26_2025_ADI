package Lec_04;
class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> li=new ArrayList<>();
        generate(n,"",0,0,li);
        return li;
    }
    public static void generate(int n,String s,int l, int r,List<String> li){
        if(l==n&&r==n){
            li.add(s);
            return;
        }
        if(l<n){
            generate(n,s+"(",l+1,r,li);
        }
        if(r<l){
            generate(n,s+")",l,r+1,li);
        }
    }
}
