// I use binary search to determine which side of the array is sorted and then discard the sorted side
// because the minimum cannot lie there unless nums[mid] is the smallest element.
// By repeatedly narrowing the range toward the unsorted half, I can find the minimum in O(log n).

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;   // min must be to the right
            } else {
                right = mid;      // mid might be the minimum
            }
        }

        return nums[left];
    }
}

