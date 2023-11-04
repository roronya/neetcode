package main

import "fmt"

// ナイーブにやるとこう
func twoSumNaive(nums []int, target int) []int {
	for i := 0; i < len(nums); i++ {
		for j := 0; j < len(nums); j++ {
			if i == j {
				continue
			}
			if target == nums[i]+nums[j] {
				return []int{i, j}
			}
		}
	}
	return nil
}

func twoSum(nums []int, target int) []int {
	// nums[j] = target - nums[i] であるから
	// target-nums[i]の結果をメモしておいて、一度の走査で済むかもしれない
	// indexを返したいからindexをメモしておくような配列を用意すると良さそう
	// map[target-nums[i]] => iが返ってくるようにしておいて
	// 走査の中でmap[j]でアクセスしてみてiが返ってくるか調べる
	m := map[int]int{}
	for i, n := range nums {
		if v, ok := m[n]; ok {
			return []int{v, i}
		}
		m[target-n] = i
	}
	return nil
}

func main() {
	tests := []struct {
		nums   []int
		target int
		want   []int
	}{
		{[]int{2, 7, 11, 15}, 9, []int{0, 1}},
		{[]int{3, 2, 4}, 6, []int{1, 2}},
		{[]int{3, 3}, 6, []int{0, 1}},
	}
	for _, t := range tests {
		got := twoSum(t.nums, t.target)
		if len(t.want) != len(got) {
			fmt.Printf("want %v, but got %v\n", t.want, got)
			continue
		}
		for i := 0; i < len(got); i++ {
			if got[i] != t.want[i] {
				fmt.Printf("want %v, but got %v\n", t.want, got)
			}
		}
	}
}
