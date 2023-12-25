//Executed on leetcode
// THe idea is to apply binary search first to find left index than apply binary search to find right index

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int  l = Leftbs(nums,0,nums.length-1,target);
        int h = Rightbs(nums,0,nums.length-1,target);

        int[] arr = {l,h};
        return arr;

        
    }

    public int Leftbs(int[] nums,int l,int h , int target){
        while(l<=h){
            int mid = l + (h-l)/2;
            if(nums[mid]==target){
                if((mid==0) || ((nums[mid]>nums[mid-1]))){
                    return mid;
                }
                else{
                    h = mid-1;
                }
            }
            else if(nums[mid]>target){
                h = mid-1;

            }
            else{
                l = mid + 1;
            }
        }
        return -1;
    }

        public int Rightbs(int[] nums,int l,int h , int target){
        while(l<=h){
            int mid = l + (h-l)/2;
            if(nums[mid]==target){
                if((mid==h) || ((nums[mid]<nums[mid+1]))){
                    return mid;
                }
                else{
                    l = mid+1;
                }
            }
            else if(nums[mid]<target){
                l = mid+1;

            }
            else{
                h = mid-1;
            }
        }
        return -1;
    }
}