// Problem Name: Find the Minimum Element in a Rotated Array(sorted)

// Source Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/


//Time Complexity: O(Logn)
//Space Complexity: O(1)
//Approach:
//  1. Find the Sorted part i.e nums[left] < nums[right] the left part is already sorted
//  2. Consider the Resulst as the nums[0], this is the minimum and
// Traverse the sorted part to find the minimum
    public int findMin(int[] nums) {
        int result=nums[0];
        int left=0;
        int m;
        int right=nums.length-1;
        while(left<=right){
            if(nums[left]<nums[right]){
                result=Math.min(result, nums[left]);
                break;
            }
        m=left+(right-left)/2;
        result=Math.min(result, nums[m]);
        if(nums[m]>=nums[left]){
            left=m+1;
        }
        else{
            right=m-1;
        }
        }
        return result;
    }
