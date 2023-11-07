package main

import "fmt"

func search(nums []int, target int) int {
	l, r := 0, len(nums)-1
	for l <= r {
		m := (l + r) / 2
		if nums[m] == target {
			return m
		}
		// fmt.Println(l, r, m)

		// 左から真ん中まできれいにならんでいるとしたとき
		if nums[l] <= nums[m] {
			if nums[l] <= target && target <= nums[m] {
				// その範疇に入っているなら
				r = m - 1
			} else {
				l = m + 1
			}
		} else {
			// 真ん中から右がきれいにならんでいるので
			if nums[m] <= target && target <= nums[r] {
				l = m + 1
			} else {
				r = m - 1
			}

		}
	}
	return -1
}

func main() {
	tests := []struct {
		nums   []int
		target int
		want   int
	}{
		{[]int{4, 5, 6, 7, 0, 1, 2}, 0, 4},
		{[]int{4, 5, 6, 7, 0, 1, 2}, 3, -1},
		{[]int{1}, 0, -1},
	}
	for i, t := range tests {
		got := search(t.nums, t.target)
		fmt.Printf("%d: want %v, got %v\n", i, t.want, got)
	}
}
