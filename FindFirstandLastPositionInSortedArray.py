#Time Complexity: O(log n)
#Space Complexity: O(1)
# Approach: Two while loops to find left and right index in a sorted array using Binary Search

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1,-1]
        
        low = 0
        high = len(nums) - 1
        left_i = -1
        right_i = -1

        #binary search to find first occurence
        while low<=high:
            mid = (low + high) // 2
            if nums[mid] == target:
                left_i = mid
                high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1


        #binary search to find last occurence
        while low<=high:
            mid = (low + high) // 2
            if nums[mid] == target:
                right_i = mid
                low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1

        return[left_i, right_i]