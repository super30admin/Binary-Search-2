# Time complexity : O(log(n))
# Space complexity : O(1), space to maintain left and right pointers
# The code ran on github

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        n = len(nums)
        l = 0; h = n-1

        if len(nums) == 0 or nums[l] > target or nums[h] < target:
            return [-1, -1]
        
        def get_start(nums, l, h, target):
            while l <= h:
                mid = l + (h-l)//2
                if nums[mid] == target:
                    # Check if it is the first occurence of target
                    if (mid == 0 or nums[mid] != nums[mid - 1]):
                        return mid
                    else:
                        h = mid - 1
                    
                elif nums[mid] > target:
                    h = mid - 1
                else:
                    l = mid + 1
            return -1

        def get_last(nums, start, h, target):
            while start <= h:
                mid = start + (h - start)//2
                if nums[mid] == target:
                    # Check if it is the last occurence of target
                    if mid == len(nums) - 1 or nums[mid] != nums[mid + 1]:
                        return mid
                    else:
                        start = mid + 1
                else:
                    h = mid - 1
            return start

        # Get the first occurence of target
        start = get_start(nums, l, h, target)
        if start == -1:
            return [-1, -1]
        else:
            # Traverse to the right of start index to get the last index
            end = get_last(nums, start, h, target)
            return [start, end]

        return [-1, -1]


        