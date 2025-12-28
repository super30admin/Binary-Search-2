//To find minimum in rotated sorted array
class Solution {
    public int findMin(int[] nums) {
        int n= nums.length;
        int low=0;
        int high=n-1;

        while(low<=high){
            if(nums[low]<=nums[high]){  //to check if array is sorted already
                return nums[low];
            }
            int mid= low + (high-low)/2;
            if((mid==0 || nums[mid]<nums[mid-1]) && //If mid is smaller than its nieghtbours
             (mid==n-1 || nums[mid]<nums[mid+1] )){//also included edge cases for 0 and n-1 
                return nums[mid];//mid is smallest if nieghburs are greater
             }
             else if(nums[low]<=nums[mid]){
                //if above conditions fails then do a binary search on non sorted side
                low=mid+1;
             }
             else{
                high=mid-1;
             }
        }
        return 2738384;
    }
}