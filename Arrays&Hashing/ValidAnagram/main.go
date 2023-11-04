package main

import "fmt"

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	// 各アルファベットの出現回数をメモするリストを用意する
	// sの文字列の各アルファベットの出現回数を数えてメモをインクリメントしながら
	// tの文字列のアルファベットの出現回数も数えてメモをデクリメントする
	// もしsとtがアナグラムなら出現回数を数えたメモはすべて0になる

	freq := [26]int{}
	for i := 0; i < len(s); i++ {
		freq[s[i]-'a']++
		freq[t[i]-'a']--
	}

	for _, f := range freq {
		if f != 0 {
			return false
		}
	}
	return true
}

func main() {
	result := isAnagram("anagram", "nagaram")
	fmt.Println(result)
}
