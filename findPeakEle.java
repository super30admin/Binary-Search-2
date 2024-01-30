public class findPeakEle {
    /** Time Complexity : O(log n)
     Space Complexity : O(1)
     Did this code successfully run on Leetcode : Yes
     Any problem you faced while coding this : No


     Your code here along with comments explaining your approach in three sentences only **/
    public int findPeakElement(int[] nums) {
        int left =0;
        int right = nums.length-1;
        while (left<=right){
            //If the array is null
            if (nums==null){
                return -1;
            }
            //Mid value formula
            int mid = left+(right-left)/2;
            //If the array has only one element, then the mid-value will be the element itself and it will be the peak element as any element out of array index is considered minus infinity
            if (nums.length==0){
                return mid;
            }
            //If the peak value is at either first or last position of array, return that value
            if ((mid==0 || nums[mid]>nums[mid-1])&&(mid==nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            //If the mid-value is not at 0th index, and the left side is greater, then reject looking at the right side
            else if (mid!=0 && nums[mid-1]>nums[mid]) {
                right = mid - 1;
            }
            //If the mid-value is not at 0th index, and the right side is greater, then reject looking at the left side
            else {
                left = mid + 1;
            }
        }
        return -1;

    }
}
