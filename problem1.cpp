#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) 
    {
        int left = leftSearch(nums, target, 0, nums.size()-1);
        int right = rightSearch(nums, target, 0, nums.size()-1);
        
        return {left,right};
    }
    
    int leftSearch(vector<int>nums, int target, int start, int end)
    {   
        
        int middle = start + (end - start)/2;
        if(start > end) return -1;
        
        else if(nums[middle] == target)
        {
            if(middle == start || nums[middle] > nums[middle - 1])
                return middle;
            else
                return leftSearch(nums, target, start, middle-1);
        }
        else if(nums[middle] > target) 
            return leftSearch(nums, target, start, middle -1);
        else 
            return leftSearch(nums, target,middle+1, end);
    }
    
    int rightSearch(vector<int>nums, int target, int start, int end)
    {  
        
        int middle = start + (end - start)/2;
        if(start > end) return -1;
        
        else if(nums[middle] == target)
        {
            if(middle == end || nums[middle] < nums[middle + 1])
                return middle;
            else
                return rightSearch(nums, target, middle+1, end);
        }
        
        else if(nums[middle] > target) 
            return rightSearch(nums, target,start, middle-1);
        else 
            return rightSearch(nums, target, middle+1, end);
    }
         

};