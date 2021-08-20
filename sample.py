class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        returnList = [-1,-1]
        if Solution.searchRangeHelper(0,len(nums)-1,nums,target) == -1:
            return returnList
        else:
            m = Solution.searchRangeHelper(0,len(nums)-1,nums,target)
            for i in range(m+1):
                if nums[i] == target:
                    returnList[0] = i
                    break
            for i in range(m,len(nums)):
                if nums[i] == target:
                    returnList[1] =i
            return returnList

    def searchRangeHelper (left: int, right: int, nums: list[int], target: int):

        if right >= left:
            mid = left + (right - left) // 2

            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                return Solution.searchRangeHelper(left, mid-1, nums, target)
            else:
                return Solution.searchRangeHelper(mid+1, right, nums, target)

        else:
            return -1