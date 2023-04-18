
// Time Complexity :O(2logN) =~ O(logN)
// Space Complexity :O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1,-1};
        }
        int firstPosition = binarySearch(nums, target, "first");
        if (firstPosition == -1) {
            return new int[] {-1,-1};
        }
        int lastPosition = binarySearch(nums, target, "last");

        return new int[] {firstPosition, lastPosition};
    }

    private int binarySearch(int[] nums, int target, String position) {
        int low = 0; 
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) {
                if (position == "first") {
                    if (mid == low || nums[mid -1 ] != nums[mid]) {
                        return mid;
                    }
                    else {
                        high = mid -1;

                    }
                }
                else {
                    if (mid == high || nums[mid+1] != nums[mid]) {
                        return mid;
                    }
                    else {
                        low = mid +1;

                    }
                }
            }
            else if (target > nums[mid]) {
                low = mid + 1;
            }
            else {
                high = mid -1;
            }
        }
        return -1;
    }
}