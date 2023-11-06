package main

import (
	"fmt"
	"math"
)

func maxArea_TLE(height []int) int {
	// 普通に2重ループ回したらTLEだった
	result := 0.0
	for i := 0; i < len(height)-1; i++ {
		for j := i + 1; j < len(height); j++ {
			h := math.Min(float64(height[i]), float64(height[j]))
			w := float64(j - i)
			result = math.Max(h*w, result)
		}
	}
	return int(result)
}

func maxArea(height []int) int {
	// 一番高いやつ2つに囲まれたところがたくさん水が入るという直感と
	// 背が低くても横に長ければ↑よりもたくさん入るだろうという懸念がある
	// これを両方探索するには両端から段々狭めていくという貪欲法
	result := 0
	left := 0
	right := len(height) - 1
	for left < right {
		result = max(result, (right-left)*min(height[left], height[right]))
		if height[left] < height[right] {
			left++
		} else {
			right--
		}
	}
	return result
}

func min(x int, y int) int {
	if x > y {
		return y
	}
	return x
}

func max(x int, y int) int {
	if x > y {
		return x
	}
	return y
}

func main() {
	tests := []struct {
		height []int
		want   int
	}{
		{[]int{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49},
		{[]int{1, 1}, 1},
		{[]int{1, 2, 1}, 2},
	}
	for i, t := range tests {
		got := maxArea(t.height)
		fmt.Printf("%d: want %v, got %v\n", i, t.want, got)
	}

}
