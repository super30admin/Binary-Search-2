public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if the mid element is greater than its neighbors
            if (nums[mid] > nums[mid + 1]) {
                // Peak element must be in the left half
                right = mid;
            } else {
                // Peak element must be in the right half
                left = mid + 1;
            }
        }

        // 'left' will be pointing to a peak element
        return left;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int result1 = findPeakElement(nums1);
        System.out.println("Example 1: " + result1);

        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        int result2 = findPeakElement(nums2);
        System.out.println("Example 2: " + result2);
    }
}
