// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
// to find the minimum element (start), used binary search approach 
//divide array at middle and eleminated the sorted part, kept only unsorted one
//since minimaum element exist in unsorted part


class Solution {
    public int findMin(int[] nums) {
        if(nums[0]<nums[nums.length-1])return nums[0];
        int i=0,j=nums.length-1;
        while(i<j){
            int mid=i+(j-i)/2;
            //System.out.println(i+" "+j);
            if(nums[mid]<nums[j]){
                j=mid;
            }else{
                i=mid+1;
            }
        }
        return nums[i];
    }
}