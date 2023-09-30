// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Linear search: Compare current element with both its left and right element

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        for(int i=0; i<nums.size(); i++) {
            if(nums[i] >= getLeftVal(nums,i) && nums[i] >= getRightVal(nums,i)) {
                return i;
            }
        }
        return -1;
    }

    int getLeftVal(vector<int>& nums, int mid) {
        if(mid<=0) {
            return INT_MIN;
        }
        return nums[mid-1];
    }

    int getRightVal(vector<int>& nums, int mid) {
        if(mid>=nums.size()-1) {
            return INT_MIN;
        }
        return nums[mid+1];
    }
};

int main() {
    vector<int> nums{1,2,1,3,5,6,4};
    Solution S;
    cout<<S.findPeakElement(nums)<<endl;
}