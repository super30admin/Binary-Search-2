# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes

class Solution(object):
    def searchRange(self, nums, target):
        if len(nums) == 0:
            return [-1, -1]
        first, last = -1, -1
        first = self.FirstOccurance(nums, target)
        if first == -1:
            return [-1, -1]
        last = self.LastOccurance(nums, target)
        return [first, last]
        
    def FirstOccurance(self, nums, target):
        low = 0
        high = len(nums) -1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if (mid == 0 or nums[mid - 1] != nums[mid]):
                    return mid
                #nums[mid-1] == nums[mid] indicating nums[mid] is not the first occurance
                high = mid -1
            elif nums[mid] > target:
                high = mid -1
            else:
                low = mid + 1
        return -1

    def LastOccurance(self, nums, target):
        low = 0
        high = len(nums) -1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if (mid == len(nums) -1 or nums[mid + 1] != nums[mid]):
                    return mid
                #nums[mid+1] == nums[mid] indicating nums[mid] is not the Last occurance
                low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
    
obj = Solution()
output1 = obj.searchRange([5,7,7,8,8,10], 8)
print(output1)
output2 = obj.searchRange([5,7,7,8,8,10], 0)
print(output2)
output3 = obj.searchRange([],0)
print(output3)