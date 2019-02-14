class Solution {
    
    public int recursiveBinarySearch(int[] nums, int target, int low, int high) {
        
        if (high < low) return -1;
        
        int mid = (high+low)/2;
        
        if(nums[mid]==target){
            return mid;
        }
        
        int foundIndx = recursiveBinarySearch(nums, target, low, mid-1);
        
        if(foundIndx!=-1){
            return foundIndx;
        }
        
        return recursiveBinarySearch(nums, target, mid+1, high);
        
    }
    
    public int search(int[] nums, int target) {
        return recursiveBinarySearch(nums, target, 0, nums.length-1);
    }
}
