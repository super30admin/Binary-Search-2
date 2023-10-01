class Solution:
        """
        Time Complexity: O(log(n))
        Space Complexity: O(1)

        Did this code successfully run on Leetcode: Yes 

        Any problem you faced while coding this:
        not really, I forgot the empty list edge case

        Your code here along with comments explaining your approach:
        The approach: 
            -> Perform Binary Search to find the first element of the target value 
            -> for the edge case where the list is empty, return [-1 , -1]
            -> if you find mid == target then check if it's the first element by comparing
            it with the previous value. If it's different then previous value then return
            that mid value. if not then make the high = mid -1 
            -> similarly do it for the last index of the target value
            -> once you find both the first and last index. return those index
        """

    def binarySearchFirst(self, nums, low, high, target):
        while (low <= high):
            mid = int(low + (high - low)/2)
            if (target == nums[mid]):
                if (mid == 0 or nums[mid-1] < nums[mid]):
                    return mid
                else:
                    high = mid - 1 
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
    
    def binarySearchLast(self, nums, low, high, target):
        while (low <= high):
            mid = int(low + (high - low)/2)
            print (mid)
            if (target == nums[mid]):
                if (mid == len(nums) - 1 or nums[mid+1] > nums[mid]):
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        low = 0
        high = len(nums) - 1

        if len(nums) == 0:
            return [-1, -1]

        first = self.binarySearchFirst(nums, low, high, target)
        last = self.binarySearchLast(nums, first, high, target)

        return [first, last]
        
    