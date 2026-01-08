//
//  FindMinInRotatedSortedArray.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/8/26.
//

class FindMinInRotatedSortedArray {
    
    init() {
        let minElement = findMin(nums: [9, 10, 1, 2, 3, 4, 5, 6, 7])
        print("minElement ** \(minElement)")
    }
    
    func findMin(nums: [Int]) -> Int {
        var low = 0
        var high = nums.count - 1
        while (low <= high) {
            if (nums[low] <= nums[high]) {
                //we can reach a situation where the whole range is just 1 element
                return nums[low]
            }
            let mid = low + (high - low)/2
            
            //check if the mid is smaller than neighbours then return nums[mid]
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.count - 1 && nums[mid] < nums[mid + 1])) {
                return nums[mid]
            } else if (nums[low] <= nums[mid]) {
                //check if the left side is sorted, if yes, move towards the right side.
                low = mid + 1
            } else {
                //since left side is not sorted, stay at the left side only by moving high pointer to (mid - 1)
                high = mid - 1
            }
        }
        return -1
    }
}
