// if array  is sorted return first index
// else do binary search by finding mid
// as we know in rotated sorted array, there will be atleast one sorted array.
// reject sorted side and move to other side.

// Time Complexity O(log n)
// Space Complexity O(1)


class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low<=high){    // O(log n)
          
            // checking sorted or not
            if(nums[low] <= nums[high]){
                return nums[low];
            }
            int mid = low + (high-low)/2;

            //check if this side is sorted
            if(nums[mid] >= nums[low]){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return nums[low];
    }
}
