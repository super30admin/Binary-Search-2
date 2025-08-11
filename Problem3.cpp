//## Problem 3: (https://leetcode.com/problems/find-peak-element/)
// compare mid element with ekement before, if mid is lesser there is chance of peak at right, so do search in right.


#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int start = 0;
        int end = nums.size() - 1;

        while(start < end){
            int mid = start + (end - start)/2;
    
        if (nums[mid] < nums[mid + 1]){
            start = mid + 1;
        }
        else 
        end = mid;

        }
        return start;
    }
};