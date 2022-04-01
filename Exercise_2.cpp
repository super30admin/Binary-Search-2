// Time Complexity                              : O(log n)           
// Space Complexity                             : O(1)
// Did this code successfully run on Leetcode   : Yes
// Any problem you faced while coding this      : No


// Your code here along with comments explaining your approach

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findMin(vector<int>& nums) {
        int n = nums.size();
        if(n == 1 or nums[0] < nums[n-1]) return nums[0];
        int l = 0, r = n-1, md;
        while(l <= r) {
            md = l + (r-l)/2;
            if(nums[md] > nums[md+1]) break;
            if(nums[md] < nums[0]) r = md - 1;
            else if (nums[md] >= nums[0]) l = md+1;
        }
        return nums[md] > nums[md+1] ? nums[md+1] : nums[md];
    }
};