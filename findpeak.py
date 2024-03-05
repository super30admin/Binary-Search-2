## Time complexity is O(logN) and space complexity is O(1)
class FindPeakElement:
    def findPeak(self, nums):
        l =0
        r = len(nums)-1
        
        while l <=r:
            mid = l + (r-l)//2
            if mid > 0 and nums[mid] < nums[mid-1]:
                r = mid-1
                
            elif mid < len(nums) - 1 and nums[mid+1]> nums[mid]:
                l = mid +1
            else:
                return mid
        return -1