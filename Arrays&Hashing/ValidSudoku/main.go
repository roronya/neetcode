package main

import "fmt"

func isValidSudoku(board [][]byte) bool {
	// 縦横ブロックでそれぞれ舐めてダブりが無いか調べる
	m := map[string]bool{}
	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			v := string(board[i][j])
			if v == "." {
				continue
			}
			_, ok1 := m[fmt.Sprintf("row[%d]=%d", i, v)]
			_, ok2 := m[fmt.Sprintf("column[%d]=%d", j, v)]
			_, ok3 := m[fmt.Sprintf("box[%d][%d]=%d", i/3, j/3, v)]

			if ok1 || ok2 || ok3 {
				return false
			}

			m[fmt.Sprintf("row[%d]=%d", i, v)] = true
			m[fmt.Sprintf("column[%d]=%d", j, v)] = true
			m[fmt.Sprintf("box[%d][%d]=%d", i/3, j/3, v)] = true
		}
	}

	return true
}

func main() {
	tests := []struct {
		board [][]string
		want  bool
	}{
		{
			[][]string{
				{"5", "3", ".", ".", "7", ".", ".", ".", "."},
				{"6", ".", ".", "1", "9", "5", ".", ".", "."},
				{".", "9", "8", ".", ".", ".", ".", "6", "."},
				{"8", ".", ".", ".", "6", ".", ".", ".", "3"},
				{"4", ".", ".", "8", ".", "3", ".", ".", "1"},
				{"7", ".", ".", ".", "2", ".", ".", ".", "6"},
				{".", "6", ".", ".", ".", ".", "2", "8", "."},
				{".", ".", ".", "4", "1", "9", ".", ".", "5"},
				{".", ".", ".", ".", "8", ".", ".", "7", "9"},
			},
			true,
		},
		{
			[][]string{
				{"8", "3", ".", ".", "7", ".", ".", ".", "."},
				{"6", ".", ".", "1", "9", "5", ".", ".", "."},
				{".", "9", "8", ".", ".", ".", ".", "6", "."},
				{"8", ".", ".", ".", "6", ".", ".", ".", "3"},
				{"4", ".", ".", "8", ".", "3", ".", ".", "1"},
				{"7", ".", ".", ".", "2", ".", ".", ".", "6"},
				{".", "6", ".", ".", ".", ".", "2", "8", "."},
				{".", ".", ".", "4", "1", "9", ".", ".", "5"},
				{".", ".", ".", ".", "8", ".", ".", "7", "9"},
			},
			false,
		},
	}
	for _, t := range tests {
		in := make([][]byte, len(t.board)+1)
		for i, row := range t.board {
			in[i] = make([]byte, len(row)+1)
			for j, str := range row {
				in[i][j] = str[0]
			}
		}

		got := isValidSudoku(in)
		fmt.Printf("want %v, got %v\n", t.want, got)
	}

}
