// Find mid, based on left and right pointers
//If value at mid is greater than value at right most index,
//then we know that minimum value must be present on the right side of array 
// else we explore the left side of the array
// We know that at least one side of the rotated sorted array is sorted

class Solution {
    public int findMin(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right-left)/2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}

// Time complexity: O(logn)
// Space complexity: O(1)