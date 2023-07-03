class Solution:
    def findMin(self, nums):
        if nums is None or len(nums) == 0:
            return -1
        
        low = 0
        high = len(nums) - 1
        
        while low < high:
            mid = low + (high - low) // 2
            
            if nums[mid] > nums[high]:
                low = mid + 1
            else:
                high = mid
        
        return nums[low]



solution = Solution()


num1 = [3, 4, 5, 1, 2]
min_num1 = solution.findMin(num1)
print(min_num1) 


num2 = [4, 5, 6, 7, 0, 1, 2]
min_num2 = solution.findMin(num2)
print(min_num2)  
