'''
34. Find First and Last Position of Element in Sorted Array
'''

# Time Complexity : O(log n) # Binary search ki wajah se time complexity O(log n) hai (due to binary search, the time complexity is O(log n))
# Space Complexity : O(1) # Space complexity O(1) hai kyunki hum sirf constant space use kar rahe hain (the space complexity is O(1) because we are using only constant space)
# Did you run the code on Leetcode : Yes
# Any problem you faced while coding this : Yes, it took some time to understand how indexes for first and last occurances are updated in the binary search functions for first and last occurrences  

# Your code here along with comments explaining your approach in three sentences only


class Solution: # humne ek class banayi for the solution (we created a class for the solution)
    def searchRange(self, nums: List[int], target: int) -> List[int]: # humne ek function banaya jo do parameters leta hai nums array aur target integer (we created a function that takes two parameters: nums array and target integer) 
        if not nums: # agar nums khali hai to hum -1, -1 return karte hain (if nums is empty, we return -1, -1)
            return [-1, -1] # returning -1, -1 if nums is empty
        
        # humne do helper functions banaye hain binary search ko use karke first aur last occurrence dhoondne ke liye (we created two helper functions using binary search to find the first and last occurrence)

        def find_first(): # humne first occurrence dhoondne ke liye function banaya (we created a function to find the first occurrence)
            low = 0 # first occurrence ke liye low ko 0 se shuru karte hain (we start low at 0 for the first occurrence)
            high = len(nums) - 1 # first occurrence ke liye high ko nums ki length - 1 se shuru karte hain (we start high at the length of nums - 1 for the first occurrence)
            first = -1 # first occurrence ko -1 se initialize karte hain kyunki agar target nahi milta to hum -1 return karenge (we initialize first occurrence to -1 because if the target is not found, we will return -1)
            while low <= high: # jab tak low high se chhota ya barabar hai tab tak loop chalta hai (the loop runs as long as low is less than or equal to high)
                mid = low + (high - low) // 2 # mid index ko calculate karte hain (we calculate the mid index)
                if nums[mid] == target: # agar mid index par target milta hai to hum first occurrence ko update karte hain (if the target is found at mid index, we update the first occurrence)
                    first = mid # first occurrence ko mid se update karte hain (we update first occurrence to mid)
                    high = mid - 1 # aur high ko mid - 1 se update karte hain taaki hum pehle occurrence ko dhoond sakein (and we update high to mid - 1 to search for the first occurrence)
                elif nums[mid] < target: # agar mid index par value target se chhoti hai to hum low ko mid + 1 se update karte hain (if the value at mid index is less than target, we update low to mid + 1)
                    low = mid + 1 # low ko mid + 1 se update karte hain (we update low to mid + 1)
                else: # agar mid index par value target se badi hai to hum high ko mid - 1 se update karte hain (if the value at mid index is greater than target, we update high to mid - 1)
                    high = mid - 1 # high ko mid - 1 se update karte hain (we update high to mid - 1)
            return first # first occurrence ko return karte hain (we return the first occurrence)

        def find_last(): # humne last occurrence dhoondne ke liye function banaya (we created a function to find the last occurrence)
            low = 0 # last occurrence ke liye low ko 0 se shuru karte hain (we start low at 0 for the last occurrence)
            high = len(nums) - 1 # last occurrence ke liye high ko nums ki length - 1 se shuru karte hain (we start high at the length of nums - 1 for the last occurrence)
            last = -1 # last occurrence ko -1 se initialize karte hain kyunki agar target nahi milta to hum -1 return karenge (we initialize last occurrence to -1 because if the target is not found, we will return -1)
            while low <= high: # jab tak low high se chhota ya barabar hai tab tak loop chalta hai (the loop runs as long as low is less than or equal to high)
                mid = low + (high - low) // 2 # mid index ko calculate karte hain (we calculate the mid index)
                if nums[mid] == target: # agar mid index par target milta hai to hum last occurrence ko update karte hain (if the target is found at mid index, we update the last occurrence)
                    last = mid # last occurrence ko mid se update karte hain (we update last occurrence to mid)
                    low = mid + 1 # aur low ko mid + 1 se update karte hain taaki hum last occurrence ko dhoond sakein (and we update low to mid + 1 to search for the last occurrence)
                elif nums[mid] < target: # agar mid index par value target se chhoti hai to hum low ko mid + 1 se update karte hain (if the value at mid index is less than target, we update low to mid + 1)
                    low = mid + 1 # low ko mid + 1 se update karte hain (we update low to mid + 1)
                else: # agar mid index par value target se badi hai to hum high ko mid - 1 se update karte hain (if the value at mid index is greater than target, we update high to mid - 1)
                    high = mid - 1 # high ko mid - 1 se update karte hain (we update high to mid - 1)
            return last # last occurrence ko return karte hain (we return the last occurrence)
        
        first_occurrence = find_first() # first occurrence ko find_first function se dhoondte hain (we find the first occurrence using the find_first function)
        if first_occurrence == -1: # agar first occurrence -1 hai to iska matlab target nahi mila, to hum -1, -1 return karte hain (if the first occurrence is -1, it means the target was not found, so we return -1, -1)
            return [-1, -1] # we return -1, -1 if the first occurrence is -1
        last_occurrence = find_last() # last occurrence ko find_last function se dhoondte hain (we find the last occurrence using the find_last function)

        return [first_occurrence, last_occurrence] # first aur last occurrence ko return karte hain (we return the first and last occurrence)