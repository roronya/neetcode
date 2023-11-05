package main

import (
	"fmt"
	"regexp"
	"strings"
)

func isPalindrome(s string) bool {
	// 前と後ろ両方から見ていって一致するか確認すればよい
	reg, _ := regexp.Compile("[^a-zA-Z0-9]+")
	s = reg.ReplaceAllString(s, "")
	s = strings.ToLower(s)

	// こういう仕様
	if len(s) == 0 {
		return true
	}

	i := 0
	j := len(s) - 1
	for i < j {
		if s[i] != s[j] {
			return false
		}
		i++
		j--
	}
	return true
}

func main() {
	tests := []struct {
		s    string
		want bool
	}{
		{"A man, a plan, a canal: Panama", true},
		{"race a car", false},
		{" ", true},
		{"aa", true},
		{"ab@a", true},
	}
	for _, t := range tests {
		got := isPalindrome(t.s)
		fmt.Printf("want %v, got %v\n", t.want, got)
	}

}
