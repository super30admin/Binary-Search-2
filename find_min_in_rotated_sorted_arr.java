//TC: O(log n)
class Solution {
    public int findMin(int[] nums) {
        
        //null check
        if(nums == null || nums.length == 0) return 0;
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            if(nums[low] < nums[high]) return nums[low];
            int mid = low + (high-low)/2;
            
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length-1 || nums[mid] < nums[mid+1])){ //to check if mid element is the minimum element
                return nums[mid];
            }else if(nums[low] <= nums[mid] ){
                 low = mid+1;
            }else{
                high = mid-1;
            }
            
        }
        return -1;
        
    }
}
