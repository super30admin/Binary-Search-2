// Time Complexity                              : O(log n)           
// Space Complexity                             : O(1)
// Did this code successfully run on Leetcode   : Yes
// Any problem you faced while coding this      : No


// Your code here along with comments explaining your approach

#include <bits/stdc++.h>
using namespace std;


class Solution {
private: 
    int search(vector<int>& nums,int l,int r) {
        if(l == r) 
            return l;
        int m = l + (r-l)/2;
        if(nums[m] > nums[m+1])
            return search(nums,l,m);
        return search(nums,m+1,r);
    }
public:
    int findPeakElement(vector<int>& nums) {
        return search(nums,0,nums.size()-1);
    }
};