/**
 * Noteworthy observation about min: Min is always smaller than its previous element.
 * All other elements are larger than their previous.
 * So we keep looking min in unsorted part.
 *
 */
class SolutionThree {
    public int findMin(int[] nums) {
        // We are interested in finding min. 
        // Noteworthy observation about min. 
        // Min is always smaller than its previous element. 
        // All other elements are larger than their previous. 
        // Array will look sorted except at one point where we loose the sort property
        // This is the point where we get our min
        // If array is fully sorted, first element is the min. 

        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Check if array is fully sorted. 
            if (nums[low] < nums[high]) {
                return nums[low];
            }

            // Check if mid is the min
            if (mid != 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } // In situation where mid is the 0th element:
            // 1. mid was min as well. This was covered in fully sorted array, we returned mid
            // 2. mid was not the mean, we have the right to ignore mid in this case

            // Now, although mid is not the min, the min will lie in unsorted subarry
            // Set low and high to point to unsorted subarray
            else if (nums [low] <= nums [mid]) { // Low can be equeal to mid
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Some invalid input array. 
        return Integer.MAX_VALUE;
    }
}