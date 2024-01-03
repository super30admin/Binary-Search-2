#time complexity: O(log N)
#space complexity : O(1)
#submit on leetcode: yes


class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        def findFirstOccurrence(nums, target):
            low, high = 0, len(nums) - 1
            result = -1

            while low <= high:
                mid = low + (high - low) // 2

                if nums[mid] == target:
                    result = mid
                    high = mid - 1
                elif nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1

            return result

        def findLastOccurrence(nums, target):
            low, high = 0, len(nums) - 1
            result = -1

            while low <= high:
                mid = low + (high - low) // 2

                if nums[mid] == target:
                    result = mid
                    low = mid + 1
                elif nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1

            return result

        first_occurrence = findFirstOccurrence(nums, target)
        
        if first_occurrence == -1:
            return [-1, -1]

        last_occurrence = findLastOccurrence(nums, target)

        return [first_occurrence, last_occurrence]
        
        
sol = Solution()
nums = [5, 7, 7, 8, 8, 10]
target = 8
result = sol.searchRange(nums, target)
print(result)