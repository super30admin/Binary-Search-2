// Time Complexity : 2log n which is O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:

    int binarySearch(vector<int>& nums, int target,bool leftBias)
    {
        int left = 0;
        int right = nums.size()-1;
        
        int index = -1;

        while(left<=right)
        {
            int mid = (left+right)/2;

            if(nums.at(mid) == target)
            {
                index = mid;
                if(leftBias)
                {
                    right = mid -1 ;
                }
                else
                {
                    left = mid +1;
                }
            }
            else if (nums.at(mid) > target)
            {
                right = mid -1 ;
            }
            else
            {
                left = mid +1;
            }

        }
        return index;
    }
    vector<int> searchRange(vector<int>& nums, int target) {

        vector<int> result;
        int first = binarySearch(nums,target,true);
        int second =-1;
        if(first!=-1)
            second = binarySearch(nums,target,false);
        return {first,second}; 
    }
};