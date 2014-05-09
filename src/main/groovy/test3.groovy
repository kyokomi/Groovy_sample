/**
 * Created by kyokomi on 2014/05/08.
 */

def asLeast3 = Math.&max.curry(3);

assert asLeast3(5) == 5
assert asLeast3(4) == 4
assert asLeast3(3) == 3
assert asLeast3(2) == 3
assert asLeast3(1) == 3

List list = [1,2,3]
assert list instanceof java.util.ArrayList
assert list.size == 3
println list

println list[0]
println list[-1]
println ([1,2,3] + [4,5,6])
println ([1,2,3,4] - [1,2,3])
println ([1,2,3]*2)

def aCount = ['a', 'a', 'a', 'b','c'].count('a')
println aCount
println ((1..10).findAll { it % 2 ==0 })

def mapData = [a:1, b:2]

def key = "a"
println mapData."$key"
println mapData[key]

assert "abc" ==~ /a.c/