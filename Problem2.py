'''
We will do a binary search to find the min. 
We maintain an exit condition if we are in a position where left index is lower than right index.
We check the minimum, store it and break out.
Time compelxity - O(log-n) since we do binary search
Space complexity = O(1) no extra space
'''

class Problem2:
    def findMin(self, nums: List[int]) -> int:
        res = nums[0]
        l, r = 0, len(nums) - 1
        while l <= r:
            if nums[l] < nums[r]:
                res = min(res, nums[l])
                break
            m = (l + r)//2
            res = res(res, nums[m])
            if nums[m] >= nums[l]:
                l = m + 1
            else:
                r = m - 1
        return res
