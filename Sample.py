## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

# Approach 1
# Time Complexity: O(log n)
# Space Complexity: O(1)
# Regular binary search. Discard the sorted side, move the low to mid+1 if left sorted. Move to high to mid if right is sorted.


class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums)==1:
           return nums[0] 

        low, high = 0, len(nums)-1
 
        while low < high:
            mid = (low + high)//2
            if nums[mid] <= nums[high]: # right is sorted
                high = mid
            else: # left is sorted
                low = mid + 1
            
        return nums[low]


# Approach 2:
# Time Complexity: O(log n)
# Space Complexity: O(1)

class Solution:
    def findMin(self, nums: List[int]) -> int:

        low = 0
        high = len(nums)-1
        while low <= high:
            if nums[low]<=nums[high]:
                return nums[low]
            
            mid = (low + high)//2

            if (mid == 0 or nums[mid] < nums[mid-1]) and (mid==len(nums)-1 or nums[mid] < nums[mid+1]): #handles edge cases
                return nums[mid]

            if nums[low]<=nums[mid]: #left is sorted
                low = mid + 1
            else: #right is sorted
                high = mid - 1




## Problem 3: (https://leetcode.com/problems/find-peak-element/)
# Time Complexity: O(log n)
# Space Complexity: O(1)
# Do a binary search, compare middle with left and right, if middle not a peak then move towards bigger number. 
# if left is bigger number than middle then set high to middle, or vice versa

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low,high=0,len(nums)-1
        while low < high:
            mid=(low+high)//2

            if (mid==0 or nums[mid] > nums[mid-1]) and nums[mid] > nums[mid+1]:
                return mid
            
            if nums[mid] > nums[mid+1]:
                high = mid 
            else:
                low = mid + 1
        
        return low

## Problem 3: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
# Time Complexity: O(log n)
# Space Complexity: O(1)

# Do binary search to get first index. With first index set to low, do a binary search to get second index. 
# In BS methods, keep checking if mid -1 != mid to get first index and mid != mid+1 to get second index


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        def searchFirst(low, high, target, nums):
            while low <= high:
                mid = ( low + high ) // 2
                if (nums[mid] == target):
                    if (mid == 0 or nums[mid-1] != target):
                        return mid
                    else:
                        high = mid - 1                   
                elif nums[mid] > target:
                    high = mid - 1    
                else:
                    low = mid + 1

            return -1

        def searchSecond(low, high, target, nums):
            while low <= high:
                mid = ( low + high ) // 2
                if (nums[mid] == target):
                    if (mid == len(nums)-1 or nums[mid+1] != target):
                        return mid
                    else:
                        low = mid + 1
                elif nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            
            return -1

        low,high=0,len(nums)-1
        first = searchFirst(low,high,target,nums) # O(log n) for first index
        if first == -1:
            return [-1,-1]
        
        second = searchSecond(first,high,target,nums) # O(log n) for second index
        return [first,second]
        
        
        
        
