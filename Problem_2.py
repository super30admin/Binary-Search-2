
#Time Complexity: O(logN)
#Space Complexity: O(1)

class Solution:
    
    def findMin(self, nums: List[int]) -> int:
        def condition(nums):
            lo, hi = 0 ,len(nums) - 1
            first, last = nums[0] ,nums[len(nums) - 1]
            size = len(nums)  
            while lo <= hi:
                mid = lo + (hi - lo) // 2
                nex = (mid + 1 )%size
                prev = (mid - 1 + size)%size
                if nums[mid] <= nums[nex]  and nums[mid] <= nums[prev]:
                    return nums[mid]
                elif nums[mid] < last:
                    hi = mid - 1
                elif  nums[mid] >= first:
                    lo = mid + 1 
            return -1
        return condition(nums)
        