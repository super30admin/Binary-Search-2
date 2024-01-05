# Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            if nums[low] <= nums[high]:#already a sorted array
                return nums[low]
            mid = low + (high - low)//2
            if (mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid] < nums[mid+1]) : #check if mid is minimum
                return nums[mid]
            elif nums[low] <= nums[mid]: #check if left is sorted then min lies right side
                low = mid + 1
            else:
                high = mid - 1

#time complexity O(log2n)
#space complexity O(1)