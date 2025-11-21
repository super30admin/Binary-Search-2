
// we will two searches, return first occurrence from the first search and second occurrence from the second search
// To find the first occurrence, we check if value at mid is equal to target, 
// we need to keep moving towards left until we know that nums[mid -1] is not equal to target
// and that will be the first occurrence
//For last occurrence, we keep moving towards right side until nums[mid+1] is not equual to target

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstPosition(nums, target, 0, nums.length - 1);

        if (first == -1) {
            return new int[]{-1,-1};
        }

        int last = lastPosition(nums, target, first, nums.length - 1);

        return new int[]{first, last};
    }      

    private int firstPosition(int[] nums, int target, int i, int j) {
        while (i <= j) {
            int mid = i + (j-i)/2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid-1] != target) {
                    return mid;
                } else {
                    j = mid - 1;
                }
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }

    private int lastPosition(int[] nums, int target, int i, int j) {
        while (i <= j) {
            int mid = i + (j-i)/2;

            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid+1] != target) {
                    return mid;
                } else {
                    i = mid + 1;
                }
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }
}

// Time complexity: O(logn)
// Space complexity: O(1)