# Binary-Search-2
## Time complexcity : o(log n) we go through half part and another half part
## space complexcity : o(1) we donot create new array
## we traversed through the left half of the array to find whether any element with target exits and we went through right half to get any element that is equal to target to set the index
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums)==None and len(nums) == 0:
            return [-1,-1]

        first = self.binarySearchFirsthalf(nums, target)
        if first == -1: ## returning as there is no first element found
            return [-1, -1]
        second = self.binarySearchSecond(nums, target)
        return [first, second]
        ## first half of the array
    def binarySearchFirsthalf(self,nums, target):
            left = 0
            right = len(nums)-1
            while left <= right:
                mid = left + (right-left)//2
                if nums[mid] == target:
                    if mid == 0 or nums[mid - 1] < nums[mid]:
                
                        return mid
                    right = mid -1
                elif nums[mid] > target :
                    right = mid - 1
                else:
                    left = mid + 1
            return -1

    def binarySearchSecond(self,nums, target):
            left = 0
            right = len(nums)-1
            while left <= right:
                mid = left + (right - left)//2
                if nums[mid] == target:
                    if mid == len(nums) -1 or nums[mid + 1] > nums[mid]:
                        return mid
                    low = mid + 1
                elif nums[mid] > target:
                    right = mid -1
                else:
                    left = mid+ 1
            return -1

                 


## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

## Time complexcity: o(log n)
## space compexcity : o(1)
## This we have the minimum element in the unsorted array for max cases . So, we check if the mid is less than previous and before element . If it is return mid . or check for unsorted part in teh array

class Solution:
    def findMin(self, nums: List[int]) -> int:
       if  len (nums) == None or len(nums)==0:
           return int(sys.maxsize)

       low = 0
       high = len(nums)-1
       while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]
            mid = low + (high-low)//2
            if (mid == 0 or nums[mid] < nums[mid -1]) and (mid == len(nums)-1 or nums[mid] < nums[mid + 1]):
                return nums[mid]
            if nums[low] <= nums[mid]: # array is sorted
                low = mid + 1
            else:
                high = mid - 1
       return 123

## Problem 3: (https://leetcode.com/problems/find-peak-element/)
## we are finding the element which is peek -∞[1,2,1,3,5,6,4]-∞
## binary search can be done through sorted element
## we will be moving towards the higher element 
## neighbors shouldn't be similar . Binary search doesnot work
## Time complexcity : 0(logn)
## space complexcity: o(1)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
           return -1
        
        left = 0
        right = len(nums)-1
        while left <= right:
            mid = left + (right - left)//2
            if ( mid == left or nums[mid] > nums[mid -1]) and (mid == right or nums[mid] > nums[mid + 1]):
                return mid
            elif nums[mid + 1] > nums[mid]:
                left = mid +1
            else:
                right = mid -1
        return 123



