// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
// divided array segment at mid, compare with adj elements, if satisfied return mid
//else moved towards bigger side, since it is garenteed that peek exists in that half part 

class Solution {
    public int findPeakElement(int[] nums) {
        int i=0,j=nums.length-1;
        while(i<j){
            int mid= i+(j-i)/2;
            if((mid==0||nums[mid]>nums[mid-1]) &&(mid==nums.length-1||nums[mid]>nums[mid+1])){
                return mid;
            }
            if(mid!=0 && nums[mid]<nums[mid-1]){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return i;

    }
}