class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        #same like binary search we know that either of one side of the array is sorted
        #we first see if we have to traverse left or right.
        #so we compare the middle element and the last element 
       # ( actually in a regular sorted array, the middle elment is always smaller than the element)
        #now that its rotated,  if the middle element is less than the last element, we bring low=mid+1
        # say the array is [6,7,0,1,2,3,4,5] o/p=0
        #in the above case the array is rotated, but the middle elemnt(1) is not less than the last element(5)
        #hence we bring the high pinter to mid-1
        
        low=0
        high=len(nums)-1
        while(low<high):
            if nums[low]==nums[high]:
                return nums[low]
            mid=(low+high)//2
            if ((mid==0 or (nums[mid] < nums[mid-1])) and nums[mid] < nums[mid+1]):
                return nums[mid]
            else:
                if nums[mid]>nums[high]:
                    low=mid+1
                else:
                    high=mid-1
        return nums[low]
