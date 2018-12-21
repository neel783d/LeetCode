import java.util.Arrays;
import java.util.TreeSet;
import java.util.HashSet;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //results
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        
        // Sorting List
        Arrays.sort(nums);
        
        // Finding all triplets
        for(int i=0; i<nums.length; i++) {
            
            // Traversing through left to right
            int l = i+1;
            int r = nums.length-1;
            
            while(l < r) {
                if(nums[l] + nums[r] + nums[i] < 0) { l++; }
                else if(nums[l] + nums[r] + nums[i] > 0) { r--; }
                else {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                }
            }
        }
        
        return new ArrayList<>(result);
    }
}
