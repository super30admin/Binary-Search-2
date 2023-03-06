# Time Complexity:- O(logn) Amortized
class Solution(object):
    
    def binary_search(self, arr, low, high, target, check_left):
        i= -1
        while high>=low:
            mid= (low + high)//2
            
            if arr[mid]==target:
                i= mid
                if check_left:
                    # Check left array for a samilar element.
                    
                    high= mid-1
                else:
                    # Check the right array for a similar such element.
                    low= mid+1               


            elif arr[mid]<target:
                low= mid+1
            else:
                high= mid-1
        return i

    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if len(nums)==1:
            if target in nums:
                return [0,0]
        
        check_left= self.binary_search(nums, 0, len(nums)-1, target, True)
        check_right= self.binary_search(nums, 0, len(nums)-1, target, False)
        return [check_left, check_right]