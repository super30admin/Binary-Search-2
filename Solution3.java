/* 
Problem 3:(https://leetcode.com/problems/find-peak-element/)

Time Complexity: O(log n)

Space Complexity: O(1)

Use binary search to find an index whose value is greater than its adjacent elements.
Treat missing neighbors outside the array as negative infinity, so a boundary element can be checked safely.
When the middle element is not a peak, move toward the side that contains a greater neighbor.

*/ 


class Solution {
    public int findPeakElement(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if((mid == 0 || nums[mid] > nums[mid -1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])){
                return mid;
            }else if(mid == nums.length -1 || nums[mid] < nums[mid + 1]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
}