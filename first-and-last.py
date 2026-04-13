class Solution:
    # wrong - if you do binary search, then find 1, and expand window -> that is o(n) bc array could be all same number like [8,8,8,8,..]
        def searchRange(self, nums: List[int], target: int) -> List[int]:
            lower_bound = self.binarySearchLower(nums, target)
            if lower_bound == -1:
                return [-1, -1]

            upper_bound = self.binarySearchUpper(nums, target)

            return [lower_bound, upper_bound]

        def binarySearchLower(self,nums, target):
            left = 0
            right = len(nums)-1

            while left <= right:
                mid = left + (right-left)//2
                if nums[mid]==target:
                    # we're at lower
                    if left == mid or nums[mid-1] < target:
                        return mid
                    else:
                        right = mid - 1 
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid-1
            
            return -1

        def binarySearchUpper(self,nums, target):
            left = 0
            right = len(nums)-1

# [5,7,7,8,8,8,10]
 #.l     l m    r
            while left <= right:
                mid = left + (right-left)//2
                if nums[mid]==target:
                    # we're at upper bound 
                    if right == mid or nums[mid+1] > target:
                        return mid
                    else:
                        left = mid + 1 
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid-1
            
            return -1