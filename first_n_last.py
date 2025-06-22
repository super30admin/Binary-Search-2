class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        '''
        Appproach : Run two binary searches
        1. First to identify the first position of the target.
        2. Last to identify the last position of the target.
        Time Complexity: O(log n)
        Space Complexity: O(1)
        '''

        #  First Binary search to find first index of the target

        low =0
        high = len(nums)-1
        first  = float('inf')


        while(low<=high):

            mid = (low+high)//2

            '''
            This is to ensure that if you find the target
            You are making sure that if it is the first occurence
            If Yes, you are breaking the loop and get the value of the first.
            '''

            if(nums[mid]==target):
                if(mid ==0  or nums[mid-1]!=target):
                    first = mid
                    break
                else:
                    high = mid-1


            elif((nums[mid]>target)):
                high = mid-1

            else:
                low= mid+1
        if(first == float('inf')):
            first =-1


        # Second Binary search to find first index of the target

        low =0
        high = len(nums)-1
        last = float('inf')

        while(low<=high):

            mid = (low+high)//2

            '''
            This is to ensure that if you find the target
            You are making sure that if it is the last occurence
            If Yes, you are breaking the loop and get the value of the last.
            '''
            if(nums[mid]==target):
                if ( mid == len(nums)-1 or nums[mid+1]!=target):
                    last = mid
                    break
                else:
                    low = mid+1

            elif(nums[mid]<target):
                low = mid+1

            else:
                high= mid-1
        if(last == float('inf')):
            last =-1



        return [first, last]
