// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// comparing the middle element with its adjacent elements, enabling the algorithm to approach a peak
// element by choosing the direction with the increasing values.
class problem3 {
    private int BIG_NUMBER = 23344;
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0; int high = n-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(mid == n-1 || nums[mid]>nums[mid+1]) {
                return mid;
            } else if (mid>0 && nums[mid]<nums[mid-1]){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return BIG_NUMBER;
    }
}
