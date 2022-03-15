package main

import (
	"fmt"
)

func construct2DArray(original []int, m int, n int) [][]int {
	if m*n != len(original) {
		return make([][]int, 0)
	}
	twoDemionArray := make([][]int, m)
	var j int = 0
	var z int = 0
	var array []int
	for i := 0; i < len(original); i++ {
		if z == 0 {
			array = make([]int, n)
			twoDemionArray[j] = array
			j++
		}
		array[z] = original[i]
		z++
		if z == n {
			z = 0
		}
	}
	return twoDemionArray
}
func construct2DArray2(original []int, m int, n int) [][]int {
	length := len(original)
	if length != m*n {
		return nil
	}
	twoDemionArray := make([][]int, m)
	j := 0
	for i := 0; i < length; i += n {
		twoDemionArray[j] = original[i : i+n]
		j++
	}
	return twoDemionArray
}
func main() {
	a := [10]int{9, 9, 9, 7, 9, 6, 7, 5, 4, 0}
	twoDArray := construct2DArray(a[:], 2, 5)
	fmt.Println(twoDArray)
	fmt.Println(construct2DArray2(a[:],2,5))
}
