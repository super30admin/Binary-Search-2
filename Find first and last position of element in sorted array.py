# SC- O(n)
# TC-O(1)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        count = 0
        start_num = last_num = -1
        for i in range(len(nums)):
            if nums[i] == target:
                count += 1
                if count == 1:
                    start_num = i
                    last_num = i
                else:
                    last_num = i
        return [start_num, last_num]
