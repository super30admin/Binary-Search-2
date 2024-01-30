'''
Time Complexity: O(log n). We do two binary searches but the constants are ignored.
Space Complexity: O(1). We are not using any additional stack space.

This code works on Leetcode.
'''



class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        low, high = 0, n-1
        stIndex, ltIndex = -1, -1
        if n==0 or nums[-1] < target or target < nums[0]: #if the target does not lie in the array
            return [-1,-1]
        if nums[0] == target and nums[-1] == target: #if the entire array is that of the target
            return [0, n-1]
        while low<=high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                if mid == low or nums[mid-1] < nums[mid]: 
                    stIndex = mid
                    break
                else: #move left until we dont find an element less than the target
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        print(stIndex)
        low, high = 0, n-1
        while low <= high:
            mid = low + (high - low)//2
            if nums[mid]==target:
                if mid == high or nums[mid+1] > nums[mid]:
                    return [stIndex,mid]
                else: #move right until we dont find an element greater than target
                    low = mid + 1
            elif  nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return [-1,-1]

        