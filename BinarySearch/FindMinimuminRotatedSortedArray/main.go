package main

import "fmt"

func findMin(nums []int) int {
	// 値が最も小さい=右隣りが自分より小さい
	// 探索の方向性が決まらない
	// 先頭、真ん中,末尾を見れば当たりがつく？
	// 3,5,2 => 右側
	// 11,15,17 => 左側
	// 適当にindexを引いて行って、先頭、真ん中、末尾を見て特定していけば良さそう
	begin := 0
	end := len(nums) - 1
	for begin <= end {
		if len(nums[begin:end+1]) <= 2 {
			if nums[begin] < nums[end] {
				return nums[begin]
			}
			return nums[end]
		}

		middle := (begin + end) / 2
		// fmt.Println(begin, middle, end)
		if nums[begin] <= nums[middle] && nums[middle] <= nums[end] {
			// 1-2-3 左にある
			end = middle
		} else if nums[begin] >= nums[middle] && nums[middle] <= nums[end] {
			// 3-1-2 真ん中にある
			begin++
			end--
		} else if nums[begin] <= nums[middle] && nums[middle] >= nums[end] {
			// 2-3-1 右にある
			begin = middle
		} else {
			panic("ここにはこない")
		}
	}
	return 0
}

func main() {
	tests := []struct {
		nums []int
		want int
	}{
		{
			[]int{3, 4, 5, 1, 2},
			1,
		},
		{
			[]int{4, 5, 6, 7, 0, 1, 2},
			0,
		},
		{
			[]int{11, 13, 15, 17},
			11,
		},
		{
			[]int{2, 1},
			1,
		},
		{
			[]int{5, 1, 2, 3, 4},
			1,
		},
	}
	for i, t := range tests {
		got := findMin(t.nums)
		fmt.Printf("%d: want %v, got %v\n", i, t.want, got)
	}
}
