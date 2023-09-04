/*
 
Problem 3: (https://leetcode.com/problems/find-peak-element/)

Time Complexity : O(log n)
Space Complexity : O(1)
Did it run on LeetCode : Yes
Any issues encountered : No

*/

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while ( low <= high ){
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] > nums[mid-1]) && 
                (mid == nums.length - 1 || nums[mid] > nums[mid+1])){
                    return mid;
                }
            else{
                if(nums[mid+ 1] > nums[mid]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}