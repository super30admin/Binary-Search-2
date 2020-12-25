class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        if len(nums) == 0 :
            
            return -1
        
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            
            if nums[low] < nums[high]:
                
                return nums[low]
            
            mid = (low + high) // 2
            
            if nums[mid] > nums[low] and nums[mid] < nums[high]:
                
                return nums[mid]
            
            if (mid == 0 or nums[mid] < nums [mid-1]) and (mid == len(nums)-1 or nums[mid] < nums[mid+1]):
                    
                    return nums[mid]
                
            elif nums[low] <= nums[mid]:
                
                low = mid + 1
                
            else:
                
                high = mid - 1
                
        return -1
    
        
