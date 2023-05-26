// Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// We compare the value at the midpoint with the value at the right pointer to determine if the minimum element lies on the right or left side of the midpoint. If the value at mid is greater than the value at right, it means the minimum element lies on the right side. In this case, the left pointer is updated to mid + 1. Otherwise, if the value at mid is less than or equal to the value at right, it means the minimum element lies on the left side. In this case, the right pointer is updated to mid.
//  The while loop continues until the left pointer is no longer less than the right pointer, indicating that the search range has been narrowed down to a single element. At this point, the left pointer represents the index of the minimum element, and we return nums[left]

class Problem2 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Problem2 s = new Problem2();
        int[] arr = { 3, 4, 5, 11, 2 };
        System.out.println("Minium element is " + s.findMin(arr));
    }
}