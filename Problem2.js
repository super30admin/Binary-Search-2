// (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
// Accpeted in LeetCode
//TC O(log n)and SC O(1)
 
/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {

    let left =0;
    let right = nums.length-1;

    while(left<= right){

        let mid = Math.floor(left+(right-left/2))

        if((mid == 0 || nums[mid]<nums[mid-1])&& nums[mid]<nums[mid+1]) return nums[mid]

        else if(nums[mid+1]<nums[mid]){
            left = mid+1;
        }
         else{
             right=mid-1;
         }

    }
    return nums[left];
};