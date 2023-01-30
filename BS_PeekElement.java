/*
 * Time Complexity : O(log(n))
 * Space Complexity :  O(1)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 * 
 * Approach - To get the peeak element we check if the mid is lesser than both it's neighbours. If not, then we consider the side that which contains the neughbour higher than mid.
 * If mid is either the starting or the last element we consider it to be bigger than the element outside the array. We return mid when mid>mid-1 && mid>mid+1
 */

//https://leetcode.com/problems/find-peak-element/
class BS_PeekElement {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high = nums.length-1;
        int mid;
        while(low<=high){
            mid=low+(high-low)/2;
            if((mid==0||nums[mid]>nums[mid-1]) && (mid==nums.length-1||nums[mid]>nums[mid+1])){
                return mid;
            }else if(mid>0 && nums[mid]<nums[mid-1]){
                high=mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
}