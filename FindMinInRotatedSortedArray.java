//Time complexity: O(n)
//Space complexity: O(1)
//Did this code successfully run on Leetcode : yes

/*
Approach:
1. In a rotated sorted array, there is only one element which is smaller than both its adjacent elements
2. First check which half of the array is sorted
3. Move to the unsorted half amd search for minumum value
*/

class Solution {
    public int findMin(int[] nums) {

        int n=nums.length;
        int low=0;
        int high=n-1;

        while(low<=high){

            int mid=low+(high-low)/2;
            //if the given array is sorted
            if(nums[low]<nums[high])
                return nums[low];

            if((mid==0||nums[mid]<nums[mid-1])&& (mid==n-1 ||nums[mid]<nums[mid+1]))
                return nums[mid];

            //if the left half is sorted, then move the search space to right half as min cannot be in the sorted half
            if(nums[low]<=nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }

        }
        return -1;
    }

}