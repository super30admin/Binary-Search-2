//Time complexity: O(logn)
//Space complexity: O(1)
//Did this code successfully run on Leetcode : Yes

/*Approach:
1. Use binary search to find the mid element and check if it is the peak
2. if not then move towards the half for which the element adjacent to mid is of higher value
3. Repeat steps 1 and 2 until peak is found.
*/

class Solution {
    public int findPeakElement(int[] nums) {

        int n=nums.length;
        int low=0;
        int high=n-1;

        while(low<=high){

            int mid=low+(high-low)/2;

            //if mid element is peak then return mid index
            if((mid==0||nums[mid]>nums[mid-1])&&(mid==n-1||nums[mid]>nums[mid+1]))
                return mid;

                //if element right to mid is greater then move search space to the right half
            else if(nums[mid]<nums[mid+1]){
                low=mid+1;
            }
            //else move search space to left half
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}