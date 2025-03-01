package neetcode.binary_search.median_of_two_sorted_arrays;

import java.util.Arrays;

public class Solution {
    // Your solution must run in O(log(m+n)) time.
    // You should aim for a solution with O(log(min(n, m))) time and O(1) space,
    // where n is the size of nums1 and m is the size of nums2.
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return optimal(nums1, nums2);
    }

    /**
     * medianは真ん中の2つの数字だけわかればよい => O(
     * 最大値と最小値を削除していけばmedianだけ残る => O(nlogn + mlogm) => quick sortしているのと同義
     * n1:[1,2,3] n2:[3,4,5] => n1の要素がn2のどこに挿入されるか O(n*logm) 挿入ソートの最効率計算量かも
     * medianの定義ができればBinarySearchで探せそうではある
     */
    double optimal(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        int total = A.length + B.length;
        int half = (total + 1) / 2;

        if (B.length < A.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int l = 0;
        int r = A.length;
        while (l <= r) {
            int i = (l + r) / 2;
            int j = half - i;

            int Aleft = i > 0 ? A[i - 1] : Integer.MIN_VALUE;
            int Aright = i < A.length ? A[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            int Bright = j < B.length ? B[j] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 != 0) return Math.max(Aleft, Bleft);
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bleft) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return -1;
    }

    /**
     * nums1とnum2を結合させてsortしてmedianとったら終わり
     * O(m+n)
     */
    double myFindMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) a[k++] = nums1[i++];
            else a[k++] = nums2[j++];
        }
        while (i < nums1.length) a[k++] = nums1[i++];
        while (j < nums2.length) a[k++] = nums2[j++];
        System.out.println(Arrays.toString(a));
        return a.length % 2 == 0 ? (a[a.length / 2 - 1] + a[a.length / 2]) / 2.0 : a[a.length / 2];
    }
}
