# Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1,-1]
        low = 0
        high = len(nums) - 1
        first = -1
        while low <= high:   
            mid = low + (high - low)//2
            if nums[mid] == target:
                if mid != 0 and nums[mid-1] == target:
                    high = mid - 1
                else:
                    first = mid
                    break
            elif nums[mid] < target :
                low = mid + 1
            else:
                high = mid - 1
        last = -1
        low = first
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low)//2
            if nums[mid] == target:
                if mid != len(nums)-1 and nums[mid+1] == target:
                    low = mid + 1
                else:
                    last = mid
                    break
            elif nums[mid] < target :
                low = mid + 1
            else:
                high = mid - 1
        return [first, last]

#find the first occurence of element using binary search in range 0, n-1
#find the last occurence of element using binary search in range index of first occurence and n-1
#time complexity O(log2n)
#space complexity O(1)