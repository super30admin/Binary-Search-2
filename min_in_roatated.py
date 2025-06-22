class Solution:
    def findMin(self, nums: List[int]) -> int:

        '''
        Using binary search

        Pseudocode:
        1. check if nums[low]<=nums[high]:
        return low

        2. If nums[mid]< nums[mid-1] and nums[mid]< nums[mid+1]
        return nums[mid]

        3. It was well noted, the min element lies in the unsorted array

        if(nums[mid]>=nums[low]):
            low = mid+1
        else:
            high = mid-1
        Time Complexity: O(log n)
        Space Complexity: O(1)

        '''


        low =0
        high = len(nums)-1

        while(low<=high):
            mid =(low+high)//2

            if(nums[low]<=nums[high]):
                return nums[low]


            elif ( (mid==0 or nums[mid]<nums[mid-1]) and (mid == len(nums)-1 or nums[mid]<nums[mid+1]) ):
                return nums[mid]


            elif(nums[mid]>=nums[low]):
                low = mid+1
            else:
                high = mid-1


