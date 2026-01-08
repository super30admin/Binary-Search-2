/**
 * @param {number[]} nums
 * @return {number}
 * 
 * 
 * Intuition:
 * 
 * This solution uses binary search to find the minimum element in a rotated sorted array.
 * If the array is not rotated (or rotated back to its original position), the first element will be smaller than or equal to the last, so we can immediately return it.
 * Otherwise, we perform binary search to locate the rotation point, which is where the minimum element lies.
 * At each step, we calculate the middle pointer and check if it is smaller than its previous element;
 * if so, that element is the minimum. If not, we determine which half of the array is not sorted by comparing the middle element with the rightmost element.
 *  If the right side is unsorted, the minimum must reside in there, so we move the left pointer forward; 
 * otherwise, we search the left half by moving the right pointer backward. 
 * This approach efficiently narrows the search space and guarantees a time complexity of O(log n).
 */
var findMin = function(nums) {
    let left = 0, right = nums.length - 1;
    // edge case where the element is not roatated or the element rotated to its original place
    if(nums[left] <= nums[right]) return nums[left];
    while(left <= right){
        const mid = Math.floor((left+ (right-left)/2));
        //  condition to return mid
        if(nums[mid] < nums[mid-1]){
            return nums[mid];
        }else if(nums[right] < nums[mid]){
            left = mid + 1;
        }else {
            right = mid - 1;
        }
    }
    return left;
};