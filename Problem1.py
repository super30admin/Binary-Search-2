# T.C : O(logn)
# S.C : O(1)

'''
Approach: Divides the processing. Here we check the mid element with other element to ensure it's first and once that's done we check the mid element with element afterwards to ensure it's last.
'''

class Solution:
    def binsearchfirst(self, nums, low, high, target):

        while low <= high:
            mid = (low + high)//2

            if nums[mid] == target:
                #Checks if mid is first occurence
                if mid == 0 or nums[mid] > nums[mid - 1]:
                    return mid
                else:
                    high = mid - 1

            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
               
        return -1

    def binsearchlast(self, nums, low, high, target):
        while low <= high:
            mid = (low + high)//2

            if nums[mid] == target:
                #checks if mid is last occurence
                if mid == high or nums[mid] < nums[mid + 1]:
                    return mid
                else:
                    low = mid + 1
                    
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
            
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums is None or len(nums) == 0:
            return [-1, -1]
        n = len(nums)
        first = self.binsearchfirst(nums, 0, n - 1, target)
        if first == -1:
            return [-1, -1]
        last = self.binsearchlast(nums, first, n - 1, target)
        return [first, last]
