/*Approach : 
1. Use BS: condtion to reject one-half of array is middle element < adjoining element.
2. if both the adjoining elements are less that middle return middle element. If its at edge reuturn directly
*/
class FindThePeak{
    public int findPeakElement(int[] nums) {
 
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid == 0 || nums[mid] > nums[mid - 1]) &&
                    (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            }
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}