class Solution:
    def findMin(self, nums: List[int]) -> int:
        l, r = 0, len(nums)-1

        while l < r:
            mid = (l+r)//2

            # if nums[l]<nums[mid]:
            #     if nums[r] < nums[l]:
            #         l = mid + 1
            #     else:
            #         r = mid - 1
            # else:
            #     if nums[r] < nums[l]:
            #         r = mid - 1
            #     else:
            #         l = mid + 1

            if nums[mid] > nums[r]:
                l = mid + 1
            else:
                r = mid 
        
        return nums[l]
