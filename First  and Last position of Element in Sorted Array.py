
#TC: O(logN) -, n is length of arr, as binary search to find first positon, and 
# binary search again from first index to rest to find last position
#SC: O(1)
#Executed on LC: yes, 34
#problem: NA
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        n = len(nums)
        
        if nums is None or len(nums) == 0:
            return [-1, -1]
        
        if target < nums[0]:
            return [-1,-1]
        
        if target > nums[n-1]:
            return [-1, -1]
        
        mini = -1
        maxi = -1
        
        def binarysearchFirst(low, high):

            while low <= high:
                mid = low + (high - low)//2

                if (nums[mid] == target):
                    if (mid - 1 >= 0 and nums[mid - 1] <  nums[mid]) or (mid == 0):
                        return mid
                    else:
                        high = mid - 1

                elif nums[mid] < target:
                    low = mid + 1

                elif nums[mid] > target:
                    high = mid - 1
            return -1
                    
        def binarysearchLast(low, high):

            while low <= high:
                mid = low + (high - low)//2
                if (nums[mid] == target):
                    if (mid + 1 <= n - 1 and nums[mid + 1] > nums[mid]) or (mid == n -1):
                        return mid
                    else:
                        low = mid + 1

                elif nums[mid] < target:
                    low = mid + 1

                elif nums[mid] > target:
                    high = mid - 1
            return -1
                    
        mini = binarysearchFirst(0,n-1)
        if mini == -1:
            return [-1, -1]
        maxi = binarysearchLast(mini,n-1)
        
        return[mini, maxi]
            