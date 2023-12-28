/*
 * Time Complexity : O(log(n))
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No


 ? Your code here along with comments explaining your approach
    If the element to the right of the mid is less than the mid
    then the peek is on the left side so I search on the left.
    If the element on the right side of the mid is greater then
    I continue climbing to reach the peek. At the end of all the
    iterations the l will converge at he peek which I then return.
*/

#include <vector>

class Solution {
public:
    int findPeakElement(std::vector<int>& nums) {
        int l = 0;
        int h = nums.size() - 1;

        while (l < h) {
            int m = l + (h - l)/2;

            if (nums[m] > nums[m + 1])
                h = m;
            else
                l = m + 1;
        }

        return l;
    }
};