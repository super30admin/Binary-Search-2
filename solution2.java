class Solution {
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0){
            return 21682;
        }
        int low=0;
        int high=nums.length-1;
        int mid;
        while(low<=high){
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            mid=low+(high-low)/2;
            if((mid==low || nums[mid]<nums[mid-1]) && (mid==high || nums[mid]<nums[mid+1])){
                return nums[mid];
            }
            if(nums[low]<=nums[mid]){
               
                low=mid+1;
            }
            else{
            high=mid-1;}
        }
        return 1233;

    }
}
