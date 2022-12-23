# Exercise_1: Find First and Last Position of Element in Sorted Array
# Time Complexity: O(log(N)), where N is the length of the array
# Space Complexity: O(1)
# Successful Run on Leetcode: Yes (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
# Challenges: None

# Coding Approach:
# Initialize the result to [-1, -1] incase the target is not found in the array
# Call binarySearch() to find the first occurrence of the target. If the target is found, call binarySearch() again to find the last occurrence of the target
# findMaxIndex is used to determine if the target is found and if the search should be continued in the right half of the array or the left half of the array
# Initialize the keyIndex to -1 incase the target is not found in the array
# If the target is less than the mid element, search the left half of the array
# If the target is greater than the mid element, search the right half of the array
# If the target is equal to the mid element, update the keyIndex to mid. If findMaxIndex is True, search the right half of the array. Else, search the left half of the array


def searchRange(nums, target):
    result = [-1, -1]
    result[0] = binarySearch(nums, target, False)
    if result[0] != -1:
        result[1] = binarySearch(nums, target, True)
    return result
    
def binarySearch(nums, target, findMaxIndex):
    keyIndex = -1
    start, end = 0, len(nums) - 1
    while start <= end:
        mid = (start + end) // 2
        if nums[mid] > target:
            end = mid - 1
        elif nums[mid] < target:
            start = mid + 1
        else:
            keyIndex = mid
            if findMaxIndex:
                start = mid + 1
            else:
                end = mid - 1
    return keyIndex

print(searchRange([5,7,7,8,8,10], 8))
print(searchRange([5,7,7,8,8,10], 6))
print(searchRange([], 0))
        