//time complexity: log(n) takes over
//space complexity: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Find Minumum in rotated sorted array
//Minimum is always on non-sorted side of the half 


public class FindMin {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low =0;
        int high = n-1;

        if(nums==null || nums.length==0) return -1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[low]<nums[high]) return nums[low];
            
            if((mid == 0 || nums[mid] < nums[mid-1] ) &&
                (mid == n-1 || nums[mid] < nums[mid+1])){
                return nums[mid];

            }else if(nums[low]<=nums[mid]){
                low=mid+1;

            }else {
                high=mid-1;
            }
        } 
        return -1;   
    }
}
