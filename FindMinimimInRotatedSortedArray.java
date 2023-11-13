// Time Complexity: O(log(n))
// Space Complexity: O(1)

class Solution {
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            if(nums[low] <= nums[high]) return nums[low];
            int mid = low + (high - low) /2;
            // if array size is 1, then mid -1 will raise Array index out of bound
            if((mid == low || nums[mid] <  nums[mid -1]) && (mid == high || nums[mid] < nums[mid + 1])){
                return nums[mid];
            }
            else if(nums[low] <= nums[mid]){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return 0;
    }
}