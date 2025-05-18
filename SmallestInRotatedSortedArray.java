public class SmallestInRotatedSortedArray {
    /*
    During binary search if the mid is smaller than both neighbors, it is
    the smallest as it is pivot. Optimal solution is to check only the left neighbor
    of mid is bigger as it will be the pivot since array is sorted, so right neighbor
    will automatically be bigger.
    Time: log n Space: O(1)
     */

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            if (nums[low] <= nums[high]) {
                return nums[low];
            }
            int mid = low + (high - low) / 2;

            if ((mid != 0 && nums[mid] < nums[mid - 1])) {
                return nums[mid];
            } else if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
