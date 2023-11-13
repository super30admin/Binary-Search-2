// Time Complexity : 2log(n)
// Space Complexity: O(1)

// Find first and Last position of target element using binary search algorithm
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target)
            return new int[]{-1,-1};

        // Find first left side element
        int first = findFirstMid(nums, target);
        int last = first;
        if(first != -1){
            last = findSecondMid(nums, target, first);
        }

        return new int[]{first, last};
    }


    private int findFirstMid(int nums[], int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(low == mid || nums[mid -1] != target)  return mid;
                else
                    high = mid - 1;
            }else if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    private int findSecondMid(int nums[], int target, int low){
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(high == mid || nums[mid +1] != target)  return mid;
                else
                    low = mid + 1;
            }else if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}