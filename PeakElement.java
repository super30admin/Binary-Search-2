// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * NOTE: the border elements can be the most probable ans => so check for both
 * first => and exit if found
 * 
 * NOTE: adjacent elements are not duplicates
 * 
 * Apply Binary Search => check if mid is peak => if yes, return and exit
 * 
 * Else, mid is not the peak => peak can be on either left or right half to the
 * mid
 * 
 * if the mid element > the previous element => we know mid is not > next
 * element => probably next could be the peak (as mid is not the peak) => so
 * search on the right half
 * else if the mid element < the previous element => we know next element is not
 * > mid => probably previous could be the peak (as mid is not the peak) => so
 * search on the left half
 */
public class PeakElement {
    public PeakElement() {

    }

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }
        int lo = 1;
        int hi = n - 2;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] > nums[mid - 1]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}