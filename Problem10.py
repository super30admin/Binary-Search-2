class Solution(object):
    def findPeakElement(self, nums):
       
        left, right = 0, len(nums) - 1

        while left < right:
            mid = left + (right - left) / 2
            if nums[mid] > nums[mid + 1]:
                right = mid
            else:
                left = mid + 1

        return left


if __name__ == "__main__":
   # print Solution().findPeakElement([1,2,1])
    print(Solution().findPeakElement([1,2,3,1]))