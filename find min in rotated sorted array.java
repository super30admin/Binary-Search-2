//TC:log(N)
//SC: O(1)
//Approach: Using Binary Search, compared mid value with the adjacent values to figure out which 
//side is sorted and which is not. min is always in the unsorted part. Apply BS on unsorted part.

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int hi = nums.length - 1;
        // if(nums[low]<=nums[hi]) return nums[low];
        while(low<=hi) {
            int mid = low + (hi-low) / 2;
            if((mid ==  nums.length - 1 || nums[mid]< nums[mid+1]) &&(mid == 0 || nums[mid] < nums[mid - 1])) return nums[mid];

            if(nums[mid] <= nums[hi]) { // right sorted array
                hi = mid -1;
            } else {
                low = mid + 1;
            }
            
        }
        return nums[low];
    }
}