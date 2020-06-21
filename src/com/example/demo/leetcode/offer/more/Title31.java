package com.example.demo.leetcode.offer.more;



/* 剑指 Offer 31. 栈的压入、弹出序列
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2}
就不可能是该压栈序列的弹出序列。

输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
输出：true
解释：我们可以按以下顺序执行：
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
输出：false
解释：1 不能在 2 之前弹出。
 
提示： 0 <= pushed.length == popped.length <= 1000     0 <= pushed[i], popped[i] < 1000        pushed 是 popped 的排列。
 */

import java.util.Stack;

class Solution31 {
    private Stack<Integer> stack=new Stack<>();
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length == 0|| popped.length==0)return true;
        int i=0,len=pushed.length;
        stack.push(pushed[i++]);
        while(stack.peek()!=popped[0]){
            stack.push(pushed[i++]);
        }


        for(int k=0;k<popped.length;k++){

            while(i<len && ( stack.isEmpty() ||stack.peek()!=popped[k] )){
                stack.push(pushed[i++]);
            }

            if(stack.peek() == popped[k]){
                stack.pop();
            }
        }

        if(stack.isEmpty())return true;

        return false;
    }
}
public class Title31 {
    public static void main(String[] args) {
        int[] pushed = {1,0};
        int[] popped = {1,0};
        Solution31 solution31=new Solution31();
        System.out.println(solution31.validateStackSequences(pushed,popped));
    }
}
