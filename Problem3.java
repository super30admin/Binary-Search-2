//To find peak element in an array
class Solution {
    public int findPeakElement(int[] nums) {
        int n= nums.length;
        int low=0;
        int high= n-1;

        while(low<=high){
            int mid=low + (high-low)/2;
            //Used binary search to check if mid is peak
            //cheked if mid is greater than its nieghbours
            //checked edge cases for 0 and last index
            if((mid==0 || nums[mid]>nums[mid-1]) 
            &&(mid==n-1 || nums[mid]>nums[mid+1]))
            return mid;
            //if mid is less then left nieghbour then move to left side
            else if(mid != 0 && nums[mid]<nums[mid-1]){
                high=mid-1;
            }
            //if not then move to right
            else{
                low=mid+1;
            }
        }
        return 43534537;
    }
}