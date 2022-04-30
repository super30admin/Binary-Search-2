Time Complexity - O(Logn)
Space complexity - Logn
/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function(nums) {
    var st= 0,end = nums.length-1;
    while(st<end)
    {
        var mid1 = Math.floor((st+end)/2);
        var mid2 = mid1+1;
        if(nums[mid1]<nums[mid2])
        {
            st = mid2;
        }
        else
            end = mid1;
    }
    return st;
};