class Solution {
    public String removeOuterParentheses(String s) {
        String dup="";
        String ans="";
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push('(');
                dup+='('+"";
            }
            else{
                stack.pop();
                if(stack.isEmpty()){
                    ans+=dup.substring(1);
                    dup="";
                }
                else{
                    dup+=')'+"";
                }
            }
    
        }
        return ans;
       
    
    }
}