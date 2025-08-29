//Time Complexity: O(logn)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Forgot to take care of edge cases
// Approach: Perform binary search to find the pivot
//           Compare the elements at low and high to find out if the array is sorted or not
//           Otherwise check which side of the array is sorted and adjust the values of low and accordingly till you find the minimum element
class Problem2 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n-1;

        while(low <= high){
            if(nums[low] <= nums[high]){
                return nums[low];
            }

            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == n-1 || nums[mid] < nums[mid + 1])){
                return nums[mid];
            }
            else if(nums[low] <= nums[mid]){ 
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return -1;
    }
}