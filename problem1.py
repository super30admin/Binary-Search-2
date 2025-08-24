"""
Space Complexity: O(1) No extra memory allocation 
Time Complexity: O(2 * log(n)): We use two passes of binary searches to find the first  and the last index of the target in our code. 
"""

class Solution:
    """
    This code is the first binary search. We pass in relevant parameters. 
    """
    def firstBinarySearch(self, nums, target, low, high): 
        while low <= high: 
            mid = low + (high - low)//2
            # print(low, mid, high)
            # Check if the element is target
            if nums[mid] == target: 
                # if yes, check if its the left most occurence. If yes, return it. Else, reduce the search 
                # space by half and move high to mid -1
                if mid == 0 or nums[mid-1] < nums[mid]: 
                    return mid
                else: 
                    high = mid - 1
            # If you dont find the target, and if mid is greater, move high to mid - 1
            elif nums[mid] > target: 
                high = mid - 1
            # Else move low to mid + 1

            else: 
                low = mid + 1
            # print(low, mid, high)

        return -1

    def secondBinarySearch(self, nums, target, low, high): 
        """
        Second binary seaech is similar to first binary search, just check for last occurence
        """
        while low <= high: 
            mid = low + (high - low)//2

            if nums[mid] == target: 
                if mid == len(nums)-1 or nums[mid+1] > nums[mid]: 
                    # print("HERE")
                    return mid
                else: 
                    low = mid + 1

            elif nums[mid] > target: 
                high = mid - 1
            else: 
                low = mid + 1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0: return [-1, -1]
        p1 = self.firstBinarySearch(nums, target, 0, len(nums)-1)
        # print("THIS IS P1: ", p1)
        # Optmimization: Check for second index, after the first index. 
        p2 = self.secondBinarySearch(nums, target, p1, len(nums)-1)
        # print("THIS IS P2: ", p2)
        

        return [p1, p2]
