// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
In this problem, I checked if the previous element is greater than the curr element represented by mid
To decide between left and right, I ignored the sorted part
In case, everything is sorted it means the ans is on low pointer.
 */

public class Problem2 {
    public int findMin(int[] nums) {
        if(nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            if(nums[low] <= nums[high]) {
                return nums[low];
            }
            int mid = low + (high - low)/2;
            if(mid > 0 && nums[mid-1] > nums[mid]) {
                return nums[mid];
            } else if(nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Problem2 oProblem2 = new Problem2();
        int[] nums = { 3,4,5,1,2};
        System.out.println(oProblem2.findMin(nums));
    }
}
