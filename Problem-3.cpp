// Time Complexity : O(log n)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Checking if neighbors are higher and moving 
// towards higher range of elements.

// Find peak element

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int n = nums.size();
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = low + ((high-low)/2);
            if((mid == 0 || nums[mid] > nums[mid-1]) && 
                (mid == n-1 || nums[mid] > nums[mid+1])){
                return mid;
            }
            else if(nums[mid] > nums[mid+1]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
};