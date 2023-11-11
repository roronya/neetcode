package main

import (
	"fmt"
)

//The number of nodes in the list is the range [0, 5000].
//-5000 <= Node.val <= 5000

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

func reverseList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	// [1,2,3] => [3,2,1]にしたいとき
	// head = 1のとき、2の次のNodeを1にする
	// 自分のNextNodeのNextNodeを自分にする
	// 自分のNextNodeはnilにする
	// 再帰だから、NextNodeが無い3までまず行く
	// reversedListHead=3が帰ってきて、head=2
	// headのNextのNextを2にして、head.Next=nilにしておく
	// それでreversedListHead=1に戻ってくる
	reversedListHead := reverseList(head.Next)
	head.Next.Next = head
	head.Next = nil
	return reversedListHead
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

func main() {
	tests := []struct {
		head []int
		want []int
	}{
		{
			[]int{1, 2, 3, 4, 5},
			[]int{5, 4, 3, 2, 1},
		},
		{
			[]int{1, 2},
			[]int{2, 1},
		},
		{
			[]int{},
			[]int{},
		},
	}
	for i, t := range tests {
		l := newLinkedList(t.head)
		fmt.Printf("%v\n", l.toSlice())
		got := reverseList(l)
		fmt.Printf("%d: want %v, got %v\n", i, t.want, got.toSlice())
	}
}
