/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 * 
 * Intuition:
 *   I am using binary search to achieve the run time complexity O(log n)
 *   Created two helper functions to find the first and last location of the target
 *   To optimize the second search i am passing the first found location as left. 
 *   If the first helper cannot find location then there is no last location so returning [-1, -1]
 *   Else if we find both returning the start and end indices. 
 * 
 */

var searchRange = function (nums, target) {
    let left = 0, right = nums.length - 1;
    // Method to get the first occurence of the target
    const firstLocBinarySearch = (low, high) => {
        let firstFound = -1;
        while (low <= high) {
            const mid = Math.floor(low + (high - low) / 2);
            if (nums[mid] === target) {
                if (firstFound === -1) firstFound = mid;
                // if mid == 0, there is no mid-1 and that is the first entry of the target
                if (mid === 0 || nums[mid] !== nums[mid - 1]) return [firstFound, mid];
                else high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return [-1, -1];
    }

    // Method to get the last occurence of the target
    const lastLocBinarySearch = (low, high) => {
        while (low <= high) {
            const mid = Math.floor(low + (high - low) / 2);
            if (nums[mid] === target) {
                // if mid == nums.length-1, there is no mid+1 and that is the last entry of the target
                if (mid === nums.length - 1 || nums[mid] !== nums[mid + 1]) return mid;
                else low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return -1;
    }
    //  get the firstfound location and the startIndex
    let [firstFound, startIndex] = firstLocBinarySearch(left, right);
    // if firstFound is -1 then the element is not found, can ignore the remaining code and return [-1,-1]
    if (firstFound === -1) return [-1, -1];
    let endIndex = lastLocBinarySearch(startIndex, right);
    return [startIndex, endIndex];
};