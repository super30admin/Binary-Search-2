// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 

//Find First and Last Position of Element in Sorted Array

const searchRange = function(nums, target) {
    if(nums.length == 0 || nums == null){
        return [-1,-1]
    }
    if(nums[0] > target) return [-1,-1]
    if(nums[nums.length - 1] < target) return [-1,-1]
    //check for first occurence
    let first = binarySearchFirst(nums, target);
    //pass first occurance as low 
    let second = binarySearchSecond(nums,target,first)

    return [first,second]
};

function binarySearchFirst(nums, target){
    let low = 0,high = nums.length - 1
    while(low <= high){
        let mid = low + Math.floor((high - low)/2)
        if(nums[mid] == target){
            //since first occurance compare the mid with low and before index element
        if( mid == low || nums[mid] > nums[mid - 1]){
            return mid
        }else{
            high = mid - 1
        }
        }else if(nums[mid] < target){
            low = mid + 1
        }else{
            high = mid - 1
        }
    }
    return -1
}


function binarySearchSecond(nums, target,first){
    let low = first,high = nums.length - 1
    while(low <= high){
        let mid = low + Math.floor((high - low)/2)
        if(nums[mid] == target){
         if(mid == high || nums[mid] < nums[mid + 1]){
            return mid
        }else{
            low = mid + 1
        }
        }else if(nums[mid] < target){
            low = mid + 1
        }else{
            high = mid - 1
        }
    }
    return -1
}

let nums = [5,7,7,8,8,10]
let target = 8 
const result = searchRange(nums,target);

console.log(`Index of ${target}: ${result}`);