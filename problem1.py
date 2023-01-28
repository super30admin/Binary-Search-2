class Solution:
   
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        #array is empty
        if len(nums) == 0:
            return [-1, -1]
        #taget is not in the range 
        if target < nums[0] or target > nums[-1]:
            return [-1, -1]
        
        #function to find the first position 
        def first(nums,target):
            l = 0
            h = len(nums) - 1
            while l <= h:
                mid = l + (h - l) // 2
                if nums[mid] == target:
                    #nums[mid] is the index 0 value
                    if mid == 0:
                        return mid 
                    elif nums[mid - 1] < nums[mid]:
                        return mid 
                    #nums[mid]'s value is target but it's not first occurence
                    #so we do h = mid - 1
                    else:
                        h = mid - 1
                elif nums[mid] > target:
                    h = mid - 1
                elif nums[mid] < target:
                    l = mid + 1
            return -1 

        def last(nums,target):
            l = 0
            h = len(nums) - 1
            while l <= h:
                mid = l + (h - l) // 2
                if nums[mid] == target:
                    #nums[mid] is the last indexvalue
                    if mid == len(nums) - 1:
                        return mid 
                    elif nums[mid + 1] > nums[mid]:
                        return mid 
                    else:
                        l = mid + 1
                elif nums[mid] > target:
                    h = mid - 1
                elif nums[mid] < target:
                    l = mid + 1
            return -1 

        first = first(nums, target)
        last = last(nums, target)

        return [first, last]