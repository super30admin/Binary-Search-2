// TC: log n, SC: 1

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(nums== null) return -1;
        if(n==1) return nums[0];
        int min= binarySearch(nums, 0, n-1);
        return min;
    }
    
    private int binarySearch(int nums[], int low, int high){
        
        if(nums[low]<nums[high]) return nums[low];
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if (nums[mid]> nums[mid+1]) 
                return nums[mid+1];
            else if (nums[mid]< nums[mid-1]) 
                return nums[mid];
            
            
            if(nums[mid]>nums[0])
                low=mid+1;
            else 
                high=mid-1;    
        }
        return -1;
    }
    
}
