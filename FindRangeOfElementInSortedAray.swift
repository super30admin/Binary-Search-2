//
//  FindRangeOfElementInSortedAray.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/8/26.
//

/*
 
 [4, 5, 7, 8, 0, 1, 2]
 To check if the array is sorted - nums[low] <= nums[high]. Minimum will be at the low. So return nums[low]
 If it's not, start with finding of mid. mid = high - (low = high)/2
 if (nums[mid] < neighbours) -> then we are satanding at the minimum.
 If it's not smaller then the neighbours then check for the unsorted side. Go towards which side is not sorted.
 Target will lie towards the non-sorted side without exception
 In rotated sorted array - think, which side is sorted and which side is not, will solve all pripblems.
 if (nums[low] <= nums[mid]) {
 //left side is sorted so move towards the right side. Reject the sorted side in this problem
 low = mid + 1}
 //Now, check if the whole rang is sorted by using nums[low] <= nums[high]. Found hte minimum. return minimum
 
 //If left side is sorted then reject the left side and move towards the right side.
else {
 high = mid - 1
 */

class FindRangeOfElementInSortedAray {
    
    //find first and last position ofan  element in a sorted array
//    [1, 2, 3, 4, 6, 8, 8, 8, 8, 8, 8, 9, 10]
    private func binarySearchfirst(nums: [Int], target: Int, low: Int, high: Int) -> Int {
        var high = high
        var low = low
        while (low <= high) {
            let mid = low + (high - low) / 2
            if (target == nums[mid]) {
                //check if this is the first index of array
                //or check if the mid is the first index of array
                if (mid == low || nums[mid] > nums[mid - 1]) {
                    //since the previous no is lesser than the mid. It's not equal to mid, so mid is the first index.
                    return mid
                } else {
                    //mid is not the first index of the target. keep moving left until u keep on finding the target
                    high = mid - 1
                }
            } else if (target < nums[mid]) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return -1
    }
    
    private func binarySearchLast(nums: [Int], target: Int, low: Int, high: Int) -> Int {
        var high = high
        var low = low
        while (low <= high) {
            let mid = low + (high - low) / 2
            if (nums[mid] == target) {
                //check if this is the last index
                //or check if the next element is greater than the mid element
                if (mid == high || nums[mid+1] > nums[mid]) {
                    return mid //this is the last index of the target
                } else {
                    //keep moving right. Stop until we find the last index of the element
                    low = mid + 1
                }
            }
        }
        return -1
    }
    
    func searchRange(nums: [Int], target: Int) -> (Int, Int) {
        
        let lowIndex = -1
        let highIndex = -1
        if (nums.count == 0 || target < nums[0] || target > nums[nums.count - 1]) {
            return (-1, -1)
        }
        let low = 0
        let high = nums.count - 1
        let first = binarySearchfirst(nums: nums, target: target, low: low, high: high)
        if (first == -1) {
            return (-1, -1)
        }
        
        let last = binarySearchLast(nums: nums, target: target, low: first, high: high)

        return (first, last)
    }
    
    init() {
        //Find first and last position of an element in rotated sorted array
        //[1, 2, 3, 4, 6, 8, 8, 8, 8, 8, 8, 9, 10] //8
        let range = searchRange(nums: [5, 7, 7, 8, 8, 10], target: 6)
        print("range of 8 is \(range)")
    }
}
