import java.util.Arrays;

public class TestBinarySearch2 {
    public static void main(String[] args) {
        FirstAndLastElementPositionInSortedArray rangeSolver =
                new FirstAndLastElementPositionInSortedArray();
        int[] result = rangeSolver.searchRange( new int[]{5,7,7,8,8,10}, 8);
        System.out.println(Arrays.toString(result));
        MinInRotatedSortedArray minSolver = new MinInRotatedSortedArray();
        int minElement = minSolver.findMin( new int[]{3,4,5,1,2});
        System.out.println("Minimum element in Rotated Sorted Array - " +minElement);
        PeakElement element = new PeakElement();
        int peakElement = element.findPeakElement( new int[]{1,2,1,3,5,6,4});
        System.out.println("Index of a peak element in an Array - " +peakElement);
    }
}
