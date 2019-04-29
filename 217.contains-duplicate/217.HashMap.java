class Solution {
    public boolean containsDuplicate(int[] nums) {
	// With HashMap
	Map<Integer, Boolean> exist = new HashMap<>();
	for(int i=0; i<nums.length; i++){
		if(exist.getOrDefault(nums[i], false)) return true;
		exist.put(nums[i], true);
	}
	return false;
    }
}
