"""

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0
        h = len(nums) -1
        print("h=",h)
        while(l<=h):
            mid = l +(h-l)//2
            print ("mid=",mid)
            if (mid == 0 or (nums[mid] > nums[mid -1])) and ((mid == len(nums)-1) or (nums[mid] > nums[mid +1])):

                return mid
            elif nums[mid]<nums[mid +1]:
                l = mid +1
                print("l=",l)
            elif nums[mid]> nums[mid+1]:
                h = mid -1
                print("h=",h)
            else:
                return -1
