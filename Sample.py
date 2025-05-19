# Problem 1: Finding first and last index of target from sorted array
# Two binary searches, one for first index, other for last index.

# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l=0
        h=len(nums)-1
        fi=li=-1

        while l<=h:
            mid=l+(h-l)//2
            if nums[mid]==target:
                if mid==0 or nums[mid-1]!=target:
                    fi=mid
                    break
                else:
                    h=mid-1
            elif nums[mid] < target:
                l=mid+1
            else:
                h=mid-1
        
        if fi!=-1:
            l=fi
            h=len(nums)-1
            while l<=h:
                mid=l+(h-l)//2
                if nums[mid]==target:
                    if mid==len(nums)-1 or nums[mid+1]!=target:
                        li=mid
                        break
                    else:
                        l=mid+1
                else: #nums[mid] > target:
                    h=mid-1
        
        return [fi,li]

                


# Problem 2: Finding minimum element from rotated sorted array
# Minimum element is always the point which divides the rotated array into two parts. So here im checking if the mid element is lesser than the last element in the array, if so store its index as a potential candidate and move to the left to see if there are any smaller elements.

# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findMin(self, nums: List[int]) -> int:
        l=0
        h=len(nums)-1
        mx=-1
        while l<=h:
            mid=l+(h-l)//2

            if nums[mid] <= nums[-1]:
                mx=mid
                h=mid-1
            else:
                l=mid+1
        
        return nums[mx]



# Problem 3: Finding peak element in an array
# Used binary search, and when mid is peak, return mid. If not, check greater neighbour than mid and shift range to that side and repeat.
# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l=0
        h=len(nums)-1

        while l<=h:
            mid=l+(h-l)//2

            if ((nums[mid]> nums[mid-1] or mid==0) and (mid == len(nums)-1 or nums[mid] > nums[mid+1])):
                return mid
            else:
                if mid!=0 and nums[mid-1] > nums[mid]:
                    h=mid-1
                
                else:
                    l=mid+1