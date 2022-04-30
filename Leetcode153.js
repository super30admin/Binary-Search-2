Time Complexity - O(logn)
Space Complexity - logn

/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    var left = 0,right=nums.length-1;
    while(left<=right)
    {
        var mid = Math.floor((left+right)/2);
        if(nums[mid]<nums[right])
        {
            right = mid;
        }
        else
        left = mid+1;
    }
    return nums[right];
};