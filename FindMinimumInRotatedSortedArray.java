// Time Complexity : O(log(n)) Binary search applied for searching the element in array
// Space Complexity : O(1) no extra space used other than constants
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length -1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[low] <= nums[high]){
                return nums[low];
            }
            if((mid == low || nums[mid] < nums[mid - 1]) && (mid == high || nums[mid] < nums[mid+1])) {
                return nums[mid];
            }
            if(nums[low] <= nums[mid]){
                low = mid + 1;
            }
            else {
                high = mid -1;
            }
        }
        return 5555555;
    }
}
