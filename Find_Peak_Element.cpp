// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

/*
Leetcode : https://leetcode.com/problems/find-peak-element/
A peak element is an element that is strictly greater than its neighbors.
Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
You must write an algorithm that runs in O(log n) time.
*/

/*
Code Explaination : 
We are checking if mid is higher than both of its neighboring elements.
If yes, return index mid.
If now, move the search towards the side where neighboring element is higher than mid element;
that side has higher probability of finding the peak.

if ((mid == 0 || nums[mid] > nums[mid-1]) &&
    (mid == size || nums[mid] > nums[mid+1]))

in above condition, if mid == 0 then next condition will not be checked i.e. nums[mid] > nums[mid-1]
therefore, we will not face issue of accessing element out of bound.
*/


class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int low = 0;
        int high = nums.size()-1;
        if(nums.size() == 1) return 0;

        int size = nums.size() - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;

            if ((mid == 0 || nums[mid] > nums[mid-1]) &&
                (mid == size || nums[mid] > nums[mid+1])) {
                    return mid;
                }
            else if (mid !=0 && nums[mid] < nums[mid - 1]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
        }
};
