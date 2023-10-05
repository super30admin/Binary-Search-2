
#TC: O(logN) -n is length of arr, as binary search is done only on one half,other half can be rejected. in rotated array on ehalf is defintely sorted!
#SC: O(1)
#Executed on LC: yes, 153
#problem: NA
class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        low = 0
        high = len(nums) - 1 
        
        if len(nums) == 1:
            return nums[0]
        
        # if arr is sorted,low is minimum
        if nums[low] <=  nums[high]:
            return nums[low]
            
        while (low <= high):
            mid = low + (high - low)//2
            
            # if arr is sorted,low is minimum
            if nums[low] <=  nums[high]:
                return nums[low]
            
            # if left side is sorted, ignore it and check right side after mid
            if nums[mid] >= nums[low]:
                low = mid + 1
            
            # if right side is sorted, check left side including MID!
            else:
                high = mid

        return nums[mid]
            
            