
class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2; // Avoid potential overflow

            if (nums[mid] > nums[mid + 1]) {
                // Peak is in the left half (including mid)
                high = mid;
            } else {
                // Peak is in the right half
                low = mid + 1;
            }
        }

        return low; // or return high; both will be the peak index
    }

    public static void main(String[] args) {
        FindPeakElement sol = new FindPeakElement();

        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Peak index in nums1: " + sol.findPeakElement(nums1)); // Expected: 2

        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Peak index in nums2: " + sol.findPeakElement(nums2)); // Expected: 1 or 5

    }
}
