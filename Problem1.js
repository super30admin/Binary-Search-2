//## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NONE, Conceptual overview in class was very easy and made to code the sol out trivially !

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    //TC = O(Log(N))
    //SC = O(1)
    function searchLeft(nums, target){
        let left = 0
        let right = nums.length-1
        //this holds the potential left index
        let res = -1
        while(left<=right){
            let mid = Math.floor((left+right)/2)
            if(nums[mid]=== target){
                res = mid
            }
            //Keep going left if we can find the element
            if(nums[mid]>=target){
                right = mid-1
            }
            else{
                left = mid +1
            }
        }
        return res
    }
    
    function searchRight(nums, target){
        //TC = O(Log(N))
        //SC = O(1)
        let left = 0
        let right = nums.length-1
        //this holds the potential right index
        let res = -1
        while(left<=right){
            let mid = Math.floor((left+right)/2)
            if(nums[mid]=== target){
                res = mid
            }
            //Keep going right till we can find the element
            if(nums[mid]<=target){
                left = mid+1
            }
            else{
                right = mid-1
            }
        }
        return res

    }

    return [searchLeft(nums, target),searchRight(nums, target)]
};