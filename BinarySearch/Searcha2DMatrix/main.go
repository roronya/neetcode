package main

import "fmt"

func searchMatrix(matrix [][]int, target int) bool {
	var list []int
	for _, row := range matrix {
		list = append(list, row...)
	}
	l := 0
	r := len(list) - 1
	for l <= r {
		t := (l + r) / 2
		if list[t] == target {
			return true
		}
		if list[t] < target { // 右を探索
			l = t + 1
		} else {
			r = t - 1
		}
	}
	return false
}
func main() {
	tests := []struct {
		matrix [][]int
		target int
		want   bool
	}{
		{
			[][]int{
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 60},
			},
			3,
			true,
		},
		{
			[][]int{
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 60},
			},
			13,
			false,
		},
		{
			[][]int{{1}},
			1,
			true,
		},
	}
	for i, t := range tests {
		got := searchMatrix(t.matrix, t.target)
		fmt.Printf("%d: want %v, got %v\n", i, t.want, got)
	}
}
