
/**
 * 1. Use binary search twice — once to find the starting index, once for the ending index.
 * 2. For starting index, move left (high = mid - 1) when target is found.
 * 3. For ending index, move right (low = mid + 1) when target is found.
 */

class FindFirstandLastPositioninSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = searchStartingIndex(nums, target);
        result[1] = searchEndingIndex(nums, target);
        return result;
    }

    public int searchStartingIndex(int[] nums, int target) {
        int low = 0, high = nums.length - 1, res = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                res = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    public int searchEndingIndex(int[] nums, int target) {
        int low = 0, high = nums.length - 1, res = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                res = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindFirstandLastPositioninSortedArray sol = new FindFirstandLastPositioninSortedArray();

        int[] nums1 = {2, 2, 2, 4, 4, 7, 7, 8, 8, 8, 8, 9};
        int target1 = 8;
        int[] res1 = sol.searchRange(nums1, target1);
        System.out.println("Start and end index of " + target1 + ": [" + res1[0] + ", " + res1[1] + "]"); // Expected: [7, 10]
    }
}
