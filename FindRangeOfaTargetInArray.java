public class FindRangeOfaTargetInArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int n = nums.length;
        if (nums[0] > target || nums[n - 1] < target) {
            return new int[] { -1, -1 };
        }

        int startIndex = binarySearch(nums, target);
        if (startIndex < 0) {
            return new int[] { -1, -1 };
        }
        int endIndex = binarySeachEndIndex(nums, startIndex, target);

        return new int[] { startIndex, endIndex };

    }

    private int binarySeachEndIndex(int[] nums, int startIndex, int target) {
        int lowIndex = startIndex;
        int highIndex = nums.length - 1;
        int midIndex = 0;
        while (lowIndex <= highIndex) {
            midIndex = lowIndex + (highIndex - lowIndex) / 2;
            if (nums[midIndex] == target) {
                if (midIndex == nums.length - 1 || nums[midIndex] < nums[midIndex + 1]) {
                    return midIndex;
                } else {
                    lowIndex = midIndex + 1;
                }
            } else if (nums[midIndex] > target) {
                highIndex = midIndex - 1;
            } else {
                lowIndex = midIndex + 1;
            }
        }
        return startIndex;
    }

    private int binarySearch(int[] nums, int target) {
        int lowIndex = 0;
        int highIndex = nums.length - 1;
        int midIndex = 0;

        while (lowIndex <= highIndex) {
            midIndex = lowIndex + (highIndex - lowIndex) / 2;
            if (nums[midIndex] == target) {
                if ((midIndex == 0 || nums[midIndex - 1] < nums[midIndex])) {
                    return midIndex;
                } else {
                    highIndex = midIndex - 1;
                }
            } else if (nums[midIndex] > target) {
                highIndex = midIndex - 1;
            } else {
                lowIndex = midIndex + 1;
            }
        }
        return -1;
    }

}
