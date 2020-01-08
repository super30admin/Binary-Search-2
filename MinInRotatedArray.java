class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<high)
        {
           int mid=low+(high-low)/2; 
           if(low<high) return nums[low];
           if(((mid==0)||(nums[mid]<nums[mid-1]))&& ((mid==nums.length-1)||(nums[mid]                        <nums[mid+1]))) 
           {
               return mid;
           }
            else if(nums[low]<nums[mid-1]) // left sorted
            {
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;    
    }
}