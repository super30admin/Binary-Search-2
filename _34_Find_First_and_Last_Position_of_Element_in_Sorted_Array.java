package Binary;

/**** Method 1 ****/
//Time Complexity: O(n)
//Space Complexity: O(1)

//Successfully submitted in LeetCode

// Take a loop and traverse all the elements in the array,and return the first index if the target is found and last the index.

/**** Method 2 ****/
//Time Complexity: O(logn)
//Space Complexity: O(1)

//Successfully submitted in LeetCode

// So we do two binary searches to find the first and last indexes,for the first index we modify the binary if target is found case to move left of the section so that if any more targets on present we can find them and for the last index we move to right to find the it's last occurrence.

/**** Method 1 ****/
public class _34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

  public int[] searchRange(int[] nums, int target) {
    int first = -1;
    int last = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        if (first == -1) {
          first = i;
        } else {
          last = i;
        }
      }
    }

    if (last == -1 && first != -1) {
      last = first;
    }

    return new int[] { first, last };
  }
}

/**** Method 2 ****/
public class _34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

  public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[] { -1, -1 };
    }

    int first = firstBS(nums, target, 0, nums.length - 1);
    if (first == -1) {
      return new int[] { -1, -1 };
    }

    int last = lastBS(nums, target, first, nums.length - 1);
    return new int[] { first, last };
  }

  public int firstBS(int nums[], int target, int i, int j) {
    int ans = -1;
    int lo = i;
    int hi = j;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] == target) {
        if (mid == 0 || (nums[mid - 1] != nums[mid])) {
          return mid;
        }
        ans = mid;
        hi = mid - 1;
      } else if (nums[mid] < target) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }

    return ans;
  }

  public int lastBS(int nums[], int target, int i, int j) {
    int ans = -1;
    int lo = i;
    int hi = j;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] == target) {
        if (mid == nums.length - 1 || (nums[mid] != nums[mid + 1])) return mid;

        ans = mid;
        lo = mid + 1;
      } else if (nums[mid] < target) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }

    return ans;
  }
}
