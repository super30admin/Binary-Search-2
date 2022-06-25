from pip import List
#Time Complexity = O(logn)
#Space Complexity = O(1)

class Solution:
    def FindMinElement(self, nums: List[int]):
        if(len(nums)==0):
            return None
        elif(len(nums)==1):
            return nums[0]
        elif(nums[0]<nums[-1]):
            return nums[0]
        low = 0
        high = len(nums)-1
        while(low<=high):
            mid = int(low + (high-low)/2)
            if(nums[low]<nums[high]):
                return nums[low]
            elif(mid== 0 or nums[mid]<nums[mid-1]) and (mid == len(nums)-1 or nums[mid]>nums[mid+1]):
                return nums[mid]
            elif(nums[low]<=nums[mid]):
                low = mid+1
            else:
                high = mid-1
        return None

#s = Solution()
#print(s.FindMinElement([2,3,4,5,1]))