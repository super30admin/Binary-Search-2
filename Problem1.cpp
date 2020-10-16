//LeetCode #34. Find First and Last Position of Element in Sorted Array
// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
/*
    Using binarySearchLeft to find first occurence of the target and
    using binarySearchRight to find the last occurence of the target.
    
    To find the first occurence of the target, we check if the target is at
    middle position. If target is in middle position, we compare the left neighbor
    of middle element with the middle element. If the middle element is greater
    than its left neigbor middle is equal to 'low' index, it implies that the
    target's first occurence is at middle position. If not, we need to move the
    'high' pointer to mid-1.
 
    To find the last occurence of the target, we check if the target is at
    middle position. If target is in middle position, we compare the right neighbor
    of middle element with the middle element. If the middle element is greater
    than its right neigbor or middle is equal to 'high' index, it implies that the
    target's first occurence is at middle position. If not, we need to move the
    'low' pointer to mid+1.
*/

class Solution {
public:
    
    int binarySearchLeft(vector<int>& nums, int target) {
        int low = 0, high = nums.size()-1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target){
                if(mid == low || nums[mid] > nums[mid-1])
                    return mid;
                else
                    high = mid-1;
            }
            else if(nums[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
    
    int binarySearchRight(vector<int>& nums, int target) {
        int low = 0, high = nums.size()-1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == high || nums[mid] < nums[mid+1])
                    return mid;
                else
                    low = mid+1;
            }
            else if(nums[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> res;
        res.push_back(binarySearchLeft(nums, target));
        res.push_back(binarySearchRight(nums, target));
        return res;
    }
};
