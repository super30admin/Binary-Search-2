class Solution(object):
    def searchRange(self, nums, target):

        def firstsearch(nums,target):
            l=0 
            h =len(nums) - 1
            index = -1
            while l <= h:
                mid_index = (l + h)// 2
                mid = nums[mid_index]
                if mid == target:
                    index = mid_index 
                    h = mid_index - 1
                elif mid < target:
                    l = mid_index + 1
                else:
                    h = mid_index - 1
            return index

        def secondsearch(nums,target):
            l=0 
            h =len(nums) - 1
            index = -1
            while l <= h:
                mid_index = (l + h)// 2
                mid = nums[mid_index]
                if mid == target:
                    index = mid_index
                    l = mid_index + 1
                elif mid < target:
                    l = mid_index + 1
                else:
                    h = mid_index - 1
            return index
            
        return [firstsearch(nums,target),secondsearch(nums,target)]




       
