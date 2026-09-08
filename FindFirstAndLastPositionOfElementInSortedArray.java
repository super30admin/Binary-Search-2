
// Time Complexity :log (n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//Main Idea: Find the first  and last position seperately using  seperate Binary search.

class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0)
            return new int[] { -1, -1 };

        int firstIndex = findFirstElement(nums, target, 0, nums.length - 1);
        if (firstIndex == -1)
            return new int[] { -1, -1 };
        int lastIndex = findLastElement(nums, target, firstIndex, nums.length - 1);
        return new int[] { firstIndex, lastIndex };
    }

    int findFirstElement(int nums[], int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            //if mid has target and it is the first occurance of target
            if (nums[mid] == target && (mid == 0 ||
                    nums[mid - 1] < nums[mid])) {

                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return -1;
    }

    int findLastElement(int nums[], int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //System.out.println("mid"+mid);

            //check in which part my last index of the target lies
            if (nums[mid] == target && (mid == nums.length - 1 ||
                    nums[mid + 1] > nums[mid])) {
                return mid;
            } else if (target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return -1;

    }

}