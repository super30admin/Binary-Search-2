'''
Using two separate Binary Search I try to find the left-most and right-most element equal to the target
Keeping in mind he edge cases like a) target is first index b) target is last index
'''


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l = 0
        h = len(nums) - 1

        if len(nums) == 0:
            return [-1,-1]

        def search_left(nums,target,l,h):
            if nums[0] == target:
                return 0
            else:
                while l <= h:
                    mid = (l+h) // 2

                    if nums[mid] == target:
                        if nums[mid-1] != target:
                            return mid
                        else:
                            h = mid - 1

                    elif nums[mid] > target:
                        h = mid - 1

                    else:
                        l = mid + 1
            return -1

        def search_right(nums,target,l,h):
            if nums[-1] == target:
                return len(nums) - 1
            else:
                while l <= h:
                    mid = (l+h) // 2

                    if nums[mid] == target:
                        if nums[mid+1] != target:
                            return mid
                        else:
                            l = mid + 1

                    elif nums[mid] > target:
                        h = mid - 1

                    else:
                        l = mid + 1
            return -1

        left = search_left(nums,target,l,h)
        right = search_right(nums,target,l,h)

        return [left,right]