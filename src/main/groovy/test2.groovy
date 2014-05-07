/**
 * Created by kyokomi on 2014/05/08.
 */

// 文字列リテラルにスラッシュ（/〜/）
println(/abc\ndef\n/)
println "abc\ndef\n"
println 'abc\ndef\n'

// GStringもっと深く
def a = "ADV"
println "Hi ${a*2}"
println "Hi ${a}"
println "Hi $a"

// 動的に現在時刻を表示し続けるGStringの例
def timer() {
    def c = { it << new Date() }.asWritable()
    def gs = "Current Time $c"
    while (true) {
        println gs
        Thread.sleep(1000)
    }
}
//timer();

Closure clos1 = { println "Hello World!" }
// どっちでも呼び出せる
clos1.call()
clos1()

// targetで引数を1つ受けるとの意
Closure clos2 = { target -> println "Hello ${target}" }
clos2("Groovy!")

Closure clos3 = { -> println "Hoge" }
clos3()
// Caught: groovy.lang.MissingMethodException
//clos3("FugaFuga")  // ==> エラー

Closure clos4 = { String name, int age -> println "${name} is ${age}" }
clos4("HogeHoge", 30)

def foo1(int count, Closure clos) {
    println "HogeHoge ${count}"
    clos()
}
def foo2(Closure clos) {
    println "HogeHoge2"
    clos()
}

foo1(10, { println "Closure1!!" })

foo2 { println "Closure2!!" }

new FileInputStream("../resources/hogehoge.txt").withStream { fis ->
    // fisからのデータ読み込み
    fis.eachLine { println "$it" }
}

def fuga = (1..10).grep{ it % 2 == 0 }
println fuga
def hoge = (1..10).collect{ it * 2 }
println hoge

println ""
for (int i : 1 .. 3) {
    print i
}

println ""
(1 ..< 3).each {
    print it
}

println ""
(3 .. 1).each {
    print it
}

println ""
for (String i : "a" .. "c") {
    print i
}

