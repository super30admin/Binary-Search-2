'''
I try to find the pivot element by finding the middle element and updating the pointers such that I'm
looking at the unsorted side of the array
'''

class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        r = len(nums) - 1
        res = nums[0]

        while l <= r:
            if nums[l] <= nums[r]:
                res = min(res,nums[l])
                break

            mid = (l+r) // 2
            res = min(res,nums[mid])

            if nums[l] <= nums[mid]:
                res = min(res,nums[l])
                l = mid + 1
            else:
                res = min(res,nums[r])
                r = mid - 1

        return res









