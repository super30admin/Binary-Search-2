/*
 * Time Complexity : O(log(n))
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No


 ? Your code here along with comments explaining your approach
   In my implementation of the searchRange function, I aim to
   find the starting and ending positions of a given target
   number in a sorted array nums. Initially, I create a vector
   output with two elements initialized to -1, which will hold
   the result. I use a binary search approach to find the lower
   and upper bounds of the target number. In the first binary
   search loop, I modify the left and right pointers to find the
   first occurrence of the target. If I don't find the target
   (checking if left is out of bounds or the value at left is
   not the target), I return output as is, indicating the target
   is not present. If I find the target, I set the first element
   of output to left. Then, I conduct a second binary search to
   find the last occurrence of the target, adjusting the binary
   search to find the upper bound. Finally, I set the second
   element of output to right, which represents the end position
   of the target range, and return output.
*/

#include <vector>

class Solution {
public:
    std::vector<int> searchRange(std::vector<int>& nums, int target) {
        std::vector<int> output(2, -1);
        int left = 0;
        int right = nums.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left == nums.size() || nums[left] != target) {
            return output; // Target not found
        }

        output[0] = left;
        right = nums.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        output[1] = right;

        return output;
    }
};