'''
We will do a binary search and from the middle we check it's left neigbour is greater, we search left side
Alternatively we search on the right side if that neighbour is greater
Time compelxity - O(log-n) since we do binary search
Space complexity - O(1) no extra space
'''

class Problem3:
    def findPeakElement(self, nums: List[int]) -> int:
        l , r = 0, len(nums) - 1
        while l <= r:
            m = l + ((r - l) // 2)
            if m > 0 and nums[m] < nums[m - 1]:
                r = m - 1
            elif m < len(nums) - 1 and nums[m] < nums[m + 1]:
                l = m + 1
            else:
                return m 