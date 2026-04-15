#Time complexity : O(log n)
#Space complexity : O(1)
#Leet code: Yes
#Solution: The idea is to use binary search to find the peak element in the array. We will compare the middle element with its neighbors to determine if it is a peak element. If it is not a peak element, we will check if the middle element is less than its right neighbor. If it is, then there must be a peak element on the right side of the middle element, so we will move our left pointer to mid + 1. Otherwise, there must be a peak element on the left side of the middle element, so we will move our right pointer to mid - 1. We will continue this process until we find a peak element.
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        """
        important : nums[i] != nums[i + 1] for all valid i.
    
        """
        l, r = 0, len(nums) - 1
        while(l<=r):
            mid = l + (r - l)//2
            if nums[mid] > nums[mid-1] and nums[mid] > nums[mid+1] and mid > 0 and mid < len(nums) - 1:
                return mid
            elif nums[mid]<nums[mid+1] and mid < len(nums)-1:#go towards increasing slope (keep climbing the mountain)
                l = mid + 1
            else:
                r = mid - 1