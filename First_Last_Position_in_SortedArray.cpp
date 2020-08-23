// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> result(2, -1);
        int left = leftlimit(nums, target);
        if (left == -1){
             result[0] = -1;
        result[1] = -1;
        return result;
        }
        int rigth = rigthlimit(nums,target);
        result[0] = left;
        result[1] = rigth;
        return result;
    }
    
    int leftlimit(vector<int>& nums, int target){
        int left = 0;
        int rigth = nums.size() -1;
        
        while ( left<= rigth){
            int mid = left + (rigth - left)/2;
            
            if (nums[mid]== target ){
                if (mid == 0 || nums[mid -1] != target){
                    return mid;
                } 
                rigth = mid -1;
            }else if (nums[mid] > target)
                rigth = mid -1;
            else left = mid +1;
        }
        return -1;
    }
    
    int rigthlimit(vector<int>& nums, int target){
        int left = 0;
        int rigth = nums.size() -1;
        
        while ( left<= rigth){
           int mid = left + (rigth - left)/2;
            
            if (nums[mid]== target ){
                if ( rigth == mid || nums[mid + 1] != target){
                    return mid;
                }
                left = mid + 1;
            }else if (nums[mid] > target)
                rigth = mid - 1;
             else left = mid + 1;
        }
        return -1;
        }
};