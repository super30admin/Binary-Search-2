# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  yes
# Any problem you faced while coding this : no


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        # to find the first occurence
        first = self.firsTarget(nums, target, 0, len(nums) - 1)
        # to find the second occurence
        second = self.secondTarget(nums, target, 0, len(nums) - 1)

        return [first, second]

    def firsTarget(self, nums, target, left, right) -> int:

        # loop all elements
        while (left <= right):

            # calculate mid - this way prevents the overflow
            mid = left + (right - left) // 2

            # If we find target, then we proceed to find whethere it is first occurence
            if nums[mid] == target:

                # if mid is the first element then obviously it is the first occurence. if the previuos element of
                # the mid is less than target it means no other occurence, so we return mid
                if mid == 0 or nums[mid - 1] < target:
                    return mid
                else:
                    # other wise we will make the right move towards the mid so we move towards the previous occurences.
                    right = mid - 1

            else:

                # if element not found we will check if the target is lower or greater, if low we move right, if high we move left
                if nums[mid] > target:

                    right = mid - 1

                else:

                    left = mid + 1

        return -1

    def secondTarget(self, nums, target, left, right) -> int:
        # loop all elements
        while (left <= right):

            # calculatek, mid - this way prevents the overflow
            mid = left + (right - left) // 2

            if nums[mid] == target:
                # if mid is the last element then obviously it is the last occurence. if the next element of the mid is greater than target it means no other occurence, so we return mid
                if mid == len(nums) - 1 or nums[mid + 1] > target:

                    return mid
                else:
                    # other wise we will make the left move towards the mid so we move towards the next occurences.
                    left = mid + 1


            else:
                # if element not found we will check if the target is lower or greater, if low we move right, if high we move left
                if nums[mid] > target:

                    right = mid - 1

                else:

                    left = mid + 1

        return -1
