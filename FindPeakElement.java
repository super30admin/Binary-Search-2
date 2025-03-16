// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: find mid. if mid is peak or mid is at end of array. if climb on right then move to right and vice versa

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            //if mid or leftmost or rightmost index is peak
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n-1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if(mid == n-1 || nums[mid + 1] > nums[mid]) {  //climb on right of mid
                low = mid + 1;
            } else {    //decend on left of peak
                high = mid - 1;
            }
        }
        return -1;  //no peak
    }

    public static void main(String[] args) {
        FindPeakElement solver = new FindPeakElement();

        int[] nums1 = {1, 2, 3, 1};
        int peakIndex1 = solver.findPeakElement(nums1);
        System.out.println("Peak index: " + peakIndex1 + " (value = " + nums1[peakIndex1] + ")");

        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        int peakIndex2 = solver.findPeakElement(nums2);
        System.out.println("Peak index: " + peakIndex2 + " (value = " + nums2[peakIndex2] + ")");

    }
}
