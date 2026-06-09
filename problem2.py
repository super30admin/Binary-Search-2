# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes 
# Any problem you faced while coding this : No


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low , high = 0, len(nums)-1

        while low<=high:

            #check if low is minimum we required 
            if nums[low]<=nums[high]:
                return nums[low]

            mid = low + (high - low) // 2

            #checking if mid is minimum 
            if(mid>0 and nums[mid] <nums[mid-1]):
                return nums[mid]
            elif nums[low]<=nums[mid]:  #this is left sorted so move right 
                low = mid + 1
            else: #its right sorted so move left 
                high = mid -1 
        