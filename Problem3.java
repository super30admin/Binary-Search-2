// https://leetcode.com/problems/find-peak-element/
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
// Compare the mid with next element, if it is greater than the mid element then we know that next series of elements are smaller and either the mid or any element in left to mid range could be a peak. Repeat this process till the base condition is made false. The index left would store the peak element.

public class Problem3 {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Problem3 s = new Problem3();
        int[] arr = { 1, 2, 3, 5, 1 };
        System.out.println("Peak Element: " + s.findPeakElement(arr));
    }
}
