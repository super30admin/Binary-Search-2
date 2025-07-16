class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        l, r = 0, len(nums)-1

        #first pos
        first = -1
        while l <= r:
            mid = (l+r)//2

            if nums[mid] == target:
                first = mid
                r = mid - 1
            
            elif nums[mid] > target:
                r = mid - 1
            
            else:
                l = mid + 1

        l, r = 0, len(nums)-1

        #sec pos
        sec = -1
        while l <= r:
            mid = (l+r)//2

            if nums[mid] == target:
                sec = mid
                l = mid + 1
            
            elif nums[mid] > target:
                r = mid - 1
            
            else:
                l = mid + 1
        
        return [first, sec]
    
