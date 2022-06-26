# Time Complexity = O(logn)
# Space Complexity = O(1)

class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        if len(nums) == 1 and target == nums[0]:
            return [0, 0]
        
        if len(nums) == 0:
            return [-1, -1]
        
        if target < nums[0] or target > nums[len(nums) -1]:
            return [-1, -1]
        
        
        # Binary Search for finding the first occurence of the element
        def firstOccurence (nums, target):
            low = 0
            high = len(nums) - 1
            while (low <= high):
                mid = low + ((high - low) // 2)
                
                if target == nums[mid]:
                    if mid == 0 or nums[mid - 1] < nums[mid]:
                        return mid
                    else:
                        high = mid - 1    
                elif target < nums[mid]:
                    high = mid - 1
                elif target > nums[mid]:
                    low = mid + 1
            return -1
        
        
        # Binary Search for finding the last occurence of the element
        def lastOccurence (nums, target):
            low = 0
            high = len(nums) - 1
            while (low <= high):
                mid = low + ((high - low) // 2)
                
                if target == nums[mid]:
                    if mid == len(nums) - 1 or nums[mid + 1] > nums[mid]:
                        return mid
                    else:
                        low = mid + 1    
                elif target > nums[mid]:
                    low = mid + 1
                elif target < nums[mid]:
                    high = mid - 1
            return -1
        
        first = firstOccurence(nums, target)
        last = lastOccurence(nums, target)
        
        return [first, last]
        
        