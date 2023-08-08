//TC = 0(logn)
//sc= 0(1)

public class FirstAndLastEleOfArr {

    public static void main(String[] args) {

        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;

        FirstAndLastEleOfArr output = new FirstAndLastEleOfArr();
        int[] obj1 = output.searchRange(nums, target);

        if (obj1[0] != -1 && obj1[1] != -1) {
            System.out.println("range of index: [" + obj1[0] + ", " + obj1[1] + "]");
        } else {
            System.out.println("Target not found.");
        }

    }

    private int binarySearchFirst(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] > nums[mid - 1]) {
                    return mid;

                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == high || nums[mid] < nums[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0)
            return new int[] { -1, -1 };
        int n = nums.length;
        if (nums[0] > target || nums[n - 1] < target)
            return new int[] { -1, -1 };
        int first = binarySearchFirst(nums, target);
        if (first == -1)
            return new int[] { -1, -1 };
        int last = binarySearchLast(nums, first, n - 1, target);
        return new int[] { first, last };

    }

}
