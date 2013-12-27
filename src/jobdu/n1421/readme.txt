题目描述：
As we all known, AbOr has a lots of girls in a palace called “Hou” (About 30 millions).
Now you are given n people without knowing their gender(Male and Female are equally 
likely for anyone). You also know the relationship between them!
 You want to know what is the expecting number of "abor" that could be found ,
  where "abor" is defined as:
 (1) Only Male might be considered;
(2) The Male who has at least m Females friends is called "abor".
输入：
        The first line is one integer T indicates the number
         of the test cases. (T <= 10000)
	Then for every case, the first line has only two integers n and m,
	 indicating the number of people and the value of m.(0≤m≤n≤20)
        Then one n by n symmetric matrix A, where A[i][j] is 1 if j 
        is a friend of i(vice versa) and 0 otherwise;(A[i][i] is always 0)
输出：
        Output the expecting number of "abor" in the given case. The 
        answer must round to two digital after the decimal point.
样例输入：
3
2 1
01
10
2 0
01
10
3 2
011
101
110
样例输出：
0.50
1.00
0.38
来源：http://ac.jobdu.com/problem.php?pid=1421