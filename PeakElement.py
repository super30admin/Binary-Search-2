# Exercise_3: Find Peak Element
# Time Complexity: O(log(N)), where N is the length of the array
# Space Complexity: O(1)
# Successful Run on Leetcode: Yes (https://leetcode.com/problems/find-peak-element/)
# Challenges: None

# Coding Approach:
# Initialize start and end pointers
# While start is less than end, find the mid element
# If the mid element is greater than the element at mid + 1, search the left half of the array
# Else, search the right half of the array
# Return start (This is the index of the peak element in the array)

def findPeakElement(arr):
    start, end = 0, len(arr) - 1
    while start < end:
        mid = (start + end) // 2
        if arr[mid] > arr[mid + 1]:
            end = mid
        else:
            start = mid + 1
    return start

print(findPeakElement([1,2,3,1]))
print(findPeakElement([1,2,1,3,5,6,4]))
print(findPeakElement([1,2,3,4,5,6,7]))
