// Time complexity - O(log n)
// Space complexity - O(1)
// DID you solve in leetcode - Yes
// Face any issues while solving - No
// Since I can return any peek element, we will be ignored the 1/2 array, checking mid is less than which part of the array
class Solution {
    public int findPeakElement(int[] nums) {
        int low =0,high = nums.length-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if((mid == 0 || nums[mid] >nums[mid-1]) && (mid == nums.length-1 || nums[mid]> nums[mid+1])) {
                return mid;
            } else if(nums[mid+1] > nums[mid]){
                low = mid +1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}
