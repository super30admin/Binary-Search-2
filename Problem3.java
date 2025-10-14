// Problem Name: Find the Peak Element

// Source Link: https://leetcode.com/problems/find-peak-element/

//Time Complexity: O(Logn)
//Space Complexity: O(1)
//Approach:
//   1. Find the Mid, because since its sorted the mid value would help to decide or greater value
// 2. if nums[m]<nums[n+1] that means the peak is on the left part of array
// 3. if nums[m]>nums[n+1] that means the peak is on the right part of array

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int m = left + (right - left) / 2;
            if ((m == 0 || nums[m] > nums[m - 1]) && (m == nums.length - 1 || nums[m] > nums[m + 1])) {
                return m;
            }
            else if (m < nums.length - 1 && nums[m] < nums[m + 1]) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        return -1;
    }
}
