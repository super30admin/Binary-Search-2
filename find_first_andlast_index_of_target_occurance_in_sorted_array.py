# Idea: We do two binary search here.
#       We basically want to find the first occurance in first binary search
#       Then find the second occurance using the firstIndex to the len of the array using
#       second Binary search.
#       core idea is when doing first binary search, if mid equals target, we check the left neighbor
#       if let neighbor is not equal to target or mid is at 0 index then it means its the first occurance.
#       similarly for second occurance we use the other binary search from first index to length of the array.
#       so when nums[mid] equals target we check if its the last occurance by seeing the right neighbor.
#       if right neighbor is not equal to target then its the last occurance since array is sorted.

#Time Complexity : O(log(n)) => log(n) + log(n) = 2*log(n) = O(log(n)).
#Space Complexity: O(1)

class Solution:
    def searchFirstAndLastIndices(self, nums: list, target: int) -> list:
        firstIndex = self.firstBinarySearch(nums, target, 0, len(nums) - 1)
        if firstIndex == -1:
            return [-1, -1]
        secondIndex = self.secondBinarySearch(nums, target, firstIndex, len(nums) - 1)
        return [firstIndex, secondIndex]

    def firstBinarySearch(self, nums, target, low, high):
        while(low <= high):
            mid = (low + high) // 2
            if nums[mid] == target:
                if mid == 0 or nums[mid - 1] != target:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def secondBinarySearch(self, nums, target, low, high):
        while(low <= high):
            mid = (low + high) // 2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid+1] != target:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1