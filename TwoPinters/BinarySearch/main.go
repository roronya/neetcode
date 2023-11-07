package main

import "fmt"

func search(nums []int, target int) int {
	l := 0
	r := len(nums) - 1 // lと意味合いを合わせるために-1をする
	for l <= r {       // lとrを動かしていくから、その意味合いから外れるところまで動いたら探索を終える
		m := (l + r) / 2
		if nums[m] == target {
			return m
		}
		if nums[m] < target { // 右を探索
			l = m + 1 // target[m]はもう見たから+1で探索対象から外す
		} else { // 左を探索
			r = m - 1
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
		{[]int{-1, 0, 3, 5, 9, 12}, 9, 4},
		{[]int{-1, 0, 3, 5, 9, 12}, 2, -1},
		{[]int{2, 5}, 2, 0},
		{[]int{-1, 0, 5}, 5, 2},
	}

	for i, t := range tests {
		got := search(t.nums, t.target)
		fmt.Printf("%d: want %v, got %v\n", i, t.want, got)
	}
}
