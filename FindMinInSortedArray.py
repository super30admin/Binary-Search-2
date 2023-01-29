# All test cases passed in leetcode

# Here we apply binary search and check if the mid is less than mid-1 and mid+1. 
# If not then we check if mid is in left sorted, if yes then we move to left pointer to mid+1. 
# Time complexity - O(logn)
# Space complexity - O(1)

class Solution:
    def findMin(self, nums: List[int]) -> int:

        
        l = 0
        h = len(nums)-1


        while l<=h:
            mid = (l+h)//2

            if nums[l]<nums[h]:
                return nums[l]

            if (mid==0 or nums[mid]<nums[mid-1]) and (mid==len(nums)-1 or nums[mid]<nums[mid+1]):
                return nums[mid]
            elif nums[l]<=nums[mid]:
                l = mid+1
            else:
                h = mid-1

        return -1