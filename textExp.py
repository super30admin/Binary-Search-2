"""
This problem has in my opinion a bit strange statement: it is not specified that we can not use already existing power or logarithm function, but I will consider, that we can not use them. Also in python numbers potentially can be very big or very close to zero, what should we do in these cases? You should ask you interviewer.

The main idea of solution is to use as much multiplications as possible, for example how can we evaluate x^20? We can just multiply x in loop 20 times, but we also can evaluate x^10 and multiply it by itself! Similarly, x^10 = x^5 * x^5. Now we have odd power, but it is not a problem, we evaluate x^5 = x^2 * x^2 * x. We also need to deal with some border cases, here is the full algorithm:

If we have very small value of x we can directly return 0, the smallest value of float is 1.175494 × 10^(-38).
If we have n = 0, return 1.
If we have negative power, return positive power of 1/x.
Now, we have two cases: for even and for odd n, where we evaluate power n//2.
Complexity: time complexity is O(log n), space complexity for this recursive algorithm is also O(log n), which can be reduced to O(1), if we use iterative approach instead.
"""

class Solution:
    def myPow(self, x, n):
        if abs(x) < 1e-40: return 0 
        if n == 0: return 1
        if n < 0: return self.myPow(1/x, -n)
        lower = self.myPow(x, n//2)
        if n % 2 == 0: return lower*lower
        if n % 2 == 1: return lower*lower*x

    def missingInt(arr):
        low, high = 0, len(arr) - 1

        while (low + 1 < high):
            mid = low + (high - low) // 2

            if arr[mid] == mid + 1:
                low = mid
            else:
                high = mid

        return arr[low] + 1

    arr = [1,2,3,5,6,7]
    print(missingInt(arr))