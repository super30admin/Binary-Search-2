Time complexity - O(logn)
Space complexity - logn.

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    if(nums.length=== 0 || nums.length < 2)
       return [nums.indexOf(target)!==-1 ? nums.indexOf(target) : -1,nums.indexOf(target)!==-1 ? nums.indexOf(target) : -1];
    var firstindex = first(nums,target);
    var lastindex  = last(nums,target);
    while (nums[firstindex - 1] === target) firstindex--;
    while (nums[lastindex + 1] === target) lastindex++;
    return [firstindex, lastindex];
 }
var first = function(nums,target) {
    var left = 0, right = nums.length;
    var idx=-1;
    while(left<=right)
    {
      var mid = Math.floor((right+left)/2);
      
      if(nums[mid]>=target)
      {
          right = mid-1;
      }
      else 
      {
          left = mid+1;
      }
      if(nums[mid]===target)
      { return idx=mid;}
    }
    return idx;
    
};
var last = function(nums,target) {
    var left = 0, right = nums.length-1;
    var idx=-1;
    while(left<=right)
    {
      var mid = Math.floor((right+left)/2);
     
      if(nums[mid]<=target)
      {
          left = mid+1;
      }
      else 
      {
          right = mid-1;
      }
      if(nums[mid]===target)
      { return idx=mid;}
    }
    return idx;
    
};