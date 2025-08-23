//Ran on leetcode: Yes
//TC:O(logn)
//SC:O(1)
//Find the lowerBound using binary search and also find the upper bound using binary search and return the lowerBound and one less than the upper bound
class ProblemOne {
    public int[] searchRange(int[] nums, int target) {
        // Find the element greater than or equal to the target
        int lowerBound = findLowerBound(nums, 0, nums.length - 1, target);
        // If the element is not found then return 
        if(lowerBound == nums.length || nums[lowerBound] != target){
            return new int[]{-1, -1};
        }
        // Find the element greater than the target
        int upperBound = findUpperBound(nums, 0, nums.length - 1, target);
        // Return the answer
        return new int[]{lowerBound, upperBound - 1};
    }

    private int findLowerBound(int[] nums, int low, int high, int target){
        int ans = nums.length;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] >= target){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int findUpperBound(int[] nums, int low, int high, int target){
        
        int ans = nums.length;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] > target){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}