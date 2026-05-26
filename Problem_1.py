class Solution:
    '''
    This function helps in finding the first occurance of the target.
    Once we land on one of the occurance of target, we check if this is the first by looking at the number before it.

    Otherwise we eliminate the right side of the mid as the first occurance will be on the left for sure.
    Remember to make sure the if statements are clearly defined so that there is not a default case that can alter l or r.
    '''
    def searchFirst(self, nums, target):
        l = 0
        r = len(nums) - 1

        while l <= r:
            m = l + (r-l)//2

            if nums[m] == target:
                if m == 0 or nums[m-1] != nums[m]:
                    return m
                else:
                    r = m-1

            if nums[m] > target:
                r = m-1
            if nums[m] < target:
                l = m+1
            
        return -1

    '''
    Since we already found the first occurance we now proceed to find the last occurance of the target in the 
    right of the first occurance including the first occurance since it can be possible that there is only one occurance of target.

    If we come across the target, we check if it is the last occurance, otherwise we look on the right of the mid,
    since the last occurance will definately be on the right.
    '''
    def searchLast(self, nums, first, target):
        l = first
        r = len(nums) - 1

        while l <= r:
            m = l + (r-l)//2

            if nums[m] == target:
                if m == len(nums)-1 or nums[m+1] != nums[m]:
                    return m
                else:
                    l = m+1

            if nums[m] > target:
                r = m-1
            if nums[m] < target:
                l = m+1
        
        return first

    '''
    We start by finding the first occurance of the target, if found we proceed to find the last occurance of the target.
    If first occurance is not found that means target is not in the array and hence return [-1, -1]
    '''
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        first = self.searchFirst(nums, target)
        if first == -1:
            return [-1, -1]
        
        last = self.searchLast(nums, first, target)

        return [first, last]