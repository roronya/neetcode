package main

import "fmt"

// O(n) without division operation
// 2 <= nums.length <= 10^5
// -30 <= nums[i] <= 30
/*
全部かけといて、forで回して各要素で割ったら出せるけど割り算は使用禁止
forで舐めながら自分を除く配列を作って計算するのはO(n^2)になっちゃいそう
なめていきながらメモ化していく？
ans[1] =           nums[2] * nums[3] * nums[4]
ans[2] = nums[1]           * nums[3] * nums[4]
ans[3] = nums[1] * nums[2]           * nums[4]
ans[4] = nums[1] * nums[2] * nums[3]
左下三角は行きのforで、右上三角は帰りのforでそれぞれ計算できそう
forward = [1, nums[1], nums[1] * nums[2], nums[1] * nums[2] * nums[3]]
backward = [nums[2] * nums[3] * nums[4], nums[3] * nums[4], nums[4]]
out = forward * backward
*/
func productExceptSelf(nums []int) []int {
	result := make([]int, len(nums))
	forward := 1
	for i := 0; i < len(nums); i++ {
		result[i] = forward
		forward *= nums[i]
	}
	backward := 1
	for i := len(nums) - 1; i >= 0; i-- {
		result[i] *= backward
		backward *= nums[i]
	}
	return result
}

func main() {
	tests := []struct {
		nums []int
		want []int
	}{
		{[]int{1, 2, 3, 4}, []int{24, 12, 8, 6}},
		{[]int{-1, 1, 0, -3, 3}, []int{0, 0, 9, 0, 0}},
	}
	for _, t := range tests {
		got := productExceptSelf(t.nums)
		fmt.Printf("want %v, got %v\n", t.want, got)
	}

}
