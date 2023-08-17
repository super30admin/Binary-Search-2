#Time Complexity : O(logn + logn) = O(2logn) = O(logn) where n is the number of element in nums
#Space Complexity : O(1) since we dont use any extra space
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

#Approach: Here we apply 2 binary search to find the first occurence index and another search for last occurence index. 
#In the first binary search to find the first occurence, if mid element is target then we check the mid element is > mid-1 element, if yes we return mid or we move toward left (high = mid-1).
#In the second binary search to find last occurence, if the mid element is the target then we check if mid element is < mid+1 element, if yes we return mid or we move towards right (low = mid+1).

class Solution:
    def binarySearchFirst(self, nums, target):
        low = 0
        high = len(nums)-1
        while low<=high:
            mid = (low+high)//2
            if (nums[mid] == target):
                if(mid == 0 or nums[mid] > nums[mid-1]):
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def binarySearchLast(self, nums, target, low, high):
        while low<=high:
            mid = (low+high) // 2
            if(nums[mid] == target):
                if(mid == high or nums[mid] < nums[mid+1]):
                    return mid
                else: 
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0: return [-1,-1]
        n = len(nums)
        if nums[0] > target or nums[n-1] < target: return [-1,-1]
        first = self.binarySearchFirst(nums, target)
        if first == -1: return [-1,-1]
        last = self.binarySearchLast(nums, target, first, n-1)

        return [first, last]
        