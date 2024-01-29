//Time Complexity - O(logn)
//Space Complexity - O(1)
//Did it run successfully on leetcode - yes
//Issues encountered - Was getting array index out of bound because of a missing condition check.

//Approach - In this variant of binary search problem, the peak element can be found towards the side with elements greater than the mid.

public class FindPeakElement {

    public int findPeakElement(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid - 1] < nums[mid])
                    && (mid == nums.length - 1 || nums[mid + 1] < nums[mid])) {
                return mid;
            } else if (mid != high && nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return 0;
    }
}
