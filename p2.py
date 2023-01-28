class Solution:
    def findMin(self, nums: List[int]) -> int:
        #min element will always be at unsorted side

        #array only has one element
        if len(nums) == 1:
            return nums[0]
        
        l = 0
        h = len(nums) - 1
        
        while l <= h:
            mid = l + (h - l) // 2
            #array rotated back to its original, sorted 
            if nums[l] < nums[h]:
                return nums[l]

            #if mid is last index, and its the min 
            if (mid == 0 or nums[mid] < nums[mid - 1] ) and (mid == len(nums) - 1 or nums[mid] < nums[mid + 1 ]):
                return nums[mid]
            #current left is sorted
            elif nums[mid] >= nums[0]:
                l = mid + 1
            #current right is sorted
            else:
                h = mid - 1

        return -1
           