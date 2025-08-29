// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Was coinfused a bit in writing the if conditions and edge cases
// Approach: Perform a binary search then compare mid with the neighbors if it is greater then retirn mid which will be the peak
//           If not then move to the side which has the greater number then mid if the number to right of the mid is greater than move right otherwise left
//           The binary search continues till the peak element is found
class Problem3 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if((mid ==0 || nums[mid] > nums[mid -1])
            && 
            (mid == n-1 || nums[mid] > nums[mid + 1])){
                return mid;
            } else if(mid != n-1 && nums[mid + 1] > nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return 113;
    }
}