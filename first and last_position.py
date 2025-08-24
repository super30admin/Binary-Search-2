class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]: #O(logn)
        """trying to find the first and last index of the target 
        first search we give the first postion of the target index and we using it as low in the second saerch
        second search will give the last index
        we are returning the first and second result
        """
        low,high=0, len(nums)-1
        
        def FirstBinarySearch(nums,target, low,high):
            while low<=high:
                mid=(low+high)//2
                if nums[mid] == target:
                    if mid==0 or nums[mid-1]!=target:
                        return mid
                    else:
                        high=mid-1
                elif nums[mid]<target:
                    low = mid+1
                else:
                    high = mid-1
            return -1
        
        def SecondBinarySearch(nums, target, low,high):
            while low<=high:
                mid=(low+high)//2
                if nums[mid] == target:
                    if mid==len(nums)-1 or nums[mid+1]!=target:
                        return mid
                    else:
                        low=mid+1
                elif nums[mid]<target:
                    low=mid+1
                else:
                    high = mid -1
            return -1
    
        first = FirstBinarySearch(nums, target, 0, len(nums)-1)
        if first == -1:
            return [-1,-1]
        second = SecondBinarySearch(nums, target, first, len(nums)-1)
        return [first,second]
        