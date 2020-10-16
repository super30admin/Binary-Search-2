//LeetCode #153. Find Minimum in Rotated Sorted Array
// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// This approach is a bit different from the one taught in class.
// Please let me know which one is better to use.

// Your code here along with comments explaining your approach:
/*
    When we divide the a rotated sorted array(or portion of it) at 'mid' value, it is
    sure that either the elements from left to mid or mid+1 to right are sorted.
    In these sorted parts, we need to compare the leftmost element (which is minimum 
    among the elements of sorted part) with the current minimum. Then update the 
    minimum accordingly.
    After that, we move to the other part of the array by updating the left or right pointer.
*/

class Solution {
public:
    int findMin(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        int min = INT_MAX;
        int left = 0;
        int right = nums.size()-1;
        
        while(left <= right){
            int mid = left + (right-left)/2;

            // checking if elements starting from left index to mid index are sorted
            if(nums[left] <= nums[mid]){ 
                if(nums[left] < min)
                    min = nums[left]; 
                left = mid+1;
            }
            // elements starting from mid index to right index are sorted
            else{
                if(nums[mid] < min)
                    min = nums[mid];
                right = mid-1;
            }
        }
        return min;
    }
};