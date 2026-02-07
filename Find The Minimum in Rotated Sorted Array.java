# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : One half of the array is always sorted The minimum element is the point where the sorted order breaks We can find that point using binary search in O(log n) time

class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0]; 
        }
        int left = 0, right = nums.length - 1;
        if(nums[right] > nums[0]){
            return nums[0];
        }
        int mid = 0;
        while(left < right) {
            mid = left + (right - left) / 2;

            if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[right];
    }
}
