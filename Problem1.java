//Using binary seach to find the tearget's 1st indext
//Then again doing binary search starting from 1st target index to last index of array to find 2nd index
class Solution {

    private int binarysearchFirst(int []nums,int target,int low,int high){

        while(low<=high){
        int mid=low + (high-low)/2;
        if(nums[mid]==target){
            //check if this is the first index
            if(mid==low || nums[mid]>nums[mid-1]){
                return mid;
            }
            else{
                //move left again
                high=mid-1;
            }

        }
        else if(nums[mid]>target){
            high=mid-1;
        }
        else{
            low=mid+1;
        }

        }
        return -1;
    }

     private int binarysearchLast(int []nums,int target,int low,int high){

        while(low<=high){
        int mid=low + (high-low)/2;
        if(nums[mid]==target){
            //check if this is the 2nd index index
            if(mid==nums.length-1 || nums[mid]<nums[mid+1]){
                return mid;
            }
            else{
                //move right again
                low=mid+1;
            }

        }
        else if(nums[mid]>target){
            high=mid-1;
        }
        else{
            low=mid+1;
        }

        }
        return -1;
    }


    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        //if target is not present in an array
        if(nums.length==0 || target<nums[0] || target>nums[n-1]){
            return new int[]{-1,-1};
        }
        
        int low=0;
        int high=n-1;
        //fist binary search call
        int First= binarysearchFirst(nums,target,low,high);
        if(First==-1) return new int[] {-1,-1};
        //second binary search call
        int Last= binarysearchLast(nums,target,First,high);
        return new int[] {First,Last};

    }
}