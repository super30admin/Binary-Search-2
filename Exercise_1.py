# Time Complexity: O(log n)
# Space Complexity: O(1)
# Were you able to run the code on Leetcode: Yes
# Any problem you faced while coding this: The logic for the 0th index and last index was confusing, had to rewatch the video to understand it better

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        if not nums or len(nums)==0:
            return [-1,-1]
 

        first = self.binary_search_first(nums, target)
        if first == -1:
            # if first is not found, then target is not present in the list and shoudl return -1,-1
            return [-1, -1]

        second = self.binary_search_last(nums, target)

        return [first,second]

        
    def binary_search_first(self, nums, target) -> int:
        low = 0
        high = len(nums)-1

        #TOD add high and low check if all nums are same
        if nums[low] == nums[high] and nums[low] == target:
            return low

        while( low <= high):
            mid = low+(high-low)//2

            
            if nums[mid] == target:
                # only if mid element is equal to target
                # first check if mid and low index are equal, if it is the 0th index then return mid as required index
                # check the left element and if not equal then mid element is required index
                if mid == low or nums[mid-1] != nums[mid]:
                    return mid
                # else continue binary search on left half
                high = mid - 1
                     
            elif nums[mid] > target:
                # if  mid element is greater than target, then search left half
                high = mid - 1

            elif nums[mid] < target:
                # if  mid element is lesser than target, then search right half
                low = mid + 1
        # target not found in list
        return -1
            
    def binary_search_last(self, nums, target) -> int:
        low = 0
        high = len(nums)-1

        #TOD add high and low check if all nums are same
        if nums[low] == nums[high] and nums[low] == target:
            return high

        while( low <= high):
            mid = low+(high-low)//2

            if nums[mid] == target:
                # only if mid element is equal to target
                # first check if mid and high index are equal, if it is the last index then return mid as required index
                # check the right element and if not equal then mid element is required index
                if mid == high or nums[mid+1] != nums[mid]:
                    return mid
                # continue binary search on right side
                low = mid + 1
                     
            elif nums[mid] > target:
                # if  mid element is greater than target, then search left half
                high = mid - 1

            elif nums[mid] < target:
                # if  mid element is lesser than target, then search right half
                low = mid + 1
        # target not found in list
        return -1


                

            

            




        
        