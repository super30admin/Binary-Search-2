# Exercise_2: Find Minimum in Rotated Sorted Array
# Time Complexity: O(log(N)), where N is the length of the array
# Space Complexity: O(1)
# Successful Run on Leetcode: Yes (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
# Challenges: None

# Coding Approach:
# Initialize start and end pointers
# While start is less than end, find the mid element
# If the mid element is greater than the end element, search the right half of the array
# Else, search the left half of the array
# Return the element at the start (This is the minimum element in the array)

def findMin(nums):
    start, end = 0, len(nums) - 1
    while start < end:
        mid = (start + end) // 2
        if nums[mid] > nums[end]:
            start = mid + 1
        else:
            end = mid
    return nums[start]

print(findMin([3,4,5,1,2]))
print(findMin([4,5,6,7,0,1,2]))
print(findMin([11,13,15,17]))