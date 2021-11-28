class Solution {
public:
    int BinaryLeftSearch(vector<int> &nums, int target){
        int low = 0;
        int high = nums.size()-1;
        int mid = low + (high-low)/2;
        while(low <= high){
            mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] < target){
                    return mid;
                }else{
                    high = mid-1;
                }
            }else if(nums[mid] < target){
                low = mid +1;
            }else if(nums[mid] > target){
                high = mid -1;
            }
        }
        return -1;
    }
    int BinaryRightSearch(vector<int> &nums, int target, int low){
        int high = nums.size()-1;
        int mid = low + (high-low)/2;

        while(low <= high){
            mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == nums.size()-1 || nums[mid+1] > target){
                    return mid;
                }else{
                    low = mid+1;
                }
            }else if(nums[mid] < target){
                low = mid +1;
            }else if(nums[mid] > target){
                high = mid -1;
            }
        }
        return -1;
    }
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> result{-1,-1};
        if(nums.size() == 0){
            return result;
        }
        if(nums.size() == 1 && nums[0] == target){
            result[0] = 0;
            result[1] = 0;
            return result;
        }
        int left = BinaryLeftSearch(nums, target);
        if(left == -1){
            return result;
        }
        int right = BinaryRightSearch(nums, target,left);
        result[0] = left;
        result[1] = right;

        return result;
    }
};