//34. Find First and Last Position of Element in Sorted Array

/*
Binary search implementation - first find the left index using binary search, if found do the same to get right index with left index as low

Time complexity: O(Log N)
Space complexity: O(1)

*/

class Solution {
public:
    
    int binarySearchLeft(vector<int> nums, int target){
        int low = 0;
        int high = nums.size()-1;
        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                if(mid == 0 || nums[mid] > nums[mid-1]) return mid;
                else high = mid - 1;
            }else if(nums[mid] > target) high = mid -1;
            else low = mid + 1;
        }
        return -1;
    }

    int binarySearchRight(vector<int> nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                if(mid == nums.size() - 1 || nums[mid] < nums[mid+1]) return mid;
                else low = mid + 1; //move right
            }else if(nums[mid] > target) high = mid - 1;
            else low = mid+1;
        }

        return -1;
    }
    
    vector<int> searchRange(vector<int>& nums, int target) {
        
        //s30
        if(nums.size() == 0) return {-1,-1};

        int left = binarySearchLeft(nums, target);
        if(left == -1) return {-1, -1};

        int right = binarySearchRight(nums, left, nums.size() - 1, target);

        return {left, right};       
        
    }
};