//
//  FindPeakElementInRotatedSortedArray.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/8/26.
//

class FindPeakElementInRotatedSortedArray {
    
    
    init() {
        let peakElement = findAPeakElement(nums: [9, 10, 1, 2, 3, 4, 5, 6, 7])
        print("peak element's index \(peakElement)")
    }
    
    //Find a peak element in rotated sorted array
    func findAPeakElement(nums: [Int]) -> Int {
        /*
         A peak element is an element which is greatee than neighbours.
         [1,2,13,5,6,4] - peak elements - 2, 6
         
         If it's asked to find out all the peaks then perform linear search and print all peaks.
         */
        let n = nums.count
        var low = 0
        var high = n - 1
        while (low <= high) {
            let mid = low + (high - low)/2
            //check if nums[mid] is greater than nums[mid + 1] and nums[mid] greater than nums[mid - 1]
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1])) {
                //we are standing at the peak. return the index of the peak.
                return mid
            } else if (mid != 0 && nums[mid - 1] > nums[mid]) {
                //move towards the left. Reject right half
                high = mid - 1
            } else {
                //move towards right. Reject left half
                low = mid + 1
            }
        }
        return -1
    }
}
