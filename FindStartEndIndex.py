# All test cases passed in leetcode

#Here we apply binary search twice to get start and end index. 
# To get start index we check if mid equal to target and if its greater than mid-1, 
# if yes then that is the start index. If its not gretaer than mid-1 then we shift high pointer 
# to mid-1 and continue binary search. For getting end index we use start index from first binary 
# search as left pointer and len(nums)-1 as end index. Here also we check if mid is equal to target 
# and if its lesser than mid+1. If yes then its the end index. If not then we shift left pointer 
# to mid+1 and continue binary search.
# Time complexity - O(logn)
# Space complexity - O(1)

class Solution:

    
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        if not nums:
            return [-1,-1]

        left = self.getStartIndex(nums, target)
        if left==-1:
            return [-1,-1]
        right = self.getEndIndex(nums, target, left, len(nums)-1)
        return [left, right]


    def getStartIndex(self, nums, target):
        l = 0
        h = len(nums)-1

        while l<=h:
            mid = (l+h)//2

            if nums[mid]==target:
                if (mid==0 or nums[mid]>nums[mid-1]):
                    return mid
                else:
                    h = mid-1
            elif nums[mid]<target:
                l = mid+1
            else:
                h = mid-1
        return -1


    def getEndIndex(self, nums, target, l, h):

        while l<=h:
            mid = (l+h)//2

            if nums[mid]==target:
                if (mid==len(nums)-1 or nums[mid]<nums[mid+1]):
                    return mid
                else:
                    l = mid+1
            elif nums[mid]<target:
                l = mid+1
            else:
                h = mid-1
        return -1

        