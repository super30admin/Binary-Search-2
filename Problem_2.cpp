/*
 * Time Complexity : O(log(n))
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No


 ? Your code here along with comments explaining your approach
   In my findMin function, I have implemented a binary search
   algorithm to find the minimum element in a rotated sorted
   array nums. The array is assumed to be sorted in ascending
   order and then rotated at some pivot point. My goal is to
   efficiently locate the smallest element. I start by
   initializing two pointers, l (left) and r (right), to the
   beginning and end of the array, respectively. In each
   iteration of the while loop, I first check if the subarray
   defined by l and r is already sorted (by comparing nums[l]
   and nums[r]); if it is, I immediately return nums[l] as the
   minimum. Otherwise, I calculate the middle index mid and use
   it to determine which half of the array contains the smallest
   element. If the left part of the array (from l to mid) is
   unsorted, indicating that the minimum is there, I update the
   right pointer r to mid. Otherwise, I know the minimum must be
   in the right part, so I update the left pointer l to mid + 1.
   This process narrows down the search space in each iteration
   until l and r converge, at which point I return nums[l], the
   smallest element found.
*/

#include <vector>

class Solution {
public:
    int findMin(std::vector<int>& nums) {
        int l = 0;
        int r = nums.size() - 1;
        int mid;

        while(l < r) {
            if(nums[l] <= nums[r]) return nums[l];

            mid = l + (r-l)/2;
            if(nums[l] > nums[mid]) r = mid;
            else l = mid + 1;
        }


        return nums[l];
    }
};