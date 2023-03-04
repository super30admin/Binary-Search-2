# Time Complexity: O(log n)
# Space Complexity: O(1)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # if not nums:
        #     return [-1,-1]
        # if target < nums[0] or target > nums[-1]:
        #     return [-1,-1]
        # low = 0
        # high = len(nums) - 1
        # ans = [-1,-1]
        # def b_search_first(low, high, target):
        #     while low <= high:
        #         mid = int(low + ((high - low) / 2))
        #         if nums[mid] < target:
        #             low = mid + 1
        #         elif nums[mid] > target:
        #             high = mid - 1
        #         else:
        #             ans[0] = mid
        #             high = mid - 1


        # def b_search_last(low, high, target):
        #     while low <= high:
        #         mid = int(low + ((high - low) / 2))
        #         if nums[mid] < target:
        #             low = mid + 1
        #         elif nums[mid] > target:
        #             high = mid - 1
        #         else:
        #             ans[-1] = mid
        #             low = mid + 1

        # b_search_first(low, high, target)
        # b_search_last(low, high, target)
        # return ans

        if not nums or (target < nums[0]) or target > nums[-1]:
            return [-1,-1]
        def b_search(low, high, target, bias):
            i = -1
            while low <= high:
                mid = (low + ((high - low) // 2))
                if nums[mid] < target:
                    low = mid + 1
                elif nums[mid] > target:
                    high = mid - 1
                else:
                    i = mid
                    if bias:
                        high = mid - 1
                    else:
                        low = mid + 1
            return i

        return [b_search(0, (len(nums) - 1), target, True), b_search(0, (len(nums) -1), target, False)]