# we are using two functions one to find the first element
# another function to find last element. if first function found that there is the element present
# then it goes to second function to find last element

#tc: o(logn)
#sc:o(1)



class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        if nums == None or len(nums) == 0:
            return [-1, -1]

        def firstnumbernums(self, nums: list[int], target: int) -> int:
            low = 0
            high = len(nums) - 1

            while low <= high:
                mid = (low + high) // 2

                if target == nums[mid]:
                    if nums[mid - 1] < nums[mid] or nums[mid] == 0:
                        return mid
                    high = mid - 1

                else:
                    if target > nums[mid]:
                        low = mid + 1
                    else:
                        high = mid - 1
            return -1

        def secondnumbernums(self, nums: list[int], target: int) -> int:
            low = 0
            high - len(nums) - 1

            while low <= high:

                mid = (low + high) // 2

                if nums[mid] == target:
                    if nums[mid + 1] > nums[mid] or nums[mid] == high:
                        return mid
                    low = mid + 1

                else:
                    if nums[mid] < target:
                        low = mid + 1
                    else:
                        high = mid - 1
            return -1

            first = self.firstnumbernums(nums, target)
            if first == -1:
                return [-1, -1]
            second = self.secondnumbernums(nums, target)
            return [first, second]



