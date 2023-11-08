package main

import "fmt"

// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -10^6 <= nums1[i], nums2[i] <= 10^6

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	// 中央値というのが、真ん中を区切りにして左と右に分けて左の最大値と右の最小値から成ると考える
	// とりあえずはnums1の中央値が左の最大値、右の最小値だとして…
	// nums2
}

func median(nums []int) float64 {
	if len(nums)%2 == 0 {
		return (float64(nums[len(nums)/2]) + float64(nums[(len(nums)/2)-1])) / 2.0
	}
	return float64(nums[len(nums)/2])
}

func main() {
	tests := []struct {
		nums1 []int
		nums2 []int
		want  float64
	}{
		{
			[]int{1, 3},
			[]int{2},
			2.0,
		},
		{
			[]int{1, 2},
			[]int{3, 4},
			2.5,
		},
	}
	for i, t := range tests {
		got := findMedianSortedArrays(t.nums1, t.nums2)
		fmt.Printf("%d: want %v, got %v\n", i, t.want, got)

	}

}
