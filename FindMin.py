

# Approach - If the mid element is found to be the lowest of its neighbours it is considered to be the minimum neighbour. If it is not the lowest then the half which is sorted is discarded and we do binary search on the unsorted half

class Solution:
    def findMin(self, nums: List[int]) -> int:
       
        if not nums:
            return -1
       
        l = 0
        n = len(nums)
        h = n-1
        

        while l<=h:
            if nums[l]<=nums[h]:
                return nums[l]

            m = l + (h-l)//2
           
            if (m!=0 and nums[m-1]>nums[m]) and (m!=n-1 and nums[m+1]>nums[m]):
                return nums[m]
            if nums[l]<=nums[m]:
                l = m+1
            else:
                h = m-1
        return nums[l]