"""
Rasika Sasturkar
Time Complexity: O(logn)
Space Complexity: O(1)
"""


def findPeakElement(nums) -> int:
    """
    To get the peak element, optimal solution is binary search.
    We check id our mid-element is peak, if yes we return mid.
    Or we move to that side of mid which is greater than mid.
    If both previous and next elements are greater than mid-element,
    we can move to either side as it will always give us peak element.
    """
    if nums is None or len(nums) == 0:
        return -1
    n = len(nums)
    low = 0
    high = n - 1

    while low <= high:
        mid = low + (high - low) // 2
        if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == n - 1 or nums[mid] > nums[mid + 1]):
            return mid
        elif mid > 0 and nums[mid] < nums[mid - 1]:
            high = mid - 1
        else:
            low = mid + 1
    return -1


def main():
    """
    Main function - an example from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    nums = [1, 2, 1, 3, 5, 6, 4]
    print(findPeakElement(nums))  # returns index 5 where peak element is 6


if __name__ == "__main__":
    main()
