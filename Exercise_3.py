# Time Complexity - I am doing Binary Search so O(log n)
# Space Complexity - we are using two pointers so except input it O(1)
# Approach - Here the main thing is the array is not sorted it's fine if array is not sorted we have to find an element.
# This element has to be greater than the left and right element so for a mid if nums[mid] > nums[mid+1]
# this means that we are reach at the top after that there is decrement so the peak might be where the mid
# is or towards the left of mid so r = mid, if this case is not true means nums[mid] < nums[mid+1] means we are still
# climbing the mountain and there might be a peak towards right, notice here we are doing r = mid not mid - 1 so when
# we go beyond l == r we might have crossed the peak so l.
#
# This code ran successfully on Leetcode

def findPeakElement(nums):
    l,r = 0, len(nums)-1
    while l < r:
        mid = l + ((r-l)//2)
        if nums[mid] > nums[mid+1]:
            r = mid
        else:
            l = mid + 1
    return l

nums = [1,2,3,1]
print(findPeakElement(nums))
nums = [1,2,1,3,5,6,4]
print(findPeakElement(nums))