class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def first(nums, target, start, end):
            if start > end: return -1
            while start <= end:
                mid = start + (end - start) // 2
                if nums[mid] == target:
                    if mid == 0 or nums[mid-1] < target:
                        return mid
                    else: end = mid - 1
                elif nums[mid] < target:
                    start = mid + 1
                else:
                    end = mid - 1
            return -1
        
        def second(nums, target, start, end):
            if start > end: return -1
            while start <= end:
                mid = start + (end - start) // 2
                if nums[mid] == target:
                    if mid == len(nums)-1 or nums[mid+1] > target:
                        return mid
                    else: start = mid + 1
                elif nums[mid] < target:
                    start = mid + 1
                else:
                    end = mid - 1
            return -1
        f = first(nums, target, 0, len(nums)-1)
        s = second(nums, target, 0, len(nums)-1)
        return [f,s]
