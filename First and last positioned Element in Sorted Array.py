# For first index - Take mid, if array[mid] is equal to target, check if the element before it is leeser than the 
# current element. If it is, then return mid. Else, high=mid-1. If the elememt < target, low =mid+1
#  else high=mid-1
# For last index - Take mid, if array[mid] is equal to target, check if the element after it is grater than the 
# current element. If it is, then return mid. Else, low=mid+1. If the elememt < target, low =mid+1
#  else high=mid-1

# Time complexity: O(logn)
# Space complexity: O(1)

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        low = 0
        high = len(nums)-1
        first_ind=-1
        while low<=high:
            mid = (low+high)//2
            if nums[mid] == target:
                if mid == 0 or nums[mid-1]<nums[mid]:
                    first_ind=mid
                    break
                else:
                    high=mid-1
            else:
                if nums[mid] < target:
                    low = mid+1
                else:
                    high = mid-1
                
        low = 0
        high = len(nums)-1
        last_ind =-1
        while low<=high:
            mid = (low+high)//2
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid]<nums[mid+1]:
                    last_ind=mid
                    break
                else:
                    low=mid+1
            else:
                if nums[mid] < target:
                    low = mid+1
                else:
                    high = mid-1

        return[first_ind,last_ind]
                

            
        