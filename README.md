data-structure-algorithm
========================

每天练习最少一个题

数据结构与算法练习

bookexercise 下为数据结构与算法分析每章的习题练习

poj 下为poj练习

程序说明：
项目是eclipse项目但是只是使用作为编辑器和文件管理器
每个包结构下包含的java文件针对readme中提出的问题进行解答
运行build.bat会编译所有当前目录下源文件
运行java文件名对应的bat文件会运行该程序
所有程序使用重定向以input.txt作为标准输入（在oj测试时无需多余操作）
所有程序使用重定向将输出到out.txt

运行方法：
1.进入到包含java文件的目录下
2.运行build.bat
3.运行需要的bat执行程序

工作：
2013-12-4
1.添加基本结构。确定程序运行方法及组织结构
2.添加bookexercise\maxsubsum：求最大子序列和。来源：数据结构与算法分析p33

2013-12-5
1.添加bookexercise\gcm:求两个数的最大公约数1.辗转相除法2.更相减损法

2013-12-7
1.修正maxsubsum中divideandconquer bug
2.添加bookexercise\minsubsum: 求最小子序列和。p40

2013-12-7
1.添加bookexercise\minsubsum: dp求解

单链表翻转：取得一个头结点，然后遍历链表，依次设置为新头结点（类似栈的push）
判断单链表是否有环： 两个迭代器，步长分别为一、二，如果有环。循环会重叠
删除非尾节点：将当前节点值设置为next节点值，然后删除next

















