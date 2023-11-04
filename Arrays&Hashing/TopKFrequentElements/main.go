package main

import (
	"fmt"
)

func topKFrequent(nums []int, k int) []int {
	// 頻度を数える
	freqMap := map[int]int{} // key:数字, value:頻度
	for _, n := range nums {
		freqMap[n]++
	}

	// 頻度の大きいやつを調べてその数字を返さないといけない
	// 頻度をキーにして数字を返すmapを作る方法があるが、
	// それでは頻度のソートを別途やらなければならなくなる
	// しかし、mapではなくsliceにすることで
	// 明示的にソートしなくても昇順に並び替わる
	// 後ろからtopkを舐めて返せば良くなる
	freqSlice := make([][]int, len(nums)+1)
	for num, freq := range freqMap {
		freqSlice[freq] = append(freqSlice[freq], num)
	}

	result := []int{}
	for i := len(freqSlice) - 1; i > 0; i-- {
		result = append(result, freqSlice[i]...)
		if len(result) == k {
			return result
		}
	}
	return nil
}

func main() {
	tests := []struct {
		nums []int
		k    int
		want []int
	}{
		{[]int{1, 1, 1, 2, 2, 3}, 2, []int{1, 2}},
		{[]int{1}, 1, []int{1}},
	}

	for _, t := range tests {
		got := topKFrequent(t.nums, t.k)
		fmt.Printf("want %v, got %v\n", t.want, got)
	}
}
