// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Did not draw on whiteboard so missed edge cases


// Your code here along with comments explaining your approach in three sentences only
// Technique: Binary search with global variable to track the minimum value.
// We check if the mid elem is less than global and update it.
// Now smaller element, if possible, can be in unsorted array. So search in the unsorted part.
// Return the global min value

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findMin(vector<int>& nums) {
        int st = 0, end = nums.size()-1;
        int minVal = nums[0];
        while(st<=end) {
            // Check if space is sorted, if yes first element is smallest
            // if(nums[st] <= nums[end]) {
            //     return nums[st];
            // }

            // Now check mid is min
            int mid = st + (end-st)/2;
            // if((mid == 0 || nums[mid] < nums[mid-1]) && (mid==nums.size()-1 || nums[mid] < nums[mid+1]) ) {
            //     return nums[mid];
            // }
            minVal = min(minVal, nums[mid]);
            cout<<minVal<<endl;
            // If left part is sorted then search in right
            if(nums[end]>=nums[mid]) {
                
                end = mid-1;
            }
            // If right part is sorted then search in left
            else {
                st = mid+1;
            }
        }
        return minVal;
    }
};

int main() {
    vector<int> nums{3,1,2};
    Solution S;
    cout<<S.findMin(nums)<<endl;
}