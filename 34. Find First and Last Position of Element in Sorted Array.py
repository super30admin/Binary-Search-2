class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def leftmost(nums, target):
            left = 0
            right = len(nums) -1
            while left <= right:
                mid = left + (right - left) // 2
                if nums[mid] < target:
                    left = mid+1
                else:
                    right = mid -1
            return left
        def rightmost(nums, target):
            left = 0
            right = len(nums) -1
            while left<= right:
                mid = left + (right - left) // 2
                if nums[mid] <= target:
                    left = mid +1
                else:
                    right = mid -1
            return right
        left_ele = leftmost(nums, target)
        right_ele = rightmost(nums, target)

        if left_ele <= right_ele:
            ans = [left_ele, right_ele]
        else:
            ans = [-1,-1]
        return ans

        
            
                    
#Time Complexity: O(log(n))
#Space Complexity: O(1)