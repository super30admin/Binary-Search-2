// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Didnt take the case where only element is INT_MIN


// Your code here along with comments explaining your approach in three sentences only
// Binary Search: Say we have the mid element. We first check if the current element is peak.
// If not, we observe that if the left element is greater than mid then it is guaranteed to have a peak element.
// Similarly, for the right element.  


#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int low = 0, high = nums.size()-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            int lVal = getLeftVal(nums,mid);
            int rVal = getRightVal(nums,mid);
            if(nums[mid]>=lVal && nums[mid]>=rVal) {
                return mid;
            }
            else if(lVal > nums[mid]){
                high = mid-1;
            }
            else {
                low = mid+1;
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