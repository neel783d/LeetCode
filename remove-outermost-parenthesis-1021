class Solution {
    public String removeOuterParentheses(String S) {
        String result = "";
        int i=0;
        while( i < S.length()){
            String curr = "" + S.charAt(i);
            int count=1;
            i++;
            while(i < S.length() && count!=0){
                if(S.charAt(i)=='(') {
                    count++;
                }
                else{
                    count--;
                }
                curr += S.charAt(i);
                i++;
            }
            
            if(!curr.equals("") && curr.length()>=2) {
                result += (count <= 0) ? curr.substring(1, curr.length() - 1) : curr.substring(1);
            } 
        }
        return result;
    }
}
