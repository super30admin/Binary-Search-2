// Time Complexity                              : O(log n)           
// Space Complexity                             : O(1)
// Did this code successfully run on Leetcode   : Yes
// Any problem you faced while coding this      : No


// Your code here along with comments explaining your approach

#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    int search(vector<int>& nums, int target, bool first) {
        int n = nums.size(), l = 0, r = n-1;
        
        while(l <= r) {
            int md = l + (r - l)/2;
            if(target == nums[md]) {
                if(first) {
                    if(md == 0 || nums[md-1] != target) {
                        return md;
                    } else {
                        r = md - 1;
                    }
                } else {
                    if(md == n-1 || nums[md + 1] != target) {
                        return md;
                    } else {
                        l = md + 1;
                    }
                }
            } else if (target > nums[md]) {
                l = md + 1;
            } else {
                r = md - 1;
            }
        }
        return -1;
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int n = nums.size();
        
        if(n == 1) {
            if(nums[0] == target) {
                return {0,0};
            } else {
                return {-1, -1};
            }
        }
        
        int l = search(nums,target,true);
        int r = search(nums,target,false);
        
        
        
        
        return {l,r};
    }
};