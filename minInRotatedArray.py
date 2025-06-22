# time taken to solve is 23 mins

class Solution:
    def findMin(self, nums: List[int]) -> int:
        start = 0
        end = len(nums) - 1
        while start <= end:
            mid = start + (end-start)//2
            # end condition 1
            if (mid ==0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid] < nums[mid+1]):
                return nums[mid]
            
            # check which side is sorted. Min is guarenteed to be on the unsorted side.
            # if both side are sorted, start is the answer
            # end condition 2
            if nums[start] <= nums [mid] and nums[mid] <= nums[end]:
                return nums[start]

            # decision 1
            if nums[start] <= nums[mid]:
                start = mid+1
            # decision 2
            else:
                end = mid -1