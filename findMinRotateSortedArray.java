public class findMinRotateSortedArray {
    /** Time Complexity : O(log n)
     Space Complexity : O(1)
     Did this code successfully run on Leetcode : Yes
     Any problem you faced while coding this : No


     Your code here along with comments explaining your approach in three sentences only **/
    public int findMin(int[] nums) {
        //When the array is empty or has only 1 element in it
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //Initializing left and right sides
        int left = 0;
        int n = nums.length;
        int right = n - 1;

        while (left <= right) {
        //When the minimum value is on the left side
            if (nums[left] <= nums[right] ) {
                return nums[left];
            }
        //When the minimum value is the mid-value, we check if it's less than right and left side
            int mid = left + (right - left) / 2;

            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == n - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }
        //Min value lies in the unsorted part of the rotated array, so check which side is sorted
        //left sort
            else if (nums[left] <= nums[mid]) {
                left = mid + 1;
            }
        //right sort
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
