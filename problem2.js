// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 



//Find Minimum in Rotated Sorted Array
const findMin = function(nums) {
    let low = 0, high = nums.length - 1
    while(low <= high){
       if(nums[low] < nums[high]) return nums[low]
       let mid = low + Math.floor((high - low)/2)
       //compare the mid to get min by index-1 and +1
       if((mid == low || nums[mid] < nums[mid - 1]) && (mid == high || nums[mid] < nums[mid+1] )){
           return nums[mid]
           //if left sorted min lies in unsorted 
       }else if(nums[low] <= nums[mid]){
           low = mid + 1
       }else{
           high = mid -1
       }
    }
};

let nums = [3,4,5,1,2]
const result = findMin(nums);

console.log(`${result}`);