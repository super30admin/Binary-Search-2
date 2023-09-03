// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/1038945968/
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only

/*
1. In rotated sorted array, there is a sorted part and an unsorted part, the min lies in unsorted part at any point of time, except incase of entirely sorted array
2. Min is the element which is less than the left and the right element so check whether mid is min, whenever mid changes
3. If low is less than the mid then it is considered as the sorted part of the array
*/

 
class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low =0 ;
        int high = nums.length -1;
        while(low <= high){
            if(nums[low]<nums[high])
                return nums[low];
            int mid = low + (high-low)/2; // to prevent Integer overflow
            if((mid==0 || nums[mid]<nums[mid-1]) && (mid==high || nums[mid]<nums[mid+1]))
                return nums[mid];
            if(nums[low] <= nums[mid])
                low=mid+1;
            else
                high = mid-1;
        }
        return 0;
    }
} 

