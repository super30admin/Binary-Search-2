public class FindPeakElement {
    /*
    For an array of non-repeated neighbours, at any position choosing the side with higher value neighbor
    eventually will take us to peak. with this knowledge, binary search could find us peak in log n time.
    Time: log n Space: O(1)
     */
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            if (low == high) {
                return low;
            }

            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid] > nums[mid - 1])
                    && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if(mid != 0  && nums[mid] < nums[mid - 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
