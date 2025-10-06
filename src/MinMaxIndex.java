package src;

// Time Complexity: O(log n)
// Space Complexity: O(1)
// Find the starting and ending position of a given target value in a sorted array. If the target is not found, return [-1, -1].
public class MinMaxIndex {

    public int[] searchRange(int[] nums, int target) {

        int low = 0;
        int high = nums.length -1;

        int index1 = binarySearch1(nums, target, low, high);
        if (index1 == -1) {
            return new int[] {-1, -1};

        }
        int index2 = binarySearch2(nums, target, index1, high);

        return new int[] {index1, index2};

    }

    public int binarySearch1(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low)/2;

            if (nums[mid] == target) {
                if(mid == 0 || nums[mid -1] != target) {
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

    public int binarySearch2(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low)/2;

            if (nums[mid] == target) {
                if(mid == nums.length-1 || nums[mid +1] != target) {
                    return mid;
                } else {
                    low = mid + 1;
                }

            } else if (nums[mid] > target) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }

        }
        return -1;
    }
}
