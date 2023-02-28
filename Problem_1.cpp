34. Find First and Last Position of Element in Sorted Array



TC O(logn)
SC O(1)



class Solution {
public:
    int binarysearchleft(vector<int>& nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) {
                if ((mid == 0) || (nums[mid] > nums [mid - 1])) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return -1;
    }    

    int binarysearchright(vector<int>& nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) {
                if ((mid == nums.size()-1) || (nums[mid] < nums [mid + 1])) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }        
        return -1;
    }    


    vector<int> searchRange(vector<int>& nums, int target) {
        int n = nums.size();
        if (n == 0)  return {-1, -1};
        if ((nums[0] > target) || (nums[n-1] < target)) return {-1, -1}; // 3rd optimization
        int left = binarysearchleft(nums, 0, n-1, target);
        if (left == -1) return {-1, -1}; // 1st optimization (if left index is not found, no need to search right)
        //int right = binarysearchright(nums, 0, n-1, target); // 2nd optimization search for high from left to n-1, instead of 0 to n-1.
        int right = binarysearchright(nums, left, n-1, target); 
        return {left, right};
    }
};



