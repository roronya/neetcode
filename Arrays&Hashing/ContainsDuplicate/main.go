package main

func containsDuplicate(nums []int) bool {
	memo := map[int]bool{}
	for _, n := range nums {
		if memo[n] {
			return true
		}
		memo[n] = true
	}
	return false
}
