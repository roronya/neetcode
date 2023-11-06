package main

import "fmt"

func trap(height []int) int {
	// 左から舐めて壁の最大値を記録
	// 右からも同様に壁の最大値を記録
	// 2つの最大値のうち小さい方が水が貯まる容量
	right := make([]int, len(height))
	rmax := 0
	for i := 0; i < len(height); i++ {
		rmax = max(rmax, height[i])
		right[i] = rmax
	}
	left := make([]int, len(height))
	lmax := 0
	for i := len(height) - 1; i >= 0; i-- {
		lmax = max(lmax, height[i])
		left[i] = lmax
	}
	result := 0
	for i, h := range height {
		result += min(right[i], left[i]) - h
	}
	return result
}

func max(x int, y int) int {
	if x > y {
		return x
	}
	return y
}
func min(x int, y int) int {
	if x < y {
		return x
	}
	return y
}

func main() {
	tests := []struct {
		height []int
		want   int
	}{
		{[]int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6},
		{[]int{4, 2, 0, 3, 2, 5}, 9},
	}
	for i, t := range tests {
		got := trap(t.height)
		fmt.Printf("%d: want %v, got %v\n", i, t.want, got)
	}
}
