package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func newLinkedList(nums []int) *ListNode {
	head := &ListNode{}
	current := head
	for _, n := range nums {
		current.Next = &ListNode{Val: n}
		current = current.Next
	}
	return head.Next
}

func (l *ListNode) toSlice() []int {
	var result []int
	current := l
	for current != nil {
		result = append(result, current.Val)
		current = current.Next
	}
	return result
}

func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	head := &ListNode{}
	result := head
	for !(list1 == nil && list2 == nil) {
		if list1 == nil {
			result.Next = list2
			list2 = list2.Next
			result = result.Next
			continue
		}
		if list2 == nil {
			result.Next = list1
			list1 = list1.Next
			result = result.Next
			continue
		}
		if list1.Val < list2.Val {
			result.Next = list1
			list1 = list1.Next
		} else {
			result.Next = list2
			list2 = list2.Next
		}
		result = result.Next
	}
	return head.Next
}

func main() {
	tests := []struct {
		list1 []int
		list2 []int
		want  []int
	}{
		{[]int{1, 2, 4}, []int{1, 3, 4}, []int{1, 1, 2, 3, 4, 4}},
		{[]int{}, []int{}, []int{}},
		{[]int{}, []int{0}, []int{0}},
		{[]int{-9, 3}, []int{5, 7}, []int{-9, 3, 5, 7}},
	}
	for i, t := range tests {
		list1 := newLinkedList(t.list1)
		list2 := newLinkedList(t.list2)
		got := mergeTwoLists(list1, list2)
		fmt.Printf("%d: want %v, got %v\n", i, t.want, got.toSlice())
	}
}
