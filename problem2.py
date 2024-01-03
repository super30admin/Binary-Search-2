#time complexity: O(log N)
#space complexity : O(1)
#submit on leetcode: yes

class Solution:
    def findMin(self, nums: list[int]) -> int:
        n = len(nums)
        low, high = 0, n-1
        
        while low <= high:
            mid = low + (high-low)//2

            if nums[mid] < nums[mid-1]:
                return nums[mid]
            if nums[mid] > nums[high]:
                low = mid+1
            else:
                high = mid-1
        return nums[low] 

sol = Solution()
nums = [3,4,5,1,2]

print(sol.findMin(nums))