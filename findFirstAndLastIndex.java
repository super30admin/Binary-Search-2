// Time Complexity: O(log N)
// Space Complexity: O(1)

// Did this run on leetcode: Yes
// Any Issues you faced while coding this: No

// Explaination

class Solution {
    int lowForLast;
    
    public int binarySearchFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2; // Prevent Integer overflow
            // Here we need to check if the number is target
            if(nums[mid] == target) {
                // If I found my target, it may or may not be the first index
                // So we need to check if the previous number is the same number of less
                // If the previous number to my current number is smaller 
                // that means its the first index of the target number
                if(mid == 0 || nums[mid] > nums[mid - 1]) {
                    return mid;
                } 
                // Otherwise keep moving left
                else {
                    high = mid - 1;
                }
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
    
    public int binarySearchLast(int[] nums, int target) {
        // Here instead of straightforward binary search two times
        // We can make optimization, we can make the first index of target as low pointer for next binary search
        int low = lowForLast;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2; // Prevent Integer overflow
            // If i found my target
            if(nums[mid] == target) {
                // To find lastIndex we need to check if the number is at last index
                // Then return that index
                // If the number if not last index then we need to check if the next number is greater than current number
                // Which would mean the current number or target is at lastIndex
                if(mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
                    return mid;
                } 
                // If the next number is not less than current number which means same number
                // Then keep moving right
                else {
                    low = mid + 1;
                }
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
    
    
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[] {-1, -1};
        if(nums[0] > target || nums[nums.length - 1] < target) return new int[] {-1, -1};

        int firstIndex = binarySearchFirst(nums, target);

        lowForLast = firstIndex; 
        int lastIndex = binarySearchLast(nums, target);
        return new int[] {firstIndex, lastIndex};
    }
}