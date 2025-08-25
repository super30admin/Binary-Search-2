//Time Complexity - O(log n)
//Space Complexity - O(1)
//Did it run on leetcode - yes

//Your approach
/*
Using binary search find the first position of target in the given array
if first index not found then target is not present return [-1,-1] immediately
Search for the second index using the mid of first search as low and continue with the binary search
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int firstIndex = firstBinarySearch(nums, l, h, target);
        if (firstIndex == -1) return new int[]{-1,-1}; //no target found
        int secondaryIndex = secondBinarySearch(nums, firstIndex, h, target);
        return new int[]{firstIndex, secondaryIndex};
    }

    private int firstBinarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid-1] != target) {
                    // we have found the first index of target
                    return mid;
                } else {
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

    private int secondBinarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) {
                if (mid == nums.length -1 || nums[mid+1] != target) {
                    // found the second index
                    return mid;
                } else {
                    low = mid +1;
                }
            } else if(nums[mid] > target) {
                high = mid - 1; 
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
