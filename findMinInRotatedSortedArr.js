/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    let low = 0;
    let high = nums.length-1;

    while(low<=high) {
        if(nums[low] <= nums[high]) {
            return nums[low]
        }

        // now find the mid
        mid = Math.floor((low+high)/2);

        // todo handle first and last elements
        //1st check if first element is mid or 2nd element is smaller than first element
        //2nd check if its last element or second last element 
        if((mid===0 ||nums[mid]<nums[mid-1] ) && (mid==nums.length-1 ||  nums[mid] < nums[mid+1])) {
            return nums[mid];
        }

        // check if left sorted or right sorted array
        else if(nums[low] <= nums[mid]) {
            low=mid+1;
        } else {
            high=mid-1;
        }
    }
    return -1;
}