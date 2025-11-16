# If there is only one element, return its index. If there are 2 elements, retuen the index of the 
# grater one. Else, calcualte mid. Check if array[mid-1]<array[mid] and array[mid]>array[mid+1] to see 
# if its the peek element. If true, return mid. Else, check if array[mid+1]>array[mid], if yes, low = mid+1
# else high=mid -1

# Time complexity: O(logn)
# Space complexity: O(1)


class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n==1:
            return 0
        if n==2:
            return 0 if nums[0]>nums[1] else 1

        low=0
        high = n-1
        while low<=high:
            mid = (low+high)//2
            if (mid==0 or nums[mid]>nums[mid-1]) and (mid==n-1 or nums[mid]>nums[mid+1] ):
                return mid
            elif mid<n-1 and nums[mid]<nums[mid+1]:
                low=mid+1
            elif  mid+1<n and nums[mid]>nums[mid+1]:
                high=mid-1
        