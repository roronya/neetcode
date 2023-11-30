package main

import (
	"fmt"
)

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

// 1. 真ん中を見つける
// 2. 真ん中以降のリストを逆順にする
// 3. 2つのリストから交互に要素を並べる
func reorderList(head *ListNode) {
	// 真ん中を見つけたい
	// 偶数: [1,2,3,4] = [1,2], [3,4]
	// 奇数: [1,2,3,4,5] = [1,2,3], [4,5]
	// のように前半部分の一番最後の数字を見つけたい
	// slowを1つずつ進める間に、fastを2つすすめてnilまで繰り返せば真ん中が見つかりそう
	//
	slow, fast := head, head
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}

	reversed := reverse(slow.Next)
	slow.Next = nil

	curr := head

	for curr != nil && reversed != nil {
		next := curr.Next
		revNext := reversed.Next
		curr.Next = reversed
		reversed.Next = next
		curr = next
		reversed = revNext
	}
}

// 逆順のリストを作る
func reverse(node *ListNode) *ListNode {
	var prev, curr *ListNode = nil, node

	for curr != nil {
		next := curr.Next
		curr.Next = prev
		prev = curr
		curr = next
	}

	return prev
}

func main() {
	tests := []struct {
		head []int
		want []int
	}{
		{[]int{1, 2, 3, 4}, []int{1, 4, 2, 3}},
		{[]int{1, 2, 3, 4, 5}, []int{1, 5, 2, 4, 3}},
	}
	for i, t := range tests {
		head := newLinkedList(t.head)
		reorderList(head)
		fmt.Printf("%d: want %v, got %v\n", i, t.want, head.toSlice())
	}
}
