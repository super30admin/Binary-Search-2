// Explain your approach in **three sentences only** at top of your code: binary search to find peak element in the array. Compare the middle element with its neighbors to determine if it is a peak or which side to continue searching. Return the index of the peak element when found.
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0, high = n-1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if((mid == 0 || nums[mid] > nums[mid - 1]) && ( mid == n-1 || nums[mid] > nums[mid + 1])){
                return mid;
            }
            else if(nums[mid + 1] > nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return -1;
    }
}