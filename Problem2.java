// Time Complexity :O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : edge cases


// Your code here along with comments explaining your approach

class Problem2 {
    /** find minimum */
    public int findMin(int[] nums) {

        int low = 0;
        int high =  nums.length-1;
        
        while(low<=high){
            
            // mid
            int mid = low + (high-low)/2;

            // if array is sorted return 1st element
            if(nums[low]< nums[high])
                return nums[low];
            // using the pivot property
            if((mid==low || nums[mid]<nums[mid-1]) && (mid==high || nums[mid]<nums[mid+1])){
                    return nums[mid];
            // one element
            }else if(nums[low] <=nums[mid]){
                low = mid +1;
            }else{
                high = mid -1;
            }
        }
        
        return -1;
    }
}