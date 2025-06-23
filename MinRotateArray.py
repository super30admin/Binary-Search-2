# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes

class Solution(object):
    def findMin(self, nums):
        if len(nums) == 1:
            return nums[0]
        low = 0
        high = len(nums) -1
        while(low <= high):
            if (nums[low] < nums[high]):
                return nums[low]
            mid = low + (high - low) //2
            if (mid == 0 or nums[mid] < nums[mid - 1]) and (mid == len(nums)-1 or nums[mid] < nums[mid + 1]):
                return nums[mid]
            elif (nums[low] <= nums[mid]):
                low = mid + 1
            else:
                high = mid -1
        return -1

        
obj = Solution()
output1 = obj.findMin([3,4,5,1,2])
print(output1)
output2 = obj.findMin([4,5,6,7,0,1,2])
print(output2)
output3 = obj.findMin([11,13,15,17])
print(output3)
output4 = obj.findMin([2,1])
print(output4)