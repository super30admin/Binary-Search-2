// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// I will find the fisrt elemnet and last element in two different calls , for each cal i pergorm binary search until i find target value.
// For first element after finding target i will check does nums[mid-1] < nums[mid] such that it is first occurance , like wise for last occurance nums[mid+1] > nums[mid].
// If i dint find target i return -1,-1 for both sincee there is no target exists in nums.
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int first=binarySearch1(low,high,nums,target);
        if(first==-1)return new int[]{-1,-1};
        int second=binarySearch2(low,high,nums,target);
        return new int[]{first,second};

    }
    public int binarySearch1(int low,int high,int[] nums,int target){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid-1< 0 || nums[mid]>nums[mid-1]){
                    return mid;
                }
                else{
                    high=mid-1;
                }
            }
            else if(target<=nums[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
        
    }
    public int binarySearch2(int low,int high,int[] nums,int target){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid+1>nums.length-1 || nums[mid+1]>nums[mid]){
                    return mid;
                }
                else{
                    low=mid+1;
                }
            }
            else if(target<=nums[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }

}
