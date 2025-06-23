# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes

class Solution(object):
    def findPeakElement(self, nums):
        if len(nums) == 1:
            return 0
        low = 0
        high = len(nums) -1
        while(low <= high):
            mid = low + (high - low) //2
            if(mid == 0 or nums[mid] > nums[mid - 1]) and \
                (mid == len(nums)-1 or nums[mid] > nums[mid + 1]):
                return mid
            elif mid > 0 and nums[mid] < nums[mid - 1]:
                high = mid - 1
            else:
                low = mid + 1
        return -1
        
obj = Solution()
output1 = obj.findPeakElement([1,2,3,1])
print(output1)
output2 = obj.findPeakElement([1,2,1,3,5,6,4])
print(output2)
output3 = obj.findPeakElement([1])
print(output3)
output4 = obj.findPeakElement([1,2])
print(output4)