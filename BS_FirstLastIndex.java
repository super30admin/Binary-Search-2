/*
 * Time Complexity : O(log(n))
 * Space Complexity :  O(1)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 * 
 * Approach - We perform two finary searches. The first binary search is to get the first occurence of the target element. To do this we we use binary sort to find the target and check if 
 * the mid>mid-1. If yes then it is the first occurence of the target. Then we run another binary search from the first occurence position till the end of the array and keep iterating until
 * mid is equal to target and mid<mid+1 or end of the array.. We return both the indices.
 */

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class BS_FirstLastIndex {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length == 0) return new int[]{-1,-1};
        if(target>=nums[0] && target<=nums[nums.length-1]){
            //To get first occurence
            int secondElement;
            int firstElement = binarySearchFirst(nums, target);
            if(firstElement==-1) return new int[]{-1,-1};
            else {
            secondElement = binarySearchSecond(nums, target, firstElement);
            }
            return new int[]{firstElement, secondElement};
        }else{
            return new int[]{-1,-1};
        }
    }

    public int binarySearchFirst(int[] nums,int target){
            int low = 0;
            int high = nums.length-1;
            int mid;
            while(low<=high){
                mid = low+(high-low)/2;
                if(nums[mid]==target && (mid==0 || nums[mid]>nums[mid-1])){
                    return mid;
                }else if(nums[mid]>=target){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
        return -1;
    }

    public int binarySearchSecond(int[] nums,int target, int firstElement){
            int low = firstElement;
            int high = nums.length-1;
            int mid;
            while(low<=high){
                mid = low+(high-low)/2;
                if(nums[mid]==target && (mid==nums.length-1 || nums[mid]<nums[mid+1])){
                    return mid;
                }else if(nums[mid]>target){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
        return -1;
    }
}