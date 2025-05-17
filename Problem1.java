// Time complexity - O(log n)
// Space complexity - O(1)
// DID you solve in leetcode - Yes
// Face any issues while solving - No
// to find the 1st index and last index of the target we are doing binary search individually
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int i = getFirst(nums, low, high, target);
        int j = getLast(nums, low, high, target);

        return new int[] {i,j};
    }

    public int getFirst(int[] nums, int low, int high, int target) {
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                if(mid == low || nums[mid-1] < target) return mid;
                else {
                    high = mid-1;
                }
            } else if(nums[mid] < target) {
                low = mid +1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }

    public int getLast(int[] nums, int low, int high, int target) {
        while(low<=high) {
            int mid = low + (high - low)/2;

            if(nums[mid] == target) {
                if(mid == high || nums[mid+1] > target) return mid;
                else {
                    low = mid+1;
                }
            } else if(nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
        
    }
}
