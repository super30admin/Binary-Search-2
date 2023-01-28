class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        #peak item will be on the greater side 
        #if nums only has one element 
        if len(nums) == 1:
            return 0

        
        l = 0
        h = len(nums) - 1
        #[1,2]
        while l <= h:
            mid = l + (h-l) // 2 #mid = 0
            
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid

            #mid to the right is greater, so we go to right side
            elif nums[mid + 1] > nums[mid]:
                l = mid + 1
            #mid to the left is greater, so we go to left side
            elif nums[mid - 1] > nums[mid]:
                h = mid - 1