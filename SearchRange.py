
# time complexity : O(log(n))
# space complexity : O(1)
class Solution:
    def searchRange(self, nums, target):
       
        n = len(nums)
        def bs(nums, element, isFirst):
            index = -1
            low, high = 0, n-1
            while low <= high:
                mid = (low+high)//2
                num = nums[mid]
                if num == element and isFirst:
                    high = mid -1
                    index = mid
                elif num == element and not isFirst:
                    low = mid + 1
                    index = mid
                elif num > target:
                    high = mid -1
                else:
                    low = mid + 1
            return index

        return [bs(nums, target, True), bs(nums, target, False)]