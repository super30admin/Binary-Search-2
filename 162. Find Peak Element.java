// Time Complexity O(log n)
// space complexity O(1)

// Do binary search and find mid
// check if mid is peak
// else move towards bigger number


class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low+ (high-low)/2;

            // check if mid is peak
            if((mid == nums.length-1 || nums[mid] > nums[mid+1]) && (mid == 0 || nums[mid] > nums[mid-1])){
                return mid;
            }

            // move right side
            if(nums[mid+1]> nums[mid]){
                low = mid+1;
            }
            // move left side
            else{
                high = mid-1;
            }
        }
        // this is just for name sake, because return calls above itself.
        return 13132;

    }
}
