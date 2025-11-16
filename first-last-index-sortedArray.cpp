// Time Complexity : O(log n) - did binary search twice which is 2* log n which is simply log n
// Space Complexity : O(1) - haven't used any extra space to perform the operations
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Leetcode(34): https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
/*Approach: The solution is designed based on Biased Binary search. If the target is found as mid, it doesnt mean that is the first or last occurance of target
        so, move left to find the first index and then move right to find the last index of the target ( 2 time binary search)
        
        Find the target using Binary search and then

        1. the target is found, then find the left most occurance: called left biased binary serach
        2. If first index is found then find the last index: move right 
*/

#include<iostream>

using namespace std;

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {

        //using binary search to find the fist index and last index of the target occurance
        int firstIndex = BinarySearch(nums, target, true); //left Biased
        int lastIndex = BinarySearch(nums, target, false); // right biased

        return {firstIndex, lastIndex};
    }

    int BinarySearch(vector<int>& nums, int target, bool isLeftBiased ){

        int low = 0, high = nums.size() - 1;

        int resIndex = -1;// to store the resultIndex to return, default -1 indicating not found,

        while(low <= high){
            int mid = low + (high - low)/2;

            //regular Binary search operation
            if(target > nums[mid]){
                low = mid + 1; //left search
            }
            else if(nums[mid] > target){

                high = mid - 1;
            }
            else{//index found at mid 
                resIndex = mid;
                if(isLeftBiased){//if it's left biased, we are now checking left most occurance .i.e first index, so high = mid - 1
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }

        }

        return resIndex;
    }
};