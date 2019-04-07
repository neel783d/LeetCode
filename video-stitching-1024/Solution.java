class Solution {
    public int videoStitching(int[][] clips, int T) {
        int[] reach = new int[T+1];
        if(clips.length==0) return T==0 ? 0 : -1;
        
        // Initialization with Maximum Values
        int maxValue = 101;
        for(int i=0; i<=T; i++) reach[i] = maxValue;
        Arrays.sort(clips, (left, right) -> (left[0] != right[0])
                   ? left[0] - right[0]
                   : right[1] - left[1]);
        
        if(clips[0][0] != 0) return -1;
        reach[clips[0][0]] = 0;
        int end = 0;
        for(int[] clip: clips){
            // Upper Bound
            int uIndex = Math.min(T, clip[1]); 

            // already reached
            if(reach[uIndex]!=maxValue) continue;
            
            // Updating unreached ones
            int update = reach[clip[0]] + 1;
            for(int i=end+1; i<=uIndex; i++){
                reach[i] = Math.min(reach[i], update); 
            }
            end = uIndex;
        }
        
        // Checking if we can reach T
        return reach[T]==maxValue ? -1 : reach[T];
    }
}
