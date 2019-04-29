class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	HashMap<Integer, Integer> pos = new HashMap<>();
	for(int i=0; i<nums.length; i++){
		if(pos.containsKey(nums[i]) && i - pos.get(nums[i]) <= k) return true;
		pos.put(nums[i], i);
	}
	return false;
    }
}
