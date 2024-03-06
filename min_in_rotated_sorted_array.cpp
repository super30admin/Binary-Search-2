// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

/*
Leetcode : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
For example, the array nums = [0,1,2,4,5,6,7] might become:
[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
*/

/*
Explaination :
Binary search will help to reduce the data by haf in each iteration.
In rotated array, it is more likely to find minimum element in non-sorted half after
finding the mid.

Here, we checking on both sides of mid if mid is smallest number or mid+1 is smallest number. 
*/

class Solution {
public:
    int findMin(vector<int>& nums) {
        int low = 0;
        int high = nums.size()-1;
        // if array is not rotated then there is not need for any computation
        // nums[low] will be lowest element
        if(nums[low] <= nums[high]) return nums[low];

        while(low <= high){
            int mid = low + (high-low)/2;

            // if the mid element is smaller than its previous element then mid element is the smallest
            if(mid >0 && nums[mid] < nums[mid-1]){
                    return nums[mid];
            }

            // if the mid element is greater than its next element then mid+1 element is the smallest
            if(mid < high && nums[mid] > nums[mid+1]){
                    return nums[mid+1];
            }

            if(nums[low] <= nums[mid]){
                low = mid+1;
            } else {
                high = mid-1;
                }
            }
        return -1;
        }  
};