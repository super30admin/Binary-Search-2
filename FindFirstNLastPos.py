from typing import List

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        def binarylLeft(l, h) -> int:
            while l <= h:
                mid = l + (h - l) // 2

                if nums[mid] == target:
                    if (mid == 0 or nums[mid] != nums[mid-1]):
                        return mid
                    else:
                        h = mid -1
                elif nums[mid] < target:
                    l = mid + 1
                else:
                    h = mid -1
            return -1
        
        def binaryRight(l, h) -> int:
            while l <= h:
                mid = l + (h - l) // 2

                if nums[mid] == target:
                    if (mid == h or nums[mid] != nums[mid+1]):
                        return mid
                    else:
                        l = mid +1 
                elif nums[mid] < target:
                    l = mid + 1
                else:
                    h = mid -1
            
            return -1
        

        left = binarylLeft(0, len(nums)-1)
        if left == -1:
            return [-1, -1]
        else:
            right = binaryRight(left+1, len(nums)-1)
        
        if right == -1:
            return [left, left]
        else:
            return [left, right]
        
        
        


        


    
    
        
    
        