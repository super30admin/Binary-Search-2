// ## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Here the searchRange method takes the input array nums and target value target. It calls the helper method search method twice, once to find the first occurrence of the target (flag set to true), and once to find the last occurrence (flag set to false). Within the search method we perform a modified binary search based upon the flag value. We maintains two pointers, left and right, which define the search range and uses a while loop to iteratively narrow down the search range until left becomes greater than right. Here we return mid, which is starting and ending position of target based upon the flag value. If target is not found we return -1 and we return [-1,-1] as result.

import java.util.Arrays;

class Problem1 {
    public int[] searchRange(int[] nums, int target) {
        int firstOcc = search(nums, target, true);
        if (firstOcc == -1) {
            return new int[] { -1, -1 };
        }
        int secOcc = search(nums, target, false);
        return new int[] { firstOcc, secOcc };
    }

    public static int search(int[] nums, int target, boolean flag) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (flag) {
                    if (mid == left || nums[mid] != nums[mid - 1]) {
                        return mid;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (mid == right || nums[mid] != nums[mid + 1]) {
                        return mid;
                    } else {
                        left = mid + 1;
                    }
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Problem1 s = new Problem1();
        int[] arr = { 5, 7, 7, 8, 8, 8, 10, 12, 12, 13 };
        int[] ans;
        ans = s.searchRange(arr, 8);
        System.out.println("First and Last position of element is " + Arrays.toString(ans));
    }
}
