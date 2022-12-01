# // Time Complexity : O(log(n))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach in three sentences only

class solution:
    def findFirst(self, low, high , k):
        ## we will try to find the the first occurance 

        while low<=high:
            mid = low + (high-low)//2
            # if our element is 0the first element in the array or the element is greater than the previous
            if ( input[mid] == k):
                if(mid == 0 or input[mid] > input[mid-1]):
                    return mid
            ## keep moving left
                else:
                    high = mid-1
            ## if the mid is greater than or equal to target, move high --> mid -1
            elif input[mid] > k:
                high = mid-1
                ## else move low --> mid+1
            else:
                low = mid+1

        return -1


    def findLast(self, low, high, k):

        low = 0 
        high = len(input)-1

        while low<=high:
            mid = low + (high-low)//2
            # if our element is the last element in the array or the element is smaller than the next
            if ( input[mid] == k):
                if (mid == len(input)-1 or input[mid] < input[mid+1]):
                    return mid
            
                else:
                    low = mid+1
            ## if the mid is strictly less than our element only then move low --> mid+1
            if input[mid]<= k:
                low = mid+1
                ## else move high to mid-1
            else:
                high = mid-1
        return -1



    def findPos(self, input, k ):

        if input[0] > k or input[-1] < k:
            return [-1,-1]

        first = self.findFirst(0, len(input)-1, k)
        if first == -1 : return [-1,-1]
        last = self.findLast(first, len(input)-1 , k)

        return [first, last]
