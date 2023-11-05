package main

import "fmt"

func twoSum(numbers []int, target int) []int {
	// 数字を入れたら相方の添字が返ってくる辞書を作る
	m := map[int]int{} // key:数字,value:添字
	for i, n := range numbers {
		if j, ok := m[n]; ok {
			return []int{j + 1, i + 1}
		}
		m[target-n] = i
	}
	return nil
}

func main() {
	tests := []struct {
		numbers []int
		target  int
		want    []int
	}{
		{[]int{2, 7, 11, 15}, 9, []int{1, 2}},
		{[]int{2, 3, 4}, 6, []int{1, 3}},
		{[]int{-1, 0}, -1, []int{1, 2}},
	}
	for _, t := range tests {
		got := twoSum(t.numbers, t.target)
		fmt.Printf("want %v, got %v\n", t.want, got)
	}
}
