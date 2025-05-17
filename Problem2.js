//## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NONE

var findMin = function(nums) {
    //TC : O(Log(N))
    //SC : O(1)
    let low = 0
    let high = nums.length-1
    //Initialise a variable +INfinity
    let result = +Infinity
    while(low<=high){
        let mid = Math.floor((low+high)/2)
        //if ele at low is less than high -> that means one part of the array is sorted
        if(nums[low]<= nums[mid]){
            //Make result as the existing value of the new low value
            result = Math.min(result,nums[low])
            low = mid+1
        }
        else{
            //right part is sorted so arr[mid] is the lower here 
            //Make result as the existing value of the new mid value
            result = Math.min(result,nums[mid])
            high = mid-1
        }
    }
    //return whatever the result is
    return result
};