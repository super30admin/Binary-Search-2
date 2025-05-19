# Used two binary search functions to find the lower and upper bounds of the target.
# The lower_bound function finds the first index where target appears or could appear.
# The upper_bound function finds the index just after the last occurrence of target; result is [lb, ub - 1].

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def lower_bound(nums):
            lower_bound=len(nums)
            low,high = 0, len(nums)-1
            while(low<=high):
                mid = (low+high) //2
                if (nums[mid]>=target):
                    lower_bound = mid
                    high = mid-1
                else:
                    low = mid+1
            return lower_bound
        
        def upper_bound(nums):
            upper_bound=len(nums)
            low,high = 0, len(nums)-1
            while(low<=high):
                mid = (low+high) //2
                if (nums[mid]>target):
                    upper_bound = mid
                    high = mid-1
                else:
                    low = mid+1
            return upper_bound
        lb = lower_bound(nums)
        ub = upper_bound(nums)
        return [-1,-1] if(lb == len(nums) or nums[lb] != target) else [lb,ub-1]
