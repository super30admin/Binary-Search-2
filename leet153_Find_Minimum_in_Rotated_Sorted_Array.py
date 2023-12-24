# Solution
# // Time Complexity : O(log(n))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Approach is to understand that if the entire array is sorted, then nums[0]<nums[last], then we can just take nums[0] as answer
# if not then we can apply binary search. Find mid, check if nums[mid]>nums[low], if this is valid then left side of array is sorted
# since the whole array is rotated and left side is sorted, minimum will be in the right side. So we navigate to right side by
# ignoring left side, else we go to left side ignoring the right side. if low and high are equal then we have reached the point
# where we find the lowest number

def findMin(nums):
        # Revisted on 12/23/2023(Implemented the editorial solution)
        start = 0
        end = len(nums)-1

        if nums[start] <= nums[end]:
            return nums[start]

        while start<=end:
            mid = (start+end)//2
            if (nums[mid] < nums[mid-1]):
                return(nums[mid])
            elif nums[mid] > nums[mid+1]:
                return nums[mid+1]
            
            if nums[mid]>=nums[start]:
                start = mid+1
            else:
                end = mid-1

if __name__ == "__main__":
     nums = [4,5,6,7,0,1,2]
     print(findMin(nums))