import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int []result = new int[2];
        for(int i=0; i<nums.length; i++) {
            // Checking if element exist or not
            int z = h.getOrDefault(target - nums[i], -1);
            
            // Found Solution
            if(z!=-1){
                result[0] = z;
                result[1] = i;
                break;
            }
            
            // Otherwise add it to HashMap
            h.put(nums[i], i);
        }
        return result;
    }
}
