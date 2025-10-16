/*
Time Complexity: O(log(n))
Space Complexity: O(1)
 */

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int low =0;
        int high = nums.length -1;
        // Binary search
        while(low <= high){
            int mid = low + (high - low)/2;
            // If mid is the greater than both the adjacent elements return mid
            if ((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length -1 || nums[mid] > nums[mid+1])) return mid;
            // The Base condition is to always move to the higher side and reduce the search space by half
            // We cannot have: else if(nums[mid - 1] > nums[mid]) since it fails for [1,2] search with ArrayIndexOutOfBounds
            else if(nums[mid + 1] > nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
