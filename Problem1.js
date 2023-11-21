// (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
// Accpeted in LeetCode
//TC  O(log n) and SC O(1)

var searchRange = function(nums, target) {

    let left =0;
    let right = nums.length-1;
    
    let output =[-1,-1];
    
    if(nums == null || nums.length == 0) 
     return output;
    
    if(target< nums[0] || target > nums[nums.length-1]) return output;
    
    while (left<= right){
        mid = Math.floor(left+(right-left)/2)
    
        if(nums[mid] == target ){
            if(mid == left || nums[mid-1]<nums[mid]) {
                output[0]=mid;
                break;
            }
    
            else right = mid-1;
        }
        else if(nums[mid]>target){
            right = mid-1;
        }
        else left = mid+1
    }
    
    let high = nums.length-1;
    while (left<= high){
        mid = Math.floor(left+(high-left)/2)
    
        if(nums[mid] == target ){
            if(mid == high || nums[mid+1]>target) {
    
              output[1]=mid;
              break;
            }
    
            else left = mid+1;
        }
        else if(nums[mid]>target){
            high = mid-1;
        }
        else left = mid+1
    }
    
    return output;
    
        
    };

// const nums = [5, 7, 7, 8, 8, 10];
// const target = 8;
// const result = searchRange(nums, target);
// console.log(result); // Output: [3, 4]