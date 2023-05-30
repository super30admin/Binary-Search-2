class Solution {
public:
    int binarySearchFirstIndex(vector<int>& nums, int target) {
        int low = 0; 
        int high = nums.size()-1; 

        while(low <= high) {
            int mid = (low+high)/2; 
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid-1] != target) return mid; 
                else high = mid-1; 
            } else {
                if(nums[mid] < target) low = mid+1; 
                else high = mid-1; 
            }
        }

        return -1; 
    } 

        int binarySearchSecondIndex(vector<int>& nums, int target) {
        int low = 0; 
        int high = nums.size()-1; 

        while(low <= high) {
            int mid = (low+high)/2; 
            if(nums[mid] == target) {
                if(mid == nums.size()-1  || nums[mid+1] != target) return mid; 
                else low = mid+1; 
            } else {
                if(nums[mid] < target) low = mid+1; 
                else high = mid-1; 
            }
        }

        return -1; 
    } 
    
    vector<int> searchRange(vector<int>& nums, int target) {
        if(nums.size() == 0) return {-1,-1};
        if(nums.size() == 1) {
            if(nums[0] == target) return {0,0};
            return {-1,-1};
        }

        int firstIndex = binarySearchFirstIndex(nums, target);
        int secondIndex = binarySearchSecondIndex(nums, target);

        return {firstIndex, secondIndex};
    }
};