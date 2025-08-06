# Find first and last position of element in a sorted array
# #Using two Binary Search to find the first and last position of an element in a sorted array
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def binarySearchFirst(nums,l,h,target):
            while l<=h:
                mid = (l+h)//2
                if nums[mid] == target:
                    if mid == l or nums[mid]!= nums[mid-1]:
                        return mid
                    else:
                        h = mid-1
                elif nums[mid]>target:
                    h = mid-1
                else:
                    l = mid+1
            return -1

        def binarySearchLast(nums,l,h,target):
            while l<=h:
                mid = (l+h)//2
                if nums[mid] == target:
                    if mid == h or nums[mid]!= nums[mid+1]:
                        return mid
                    else:
                        l = mid+1
                elif nums[mid]>target:
                    h = mid-1
                else:
                    l = mid+1
        
        first = binarySearchFirst(nums, 0, len(nums)-1, target)
        if first == -1:
            return [-1,-1]
        last = binarySearchLast(nums, first, len(nums)-1, target)
        return [first,last]

        