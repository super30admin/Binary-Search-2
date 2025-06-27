# TC : O(logn)
# SC : O(1)
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def binarySearchstart(nums,target):
            low = 0
            high =len(nums)-1
            while low<=high :
                mid =low+(high-low)//2
                if nums[mid]==target:
                    if mid==0 or nums[mid]!=nums[mid-1]:
                        return mid
                    else:
                        high=mid-1
                elif  target< nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1

        def binarySearchend(nums,target):
            low=0
            high =len(nums)-1
            while low<=high :
                mid =low+(high-low)//2
                if nums[mid]==target:
                    if mid == len(nums) - 1 or nums[mid + 1] != target:
                        return mid
                    else:
                        low=mid+1
                elif  target> nums[mid]:
                    low=mid+1
                else:
                    high=mid-1
            return -1
        
        start = binarySearchstart(nums,target)
        if( start == -1):
            return [-1,-1]
        end = binarySearchend(nums,target)
        return [start,end]

    