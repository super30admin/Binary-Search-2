# Explain your approach in **three sentences only** at top of your code
# 1) check if array is alreay sorted by comparing arr[low] <= arr[high] 
# 2) check if the mid element is the min compare with mid-1 and mid+1 ensure not going out of bound (we can reject comparing with mid+1) since we already checked it with high
# 3) get mid and if arr[mid] > arr[l] means left is sorted and pivot will be in right half so reject left half and bs on right(cause u rotated at pivot so it can never be in the sorted hlaf)

from typing import List
class Solution:
    def findMin(self, nums: List[int]) -> int:
        l,h = 0,len(nums)-1
        while l<=h:
            if nums[l]<=nums[h]:
                return nums[l]
            mid = l + (h-l)//2
            if (mid!= 0 and nums[mid-1] > nums[mid]) and ((mid!=len(nums)-1) and nums[mid]<nums[mid+1]):
                return nums[mid]
            elif nums[l] <= nums[mid]:
                l = mid+1
            else:
                h = mid-1

# OR we can do 
# class Solution:
#     def findMin(self, nums: List[int]) -> int:
#         l,h=0,len(nums)-1
#         while(l<=h):
#             mid = l + (h-l)//2
#             # already sorted 
#             if nums[l] <= nums[h]:
#                 return nums[l]
#             # if middle is the min check that -> cause can be pivot because of rotates
#             if (mid!=0 and nums[mid] < nums[mid-1]):
#                 return nums[mid]
#             elif nums[l] <= nums[mid]:
#                 l = mid+1
#             else:
#                 h = mid -1
#         return -1

        