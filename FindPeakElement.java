
/**
 * First check for both the ends of the array for a possible peak.
 * Then we use binary search to find the peak element.
 * We eliminate half of the array by comaring mid to its neighbors and/or moving towards where the potential peak is.
 */

//Time complexity - O(log n)
//Space complexity - O(1)

// Problem Link - https://leetcode.com/problems/find-peak-element/description/
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return 0;
        }

        if(nums[0] > nums[1]) {
            return 0;
        }

        if(nums[n-1] > nums[n-2]) {
            return n-1;
        }

        int low = 1;
        int high = n-1;

        while(low <= high) {
            int mid = low + (high-low) / 2;

            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }
            else if(nums[mid] < nums[mid-1]) {
                high = mid-1;
            }
            else if(nums[mid] < nums[mid+1]) {
                low = mid+1;
            }
        }
        return -1;
    }
}
