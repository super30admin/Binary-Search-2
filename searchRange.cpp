// Time Complexity : Not sure, I think O(n) because of finding min and max elements
// Space Complexity : I think O(log n)^2 because of n 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Time and space complexities


// Your code here along with comments explaining your approach
// 1. Recursive approach to a modified binary search
// 2. If element not found return -1 but if element is found don't stop when binary search finds a result
// 3. Recursively call modified binary search for left and right subarrays

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> result;
        vector<int> range;
        result=modifiedBinarySearch(0,nums.size()-1,nums,target);
        range.emplace_back(*min_element(result.begin(),result.end()));
        range.emplace_back(*max_element(result.begin(),result.end()));
        return range;
    }
    
    vector<int> modifiedBinarySearch(int l, int r, vector<int> nums, int target){
        int mid=binarySearch(l,r,nums,target);
     
        vector<int> result;
        if(mid==-1){
            result.emplace_back(-1);
            result.emplace_back(-1);
            return result;
        }
        else
            result.emplace_back(mid);
        
        vector<int> left = modifiedBinarySearch(l,mid-1,nums,target);
        vector<int> right = modifiedBinarySearch(mid+1,r,nums,target);
        
        if(left[0]!=-1){
            for(auto i:left)
                result.emplace_back(i);
        }
            
        if(right[0]!=-1){
            for(auto i:right)
                result.emplace_back(i);
        }
     
        return result;
    }
    
    int binarySearch(int l, int r, vector<int> nums, int target){
     
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target)
                return mid;
            else if(target<nums[mid])
                r=mid-1;
            else
                l=mid+1;
        }
        return -1;
    }
};
