'''
In this problem in order to find 2 indexes of the target element, I performed 2 binray search operations 

1. firstBinarySearch: To find first occurance of the element.
for first occurance I compared mid with target and moved the pointer towards left if the mid element is equal. If not I moved high pointer to right.

If the first occurance is not found then the target does not exist in the array. So we return [-1, -1] as output

2. lastBinarySearch: To find last occurance of the element
for last occurance I made first occurance as the low pointer, and compared mid with target and moved the pointer towards right if the mid element is less than the target.

'''

class Solution:
    def searchRange(self, nums, target):
        # to find first occurance of the element
        def firstBinarySearch(nums, target, low, high):
            while low <= high:
                mid = low + (high - low) // 2
                # comparing mid with target
                if nums[mid] == target:
                    # check if it is the first occurance or check mid-1 less than mid
                    if mid == 0 or nums[mid - 1] < nums[mid]:
                        # if any condition is true return mid
                        return mid
                    else:
                        # else move the high pointer to left
                        high = mid - 1
                elif nums[mid] > target:
                    # move the pointer to left
                    high = mid - 1
                else:
                    # move the pointer to right
                    low = mid + 1
            return -1
        # to find last occurance of the element
        def lastBinarySearch(nums, target, low, high):
            while low <= high:
                mid = low + (high - low) // 2
                # comparing mid with target
                if nums[mid] == target:
                    # checking if mid is the last element or mid+1 elemeent is greater than mid element
                    if mid == len(nums) - 1 or nums[mid + 1] > nums[mid]:
                        return mid
                    else:
                        # moving the pointer to right
                        low = mid + 1
                elif nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1

        first = firstBinarySearch(nums, target, 0, len(nums) - 1)
        # if the first occarnec is -1 then the target does not exist in the array so we directly return [-1, -1]
        if first == -1:
            return [-1, -1]
        # here we take the low pointer from the first occurance of the target
        last = lastBinarySearch(nums, target, first, len(nums) - 1)
        # array of frst occurance and last occurance
        return [first, last]

'''
Time Complexity : O(log n)
Since the time complexity of performing binray serach is O(log n), for both binray searches: O(log n) + O(log n) = 2 O(log n) => O(log n)

Space Complexity: O(1)
We did not use any extra space.

'''