class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        start = 0
        end = len(nums) - 1
        result = [-1, -1]
        while start <= end:
            mid = start + (end - start) // 2
            if nums[mid] == target:
                end = mid - 1
                result[0] = mid
            elif target > nums[mid]:
                start = mid + 1
            else:
                end = mid - 1

        start = 0
        end = len(nums) - 1
        while start <= end:
            mid = start + (end - start) // 2
            if nums[mid] == target:
                start = mid + 1
                result[1] = mid
            elif target > nums[mid]:
                start = mid + 1
            else:
                end = mid - 1
        return result


check = Solution()
print(check.searchRange([5, 7, 7, 8, 8, 10], 8))

# def searchRange(self, nums: List[int], target: int) -> List[int]:
#     start = 0
#     end = len(nums) - 1
#     while start <= end:
#         mid = start + (end - start)//2
#         if nums[mid] == target:
#             l, r = mid, mid
#             while l != 0 and nums[l-1] == target:
#                 l -= 1
#             while r != len(nums)-1 and nums[r+1] == target:
#                 r += 1
#             return [l, r]
#         elif target > nums[mid]:
#             start = mid + 1
#         else:
#             end = mid - 1
#     return [-1, -1]

#
# check = Solution()
# print(check.searchRange([5, 7, 7, 8, 8, 10], 8))
