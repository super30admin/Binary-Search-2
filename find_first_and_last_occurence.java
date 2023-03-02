// Time Complexity: O(log(N)); worst case would be binary search 2 times, once to find first occurence and another to find last occurence.
// Space Complexity: O(1)
// Did this run on Leetcode? : Yes
class Solution {
    private int findOccurence(int[] nums, int target, boolean findLeftOccurence) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (nums[mid] == target) {
                if (findLeftOccurence) {
                    if (left == mid || nums[mid] != nums[mid - 1]) {
                        return mid;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (right == mid || nums[mid] != nums[mid + 1]) {
                        return mid;
                    } else {
                        left = mid + 1;
                    }
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[] { -1, -1};
        }

        if(nums.length == 1) {
            if (nums[0] == target) {
                return new int[] { 0, 0 };
            }

            return new int[] { -1, -1};
        }

        int leftOccurence = findOccurence(nums, target, true);

        if (leftOccurence == -1) {
            return new int[] { -1, -1};
        }

        int rightOccurence = findOccurence(nums, target, false);

        return new int[] { leftOccurence, rightOccurence };
    }
}