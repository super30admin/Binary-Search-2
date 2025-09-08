/**
 * 
 * @param {*} nums : number array
 * 
 * This function follow binary search to find peak element. As we are moving in value which is higher becuase we are always able to find the peak if we climb the mountain.
 *  
 * @returns peak index
 */
var findPeakElement = function(nums) {
    let low = 0;
    let high = nums.length - 1;

    while(low < high) {
        let mid = Math.floor(low + ((high-low)/2))

        // if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == high || nums[mid] > nums[mid + 1])) return mid;
        if (nums[mid] < nums[mid + 1]) low = mid + 1;
        else high = mid;
    }

    return low;
}