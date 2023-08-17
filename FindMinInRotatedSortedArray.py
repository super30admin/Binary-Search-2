#Time Complexity : O(logn) where n is the number of elements in nums - Binary Search
#Space Complexity : O(1) since we dont use any extra space
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

#Approach: We use the property of sorted rotated array that is, if a sorted array is rotated, the side which is sorted would never
#have the minimum value of the array. So when applying binary search, we move our low or high pointer to the part which is not sorted.

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 0: return -1
        low = 0
        high = len(nums)-1
        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]
            mid = (low+high)//2
            if (mid==0 or nums[mid] < nums[mid-1]) and (nums[mid]<nums[mid+1]):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                low=mid+1
            else:
                high=mid-1
        return -1 