package s30.week1;

public class FindPeakElement {

    // consider this problem as a range of mountain
    // if you keep moving towards the higher element, you are sure to find a peak
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            //Identified the mid
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n -1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if(mid == n - 1 || nums[mid + 1] > nums[mid]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;

        //if low < mid || return low or high
    }
}
