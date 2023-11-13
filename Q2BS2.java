//## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
//
//        Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//        (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
//        Find the minimum element.
//
//        You may assume no duplicate exists in the array.
//
//        Example 1:
//        Input: [3,4,5,1,2]
//        Output: 1
//
//        Example 2:
//        Input: [4,5,6,7,0,1,2]
//        Output: 0
public class Q2BS2 {
    public int findMin(int[] nums) {
        //     int hi = nums.length-1;
        //     int low = 0;

        //     while(low<hi){
        //         int mid = low +((hi-low)/2);
        //         if(nums[mid]<nums[hi])
        //         hi = mid;
        //         else
        //         low = mid +1;
        //     }
        // return nums[low];

        if(nums == null || nums.length==0) return -1;
        int low =0;
        int high = nums.length -1;
        while(low<=high){
            if(nums[low] <= nums[high]) return nums[low];

            int mid = low + (high - low)/2;
            if((mid == low || nums[mid] < nums[mid-1]) && nums[mid] < nums[mid+1])
                return nums[mid];
            else if ( nums[low]<=nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
