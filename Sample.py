## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

# Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

# Your algorithm's runtime complexity must be in the order of O(log n).

# If the target is not found in the array, return [-1, -1].

# Example 1:

# Input: nums = [5,7,7,8,8,10], target = 8
# Output: [3,4]
# Example 2:

# Input: nums = [5,7,7,8,8,10], target = 6
# Output: [-1,-1]

# Approach
# We use binary search to find the element in the array. 
# Once the index is found, we iterate using while loop till 
# the values remain the same to find the strating and ending index.
# Time complexity: O(nlogn)
# Space complexity: O(1)

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        l = len(nums)
        ans = []
        s = 0
        e = l-1
        m = s + (s+e)//2
        found = False

        while (s <= e):
            m = s + (s+e)//2
            if (nums[m] == target):
                found = True
                break
            elif (nums[m] < target):
                s = m + 1
            else:
                e = m - 1

        if found:
            s = m
            while (s >= 0 and nums[s] == target):
                s -= 1

            ans.append(s+1)
            s = m
            while (s < l and nums[s] == target):
                s += 1

            ans.append(s-1)
        else:
            ans = [-1, -1]

        return ans

## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

# Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

# (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

# Find the minimum element.

# You may assume no duplicate exists in the array.

# Example 1:
# Input: [3,4,5,1,2]
# Output: 1

# Example 2:
# Input: [4,5,6,7,0,1,2]
# Output: 0

# Approach
# We use the binary search pattern. We compare the mid element with the starting element 
# of the array to check if the left side is sorted or right side is sorted and update
# the left and right pointers accordingly.
# Time complexity: O(nlogn)
# Space complexity: O(1)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums) - 1
        
        if (n == 0):
            return nums[0]
        elif nums[0] <= nums[n]:
            return nums[0]
        elif nums[n] <= nums[n-1]:
            return nums[n]

        l = 0
        h = n - 1
        
        while (l <= h):
            m = l + (h - l)//2
            if (nums[m] > nums[m+1]):
                return nums[m+1]
            elif nums[m-1] > nums[m]:
                return nums[m]
            elif nums[m] > nums[0]:
                l = m + 1
            else:
                h = m - 1

        return nums[l]

## Problem 3: (https://leetcode.com/problems/find-peak-element/)
# A peak element is an element that is greater than its neighbors.

# Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

# The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

# You may imagine that nums[-1] = nums[n] = -∞.

# Example 1:

# Input: nums = [1,2,3,1]
# Output: 2
# Explanation: 3 is a peak element and your function should return the index number 2.
# Example 2:

# Input: nums = [1,2,1,3,5,6,4]
# Output: 1 or 5 
# Explanation: Your function can return either index number 1 where the peak element is 2, 

#              or index number 5 where the peak element is 6.
# Note:

# Your solution should be in logarithmic complexity.

#Approach
# I would like to do Iterative binary search
# elements should be greater than both the neighbour elements
#based on the higher elements we need to move low and high and return the mid
#Time complexity: o(logN)
# Space complexity: o(1)


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        l = 0
        high = n - 1
        while(l <= high):
            mid = l +(high - l)//2

            if((mid == 0) or nums[mid] > nums[mid - 1]) and ((mid == n-1) or nums[mid] > nums[mid +1]):
                return mid
            else:
                if(mid != 0 and nums[mid - 1] > nums[mid]):
                    high = mid - 1
                else:
                    l = mid + 1
        
        return l
        