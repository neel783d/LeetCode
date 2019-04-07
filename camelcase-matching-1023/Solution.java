class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for(String query: queries){
            int i=0, j=0;
            while(i < query.length() && j < pattern.length()){
                if(query.charAt(i)==pattern.charAt(j)){
                    i++;
                    j++;
                }
                else if(query.charAt(i) >= 'a' && query.charAt(i) <= 'z'){
                    i++;
                }
                else{
                    break;
                }
            }
            // System.out.println(i+ "-"+ j);
            while(i < query.length() && query.charAt(i) >= 'a' && query.charAt(i) <= 'z') i++;
            if(j==pattern.length() && i==query.length()) {
                result.add(true);
            }
            else{
                result.add(false);
            }
        }
        return result;
    }
}
