package main

import (
	"fmt"
	"slices"
)

func threeSum(nums []int) [][]int {
	slices.Sort(nums)
	var result [][]int
	uniq := map[string]bool{}
	for i := 0; i < len(nums); i++ {
		// targetがniなnj,nkを探す
		ni := nums[i]
		m := map[int]int{} // nkを入れるとnjを返す
		for j := i + 1; j < len(nums); j++ {
			nj := nums[j]
			if nk, ok := m[nj]; ok {
				if uniq[fmt.Sprintf("%d-%d-%d", ni, nj, nk)] {
					continue
				}
				result = append(result, []int{ni, nj, nk})
				uniq[fmt.Sprintf("%d-%d-%d", ni, nj, nk)] = true
				continue
			}
			m[-ni-nj] = nj

		}
	}
	return result
}

func main() {
	tests := []struct {
		nums []int
		want [][]int
	}{
		{
			[]int{-1, 0, 1, 2, -1, -4},
			[][]int{
				{-1, -1, 2},
				{-1, 0, 1},
			},
		},
		{
			[]int{0, 1, 1},
			[][]int{},
		},
		{
			[]int{0, 0, 0},
			[][]int{{0, 0, 0}},
		},
	}
	for i, t := range tests {
		got := threeSum(t.nums)
		fmt.Printf("%d: want %v, got %v\n", i, t.want, got)
	}
}
