# Time complexity = O(n)
# Time taken to solve = 12 min 25 seconds.
# find left most element equal to target. Find Right most element equal to target using binary search.
class Solution:

    def searchRange(self, nums: List[int], target: int) -> List[int]:

        left_index = self.find_left_index_bsearch(nums, target)
        if left_index == -1:
            return [-1, -1]
        right_index = self.find_right_index_bsearch(nums, target)
        return [left_index, right_index]
        
    def find_left_index_bsearch(self, nums, target):
        start =0
        end = len(nums)-1
        while start <= end:
            mid = start + (end-start)//2
            # end condition
            if nums[mid] == target:
                if mid == 0 or nums[mid-1] != target:
                    return mid
            # decision 1
            # go left condition
            if nums[mid] >= target:
                end = mid -1
            else:
                start = mid +1
        return -1

    def find_right_index_bsearch(self, nums, target):
        start =0
        end = len(nums)-1
        while start <= end:
            mid = start + (end-start)//2
            # end condition
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid+1] != target:
                    return mid
            # decision 1
            if nums[mid] > target:
                end = mid -1
            else:
                # go right condition
                start = mid +1
        return -1