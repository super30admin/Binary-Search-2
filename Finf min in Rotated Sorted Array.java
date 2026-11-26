// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//I will check for a sorted half in the array , minimum exists in unsorted half .Since in unsorted half Higher elemnts exists and very next them it share with minimum elemts int the array.
// Once i reach to a postion where low,high are at same pos i will check nums[mid]< nums[mid-1],I will return nums[mid].
// Before this loop starts i will check if nums is sorted if yes i return nums[low].
class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            int mid=low+(high-low)/2;
            if(mid-1>=0 && nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            else if(nums[high] > nums[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return 777;
    }
}
