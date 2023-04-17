#34. Find First and Last Position of Element in Sorted Array

#TC: O(logN)
#SC: O(1)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def bs_left(nums, target):
            l, h = 0, len(nums) - 1
            while l <= h:
                mid = l + (h - l)//2
                if nums[mid] == target:
                    if mid == l or nums[mid-1] != target:
                        return mid
                    h = mid - 1
                elif target > nums[mid]:
                    l = mid + 1
                else:
                    h = mid - 1
            return -1

        def bs_right(nums,target):
            l, h = 0, len(nums) - 1
            while l <= h:
                mid = l + (h - l)//2
                if nums[mid] == target:
                    if mid == h or nums[mid+1] != target:
                        return mid
                    l = mid + 1
                elif target > nums[mid]:
                    l = mid + 1
                else:
                    h = mid - 1
            return -1

        ans = []
        ans.append(bs_left(nums,target))
        ans.append(bs_right(nums,target))
        return ans
