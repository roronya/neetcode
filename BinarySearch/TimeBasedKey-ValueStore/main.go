package main

import "fmt"

//1 <= key.length, value.length <= 100
//key and value consist of lowercase English letters and digits.
//1 <= timestamp <= 10^7
//All the timestamps timestamp of set are strictly increasing.
//At most 2 * 10^5 calls will be made to set and get.

type Element struct {
	timestamp int
	value     string
}

type TimeMap struct {
	store map[string][]Element
}

func Constructor() TimeMap {
	return TimeMap{map[string][]Element{}}
}

func (this *TimeMap) Set(key string, value string, timestamp int) {
	values, ok := this.store[key]
	if !ok {
		values = []Element{}
	}
	values = append(values, Element{timestamp, value})
	this.store[key] = values
}

func (this *TimeMap) Get(key string, timestamp int) string {
	values, ok := this.store[key]
	if !ok {
		return ""
	}
	// fmt.Println(values)

	// [1,2,4]のとき3がきたら2のときの値を返したい
	// 自分より小さい最大の値を返したい
	// mでアクセスしたときに右も見て自分より大きい値だったときが終了条件
	result := Element{-1, ""}
	l, r := 0, len(values)-1
	for l <= r {
		m := (l + r) / 2
		// fmt.Println(l, m, r) // 0,0,1
		// fmt.Println(values[l], values[m], values[r])
		if values[m].timestamp <= timestamp {
			if values[m].timestamp > result.timestamp {
				result = values[m]
			}
		}
		if values[m].timestamp < timestamp {
			l = m + 1
		} else {
			r = m - 1
		}
	}
	return result.value
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Set(key,value,timestamp);
 * param_2 := obj.Get(key,timestamp);
 */

func main() {
	timeMap := Constructor()
	timeMap.Set("foo", "bar", 1)  // store the key "foo" and value "bar" along with timestamp = 1.
	g0 := timeMap.Get("foo", 1)   // return "bar"
	g1 := timeMap.Get("foo", 3)   // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
	timeMap.Set("foo", "bar2", 4) // store the key "foo" and value "bar2" along with timestamp = 4.
	g2 := timeMap.Get("foo", 4)   // return "bar2"
	g3 := timeMap.Get("foo", 5)   // return "bar2"
	fmt.Println(g0, g1, g2, g3)
}
