package main

import "fmt"

func groupAnagrams(strs []string) [][]string {
	// 文字列をアルファベットの頻出頻度表に変換する
	// 同じ頻出頻度表を持てばアナグラムである
	// 頻出頻度表ごとに文字列をグルーピングしておいてそのmapのvaluesを返せば良い
	anagramMap := map[[26]int][]string{} // 頻出頻度表をキーにして文字列の配列を返す
	for _, s := range strs {
		count := [26]int{}
		for _, c := range s {
			count[c-'a']++
		}
		anagramMap[count] = append(anagramMap[count], s)
	}

	// valuesを作ってる
	result := make([][]string, len(anagramMap))
	i := 0
	for _, v := range anagramMap {
		result[i] = v
		i++
	}
	return result
}

func main() {
	tests := []struct {
		strs []string
		want [][]string
	}{
		{
			[]string{"eat", "tea", "tan", "ate", "nat", "bat"},
			[][]string{
				{"bat"},
				{"nat", "tan"},
				{"ate", "eat", "tea"},
			},
		},
		{
			[]string{""},
			[][]string{{""}},
		},
		{
			[]string{"a"},
			[][]string{{"a"}},
		},
	}

	for _, t := range tests {
		got := groupAnagrams(t.strs)
		fmt.Printf("want %v, got %v\n", t.want, got)
	}
}
