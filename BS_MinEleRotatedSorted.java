/*
 * Time Complexity : O(log(n))
 * Space Complexity :  O(1)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 * 
 * Approach - As it's a rotated sorted array, at every stage either the left side or the right side of the array is sorted. On the side that is not sorted, we check if the low is lesser than the high, if yes
 * then we return low. Else we find mid and find the side that is not sorted. We keep doing this until mid is lesser than mid+1 and mid-1.
 */

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
class BS_MinEleRotatedSorted {
    public int findMin(int[] nums) {
        if(nums==null || nums.length ==0) return -1;
        int low=0;
        int high = nums.length-1;
        int mid;
        while(low<=high){
            mid=low+(high-low)/2;
            if(nums[low]<nums[high])return nums[low];
            if((mid==nums.length-1 || nums[mid]<nums[mid+1]) && (mid==0||nums[mid]<nums[mid-1])){
                return nums[mid];
            }else if(nums[mid]>=nums[low]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}