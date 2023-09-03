class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
      
        result = [-1, -1]
        
        result[0] = self.binarySearchFirst(nums, target)
        result[1] = self.binarySearchLast(nums, target)
        
        return result

    def binarySearchFirst(self, nums, target):
        low, high = 0, len(nums) -1
        
        while low <= high:
            mid = (low + high)//2
			
            if nums[mid] == target:
                if(mid == 0 or nums[mid] > nums[mid-1]):
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] > target: 
                high = mid - 1
            else:
                low = mid + 1  
        
        return -1
        
  
    def binarySearchLast(self, nums, target):
        low, high = 0, len(nums) -1
        
        while low <= high:
            
            mid = (low + high)//2
            
            if nums[mid] == target:
                if(mid == high or nums[mid] < nums[mid+1]):
                    return mid
                else: 
                    low = mid + 1
            elif nums[mid] > target: 
                high = mid - 1
            else:
                 low = mid + 1
        return -1
