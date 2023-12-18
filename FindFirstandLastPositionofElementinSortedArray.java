// Time Complexity : O(logn)
// Space Complexity : O(1)
// Method used : Binary Search

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = {-1, -1};

        result[0] = binarySearch(nums, target, 0, nums.length - 1, 0);

        if(result[0] == -1) return result;

        result[1] = binarySearch(nums, target, 0, nums.length - 1, 1);

        return result;
    }

    private int binarySearch(int[] nums, int target, int low, int high, int flag)
    {
        int save_index = -1;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target)
            {
                save_index = mid;

                if(flag == 0) high = mid - 1;
                else low = mid + 1;
            }

            else if(nums[mid] < target) low = mid + 1;

            else high = mid - 1;
        }

        return save_index;
    }
}