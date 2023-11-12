// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 

//Find Peak Element

const findPeakElement = function(nums) {
    let low = 0,high = nums.length-1
    while(low <= high){
        let mid = low + Math.floor((high-low)/2)
        //check mid is greater than its -1 and +1 indexes
        if((mid == low || nums[mid] > nums[mid - 1]) && (mid == high || nums[mid] > nums[mid + 1])){
            return mid
        }
        //check and slope and shift the pointer
        else if(nums[mid] < nums[mid + 1]){
            low = mid + 1
        }else{
            high = mid - 1
        }
    }
    return -1
    
};

let nums = [1,2,1,3,5,6,4]
const result = findPeakElement(nums);

console.log(`${result}`);