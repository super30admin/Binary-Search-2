/*Time Complexity: O(log n ) */


class Solution {
    public int findMin(int[] nums) {
        // null check
        if(nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int low = 0; int high =  n - 1;
        while(low < high){
            if(nums[low] <= nums[high]) return nums[low];
            int mid = low +(high - low)/2;
            if((mid == 0 || nums[mid] < nums[mid-1]) 
               && (nums[mid] < nums[mid+1])){
                // min
                return nums[mid];
            } else if(nums[low] <= nums[mid]){ 
                //if left side is sorted
                low = mid + 1;
            } else { 
                high = mid;
            }
        }
        return nums[high];
    }
}
