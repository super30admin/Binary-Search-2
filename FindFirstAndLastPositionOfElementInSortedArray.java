// TC - O(logn)
// SC - O(1)
// Ran on Leetcode - Yes
// Mistake made - made the same error as in Find Peak Elements - the condition for returning was incorrect and didnt take into account first and last elements of the array
// Need to internalize the mid == 0 || nums[mid-1] < nums[mid] condition approach - its just that the && approach is the one that comes naturally in my head first

class Solution {
    public int[] searchRange(int[] nums, int target) {
        // run 2 binary searches - one to find start position, other to find end position
        int n = nums.length;
        if(n == 0) return new int[]{-1, -1};

        int low = 0;
        int high = n-1;

        // Binary Search for start position
        int first = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] < nums[mid]){
                    // found first occurrence, break
                    first = mid;
                    break;
                }
                else{
                    // we found some occurrence, but it is not first, so we shrink search space from RHS
                    high = mid-1;
                }
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        // If first occurrence is not found, that means target doesnt exist - exit early
        if(first == -1) return new int[]{-1, -1};

        // Run 2nd binary search to find last occurrence
        int last = -1;
        // reset low and high ptrs
        low = 0;
        high = n-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == n-1 || nums[mid] < nums[mid+1]){
                    // found last occurrence, break
                    last = mid;
                    break;
                }
                else{
                    // we found some occurrence, but it is not last, so we shrink search space from LHS
                    low = mid+1;
                }
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return new int[]{first, last};
    }
}
