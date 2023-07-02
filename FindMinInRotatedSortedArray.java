public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int lowIndex = 0;
        int highIndex = nums.length - 1;
        int midIndex = 0;

        while (lowIndex < highIndex) {
            if (nums[lowIndex] < nums[highIndex]) {
                return nums[lowIndex];
            }

            midIndex = lowIndex + (highIndex - lowIndex) / 2;
            if ((midIndex == 0 || nums[midIndex] < nums[midIndex - 1])
                    && (midIndex == nums.length - 1 || nums[midIndex] < nums[midIndex + 1])) {
                return nums[midIndex];
            }
            if (nums[lowIndex] <= nums[midIndex]) {
                lowIndex = midIndex + 1;
            } else {
                highIndex = midIndex - 1;
            }
        }
        return nums[highIndex];
    }
}
