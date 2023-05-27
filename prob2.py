# Time Complexity : O(log(n))
# Space Complexity :O(1)
# Passed on Leetcode: no
# Approch: Apply Binary search

class Solution:
    def findMin(self, nums: List[int]) -> int:

        l = 0
        r = len(nums)-1
        m = nums[0]
        
        while l <= r:
            mid = (l+r)//2
            m = min(nums[mid], m)

            if nums[mid] > nums[l]: # left sorted
                if nums[l] > nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1

            elif nums[mid] < nums[r]: # right sorted
                if nums[l] > nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1
            
        return m