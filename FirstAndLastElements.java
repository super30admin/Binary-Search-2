// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

/*
Need to find the first and last occurrence of given target.
Utilizing Binary Search algorithm to identify the first index.
Again utilizing Binary Search algorithm to identify the last index.
 */
public class FirstAndLastElements {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};

        int[] res = new int[2];
        int low = 0, high = nums.length - 1, mid;

        int first  = -1, last = -1;
        first = getFirstIndex(nums, target);
        if(first > -1)
            last = getLastIndex(nums, target, first);

        return new int[]{first, last};
    }

    public int getFirstIndex(int[] nums,int target){
        int low = 0, high = nums.length - 1, mid;
        while(low <= high) {
            mid = low + (high - low)/2;
            if(nums[mid] == target)
            {
                if(mid == 0 || nums[mid] != nums[mid -1])
                    return mid;
                else
                    high = mid - 1;
            }
            else if(nums[mid] < target)
                low = mid  + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public int getLastIndex(int[] nums,int target, int first){
        int low = first, high = nums.length - 1, mid;
        while(low <= high) {
            mid = low + (high - low)/2;
            if(nums[mid] == target)
            {
                if(mid == high || nums[mid] != nums[mid + 1])
                    return mid;
                else
                    low = mid + 1;
            }
            else if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid -1;
        }
        return -1;
    }

}
