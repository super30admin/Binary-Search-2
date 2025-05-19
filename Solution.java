// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int l = 0, r = nums.length - 1;
        result[0] = findFirstOccurrence(nums, l, r, target);
        result[1] = findLastOccurrence(nums, l, r, target);
        return result;
    }

    public int findFirstOccurrence(int[] nums, int l, int r, int target) {
        int index = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target)
                index = mid;
            if (nums[mid] >= target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return index;
    }

    public int findLastOccurrence(int[] nums, int l, int r, int target) {
        int index = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target)
                index = mid;
            if (nums[mid] <= target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return index;
    }
}

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class FindMinInRotatedArray {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, res = nums[0];

        while (l <= r) {
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                return res;
            }

            int mid = l + (r - l) / 2;
            res = Math.min(res, nums[mid]);

            if (nums[l] <= nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else if (mid < nums.length - 1 && nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}

public class Solution {
    public static void main(String[] args) {
        SearchRange srs = new SearchRange();
        int[] nums1 = { 5, 7, 7, 8, 8, 10 };
        int[] result1 = srs.searchRange(nums1, 8);
        System.out.println("Search Range Result: [" + result1[0] + ", " + result1[1] + "]");

        FindMinInRotatedArray fms = new FindMinInRotatedArray();
        int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println("Minimum in Rotated Array: " + fms.findMin(nums2));

        FindPeakElement fpes = new FindPeakElement();
        int[] nums3 = { 1, 2, 3, 1 };
        System.out.println("Peak Element Index: " + fpes.findPeakElement(nums3));
    }
}
