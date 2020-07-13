// Time Complexity :O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : edge cases


// Your code here along with comments explaining your approach
class Problem3 {
    public int findPeakElement(int[] nums) {
        
        int low = 0;
        int high =  nums.length-1;
        
        while(low<high){

            // find mid
            int mid =  low + (high -low)/2;

            // finding pivot
            if(nums[mid] > nums[mid+1])
                high =  mid;
            else
                low = mid+1;
        }
        
        return low;
    }

}