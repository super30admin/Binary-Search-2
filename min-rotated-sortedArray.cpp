// Time Complexity : O(log n) binary search
// Space Complexity : O(1) - haven't used any extra space to perform the operations
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Leetcode(153): (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
/* Approach:
   This solution uses binary search to locate the rotation point or the minimum element.

   1.If the array’s first element is less than the last, it’s not rotated—return the first element.
   2.Compare mid with the rightmost value: If nums[mid] > nums[high], the minimum is on the right side. else, the minimum is on the left side (or at mid).

   Keep narrowing the range until low meets high that position is our minimum.
*/
#include<iostream>

using namespace std;

class Solution {
public:
    int findMin(vector<int>& nums) {
        int low = 0, high = nums.size() -1;

        if(nums[low] < nums[high]){//array already sorted: no rotation
            return nums[low];
        }

        //binary search
        while(low < high){
            
            int mid = low + (high - low)/2;
            
            // If mid element is greater than the rightmost element, then the minimum must lie in the right half
            if(nums[mid] > nums[high]){
                low = mid + 1;
            }
            else{

                // Otherwise, the minimum is in the left half, including the possibility that mid is our min
                high = mid;
            }
        }

        //At the end, low == high, both pointing to the min element, can return either of them
        return nums[low];
        
    }
};