'''
We run a modifed binary search where we do a further search either on the left or right based on a boolean value.
This helps us locate the range for the target.
Time compelxity - O(log-n) since we do binary search
Space complexity = O(1) no extra space
'''

class Problem1:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        leftIdx = self.binSearch(nums, target, True)
        rightIdx = self.binSearch(nums, target, False)
        return [leftIdx, rightIdx]
 
    def binSearch(self, nums, target, leftSearch):
        # if leftSearch is True, we search left-most index else we do rigt-most index

        l, r = 0, len(nums) - 1
        i = -1

        while l <= r:
            m = (l + r) // 2
            if target > nums[m]:
                l = m + 1
            elif target < nums[m]:
                r = m - 1
            else:
                i = m    
                if leftSearch:
                    r = m - 1
                else:
                    l = m + 1
        return i
