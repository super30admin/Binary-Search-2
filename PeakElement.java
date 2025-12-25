// Approach:
// Find the mid element, if the values mid-1 < mid > mid +1, we found the peak, return mid index;

// If the values are in the order mid-1 < mid < mid+1, we search the second half of the array. Because it atleast
// has one value greater that the current mid, so for it to be peak it just need to have the next value lesser than itself.

// Similarly, if the values are in the order, mid-1 > mid > mid+1, search the first half of the array.
public class PeakElement {

    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;
        if (len == 2) return nums[0] > nums[1] ? 0 : 1;

        int low = 0;
        int high = len;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == len - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            }
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
