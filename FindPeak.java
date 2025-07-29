// Time Complexity : O(log n), n - length of array (since binary search)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Did not handle the edge case initially
// Approach:
// 1. Do binary search
// 2. In each iteration, pick the side which increases since there is a guaranteed peak in that side

public class FindPeak {
    public static int findPeakElement(int[] nums) {
        int l=0, h=nums.length-1;

        while(l <= h) {
            int mid = l + (h-l)/2;
            if((mid - 1 < 0 || nums[mid] > nums[mid-1])
                && (mid + 1 >= nums.length || nums[mid] > nums[mid+1])) {
                return mid;
            }
            // go left if left neighbor is larger than mid
            else if(mid - 1 >= 0 && nums[mid] < nums[mid-1]) {
                h = mid-1;
            }
            // go right if right neighbor is larger than mid
            else {
                l = mid+1;
            }
        }
        // does not matter what is returned here as there is a guaranteed peek in the array
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,3,-1,-2,5,3})); //2
        System.out.println(findPeakElement(new int[]{1,2})); //1
        System.out.println(findPeakElement(new int[]{2,1})); //0
    }
}
