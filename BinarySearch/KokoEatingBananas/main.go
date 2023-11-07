package main

import (
	"fmt"
	"math"
)

// 1 <= piles.length <= 10^4
// piles.length <= h <= 10^9
// 1 <= piles[i] <= 10^9
// piles.length <= 10^4だからO(n^2)でも良さそう
func minEatingSpeed(piles []int, h int) int {
	// 配列の中の最小と最大の中から適当な値を見つけるかな
	// たとえば最初の例なら3が最小値で11が最大値だから真ん中から初めて、h=8を満たすkを探せそう
	lmax := piles[0]
	for _, p := range piles {
		lmax = max(lmax, p)
	}
	lmin := 1
	// fmt.Println(lmin, lmax, sum)

	result := math.MaxInt32
	for lmin <= lmax {
		k := (lmin + lmax) / 2
		lh := 0
		for _, p := range piles {
			lh += p / k
			if p%k != 0 {
				lh += 1
			}
			// lh += math.Ceil(float64(p) / float64(k))
		}
		if int(lh) <= h {
			result = min(result, k)
		}
		// fmt.Println(lmin, lmax, lh, k, result)
		if int(lh) > h { // 急いで食べないといけない
			lmin = k + 1
		} else { // ゆっくり食べて良い
			lmax = k - 1
		}
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
		piles []int
		h     int
		want  int
	}{
		{[]int{3, 6, 7, 11}, 8, 4},
		{[]int{30, 11, 23, 4, 20}, 5, 30},
		{[]int{30, 11, 23, 4, 20}, 6, 23},
		{[]int{312884470}, 312884469, 2},
		{[]int{312884470}, 968709470, 1},
		{[]int{2, 2}, 2, 2},
	}
	for i, t := range tests {
		got := minEatingSpeed(t.piles, t.h)
		fmt.Printf("%d: want %v, got %v\n", i, t.want, got)
	}
}
