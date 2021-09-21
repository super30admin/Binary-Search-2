class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        if n <= 3:
            return nums.index(max(nums))
        prev = 0
        curr = 1
        next_ = 2
        while next_ < n:
            #print( "prev, curr, next_", nums[prev] , nums[curr] , nums[next_] )
            #print("prev, curr, next_", prev, curr, next_)
            if nums[prev] < nums[curr] and nums[next_] < nums[curr]:
                return curr
            prev += 1
            curr += 1
            next_ += 1
        return nums.index(max(nums))


'''
Time complexity - O(n)
'''
