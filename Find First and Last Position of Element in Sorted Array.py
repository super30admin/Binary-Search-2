"""
Time Complexity :  O(log n)
Space Complexity : O(1)
"""

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        def findCorner(side):
            l = 0
            r = len(nums) -1

            while l <= r :
                mid = l + ((r-l) >> 1)

                if nums[mid] == target :
                    if side == "left" :
                        if mid == 0 or nums[mid-1] < target :
                            return mid
                        else :
                            r = mid - 1
                                
                    else :
                        if mid == len(nums) -1 or nums[mid+1] > target :
                            return mid
                        else :
                            l = mid + 1
                        

                elif nums[mid] > target:
                    r = mid - 1

                else :
                    l = mid + 1

            return -1
        
        result = [-1, -1]
        result[0] = findCorner("left")
        if result[0] > -1: 
            result[1]  = findCorner("right")
        return result
