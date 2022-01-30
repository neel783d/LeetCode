class Solution {
    public void dfs(int n, int curr, List<Integer> result) {
        // System.out.println(n + "  " + curr + "   " + Arrays.toString(result.toArray()));
        if (curr > n) {
            return;
        }
        
        for (int i = 0; i <= 9; i++) {
            int a = curr * 10 + i;
            
            if (a > n) {
                return;
            }
            
            result.add(a);
            
            dfs(n, a, result);
        }
        
    }
    
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 1; i < 10; i++) {
            if (i > n) {
                break;
            }
            result.add(i);
            dfs(n, i, result);
        }
        
        return result;
    }
}
