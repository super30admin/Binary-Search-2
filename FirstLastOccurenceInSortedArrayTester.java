public class FirstLastOccurenceInSortedArrayTester {
    public static void main(String[] args) {
        FirstLastOccurenceInSortedArray obj = new FirstLastOccurenceInSortedArray();

        int[] nums = { 8, 8, 8 };

        int[] result = obj.searchRange(nums, 8);

        System.out.println("First:" + result[0] + " Second:" + result[1]);
    }
}
