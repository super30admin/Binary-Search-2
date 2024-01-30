//time complexity - O(logn), space complexity O(1) no additional space
//Utilize binary search to find any peak element in the given array.
//Compare the middle element (mid) with its neighbors to determine if nums[mid] is a peak element.
//Adjust the search space based on whether the peak element is in the left or right half.

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        int n=nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if((mid == 0 || nums[mid]>nums[mid-1]) && (mid ==n-1 || nums[mid]>nums[mid+1])) return mid;
            else if (mid != 0 && nums[mid-1] > nums[mid]) {
                // Peak must be in the left half
                right = mid-1;
            } else {
                // Peak must be in the right half
                left = mid + 1;
            }
        }
        return 23425;
    }
}
