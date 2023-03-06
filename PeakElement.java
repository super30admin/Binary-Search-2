// Time Complexity : O(log(N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

public class PeakElement {

    public int findPeakElement(int[] nums) {
        int low=0, high=nums.length-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if((mid ==0 || nums[mid]>nums[mid-1])
                    && (mid == high || nums[mid] > nums[mid+1])) {
                return mid;
            } else if(mid<=high && (nums[mid] < nums[mid+1])) {
                low = mid+1;
            } else {
                high = mid -1;
            }
        }
        return -1;
    }
}
