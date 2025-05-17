//## Problem 3: (https://leetcode.com/problems/find-peak-element/)

// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : Thinking of i can write the edge case as a ternary operator could have not crossed my mind unless i saw my instrcutor code it out

var findPeakElement = function(nums) {
    // Time Complexity : O(Log(N))
    // Space Complexity : O(1)
    //Set two pointers for binary search
    let low = 0
    let high = nums.length -1
    while(low<=high){
        //Find Mid
        let mid = Math.floor((low+high)/2)
        //!Egde Case
        //! If mid at 0 : set its left neighbour as -infinity
        let leftNeighbor = mid == 0?-Infinity:nums[mid-1]
        //! If mid at n : set its right neighbour as -infinity
        let rightNeighbor = mid == nums.length-1?-Infinity:nums[mid+1]
        //Check if its the PEAK
        if(leftNeighbor < nums[mid] && nums[mid] > rightNeighbor){
            return mid // found peak
        }
        //If not the peak then move towards the part of array which has greater neighbor
        else if(leftNeighbor >= nums[mid]){

            high = mid-1
        }
        else{
            low = mid+1
        }
    }
    return -1
};