# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:


    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums) - 1
        f = -1
        l = -1
        if nums == None or len(nums) == 0:
            return [f,l]
        if nums[0] > target or nums[len(nums)-1] < target:
            return [f,l]
        mid = (low + high) // 2
        while(low <= high):
            mid = (low + high) // 2
            if nums[mid] == target:
                if mid == 0 or nums[mid-1] < target:
                # can be if mid == low or nums[mid-1] < target:
                    f = mid
                    break
                else:
                    high = mid - 1
            else:
                if nums[mid] > target:
                    high = mid -1
                else:
                    low = mid + 1

        if f == -1:
            return [f,l]
        low = f
        high = len(nums) - 1
        while(low <= high):
            mid = (low + high) // 2
            if nums[mid] == target:
                if (mid == len(nums) - 1) or nums[mid+1] > target:
                # can be if (mid == high or nums[mid+1] > target:
                    l = mid
                    break
                else:
                    low = mid + 1
            else:
                if nums[mid] > target:
                    high = mid -1
                else:
                    low = mid + 1
        return [f,l]

