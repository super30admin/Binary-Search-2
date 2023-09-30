// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Technique: Binary search
// We know that in a rotated array, one part is sorted and another is not.
// We also see that is the whole array is sorted then the first element is the smallest.
// But if it is not sorted then the pivot will surely lie in the unsorted part.

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findMin(vector<int>& nums) {
        int st = 0, end = nums.size()-1;
        while(st<=end) {
            // Check if space is sorted, if yes first element is smallest
            if(nums[st] <= nums[end]) {
                return nums[st];
            }

            // Now check mid is min
            int mid = st + (end-st)/2;
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid==nums.size()-1 || nums[mid] < nums[mid+1]) ) {
                return nums[mid];
            }
            
            // If left part is sorted then search in right
            if(nums[st]<=nums[mid]) {
                st = mid+1;
            }
            // If right part is sorted then search in left
            else {
                end = mid-1;
            }
        }
        return -1;
    }
};

int main() {
    vector<int> nums{};
    Solution S;
    cout<<S.findMin(nums)<<endl;
}