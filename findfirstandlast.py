#Executed in leet code
#time complexity -O(logn)
# space complexity - O(1)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def search(x):
            lo, hi = 0, len(nums)           
            while lo < hi:
                mid = (lo + hi) // 2
                if nums[mid] < x:
                    lo = mid+1
                else:
                    hi = mid                    
            return lo
        
        lo = search(target)
        hi = search(target+1)-1
        
        if lo <= hi:
            return [lo, hi]
                
        return [-1, -1]