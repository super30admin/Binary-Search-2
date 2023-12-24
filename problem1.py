""" The problem uses two separate binary seaches to locate the first and the last occurance of the 
    element. The first binary search finds the target to the left most of the array, and the second
    binary search finds the target to the right most of the array.
    Time Complexcity: O(log n) + O(log n) = 2*O(log n) = O(log n) since 2 is a constant
    Space Complexcity: O(1)
"""



class Solution(object):
    
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def search_first_occurance(target, nums ,n):
            low = 0
            high = n-1
            while(low <= high):
                mid = low + (high - low)//2

                if(nums[mid] == target):
                    if(mid == 0 or nums[mid] > nums[mid - 1]):
                        return mid
                    else:
                        high = mid - 1
                elif (nums[mid] > target):
                    high = mid - 1
                else:
                    low = mid + 1
            return -1
    
        def search_last_occurance(target, nums ,n):
            low = 0
            high = n-1
            while(low <= high):
                mid = low + (high - low)//2

                if(nums[mid] == target):
                    if(mid == n-1 or nums[mid] < nums[mid + 1]):
                        return mid
                    else:
                        low = mid + 1
                elif (nums[mid] < target):
                    low = mid + 1
                else:
                    high = mid - 1
            return -1


        n = len(nums)
        first = search_first_occurance(target, nums ,n)
        last = search_last_occurance(target, nums ,n)
        return [first,last]
        