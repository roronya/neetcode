package main

import "fmt"

// O(n)
// 0 <= nums.length <= 10^5
// -10^9 <= nums[i] <= 10^9
func longestConsecutive(nums []int) int {
	// 明示的にソートするのでなくて、配列に突っ込むことでソートするやつかも
	// nums[i]をindexにした配列を作ればよいかなと思ったけど、
	// そうするとmake([]int, 2*(10^9))が必要で
	// それはメモリを食いすぎる
	// consecutiveの定義は…
	// num[i] = num[i-1] + 1 or num[i+1] = num[i] - 1
	// 降順昇順関係なく周りの数字が現れているかどうか
	// 一度目のループで出現表を作って
	// 二度目のループでその数字から出現表を舐めて、無いところまでループして数える
	m := map[int]bool{}
	for _, n := range nums {
		m[n] = true
	}

	result := 0
	for _, n := range nums {
		// n-1があるなら、n-1から探索したほうがlengthが長くなるから、ここは探索しなくてよい
		if m[n-1] {
			continue
		}

		temp := n + 1
		length := 1
		for m[temp] {
			temp++
			length++
		}
		if length > result {
			result = length
		}
	}
	return result
}

func main() {
	tests := []struct {
		nums []int
		want int
	}{
		{
			[]int{100, 4, 200, 1, 3, 2},
			4,
		},
		{
			[]int{0, 3, 7, 2, 5, 8, 4, 6, 0, 1},
			9,
		},
	}

	for _, t := range tests {
		got := longestConsecutive(t.nums)
		fmt.Printf("want %v, got %v\n", t.want, got)
	}
}
