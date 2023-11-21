// (https://leetcode.com/problems/find-peak-element/)
// Accpeted in LeetCode
//TC O(log n)and SC is O(1) 
/*In each iteration of the while loop, 
the search space is reduced by half, leading to a time complexity of O(log n).*/

/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function(nums) {

    let left =0;
    let right = nums.length-1;
    
    while (left<= right){
        let mid = Math.floor(left + (right-left)/2);
    
    if((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == (nums.length) -1 || nums[mid+1] < nums[mid])) 
    
               {
    
                   return mid;
    
               }
    
        else if(nums[mid-1]>nums[mid])
        {
            right = mid-1;
        }
        else if(nums[mid+1]>nums[mid]){
            left = mid+1;
        }
    
    }
    return -1;
        
    };