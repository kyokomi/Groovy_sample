
println "hoge"

new File(args[0]).eachLine {
  println it
}

"abc def ghi".split(/\s+/).each {
  println it
}

println "-----"

def map = [a:123, b:456]

map.entrySet().sort{it.value}.each{
  println "[${it.key} : ${it.value}]"
}

println "-----"

map.entrySet().sort{it.value}.each{
  println it
}

println "-----"

map.entrySet().sort{it.value}.each{
  println "[" +  it.key + " : " + it.value + "]"
}

//import javax.swing.*;
//
//def frame = new JFrame()
//frame.bounds = [200, 200, 200, 200]
//JButton button = new JButton("say hello")
//button.actionPerformed = { event -> println "hello!" }
//frame.add button
//frame.visible = true

a = 1
def b = 2

// 定義したメソッドはバインディング変数を参照できない
//  No such property: b for class: test
//def foo() {
//    println a
//    println b
//}

// クロージャからはバインディング変数の参照可能
foo = {
    println a
    println b
}
foo()

// Map引数をカンマ区切りで指定できる
def foo2(Map param) {
    println param.name
    println param.age
    println param.gender
}
foo2(age:25, name:"hoge")

// デフォルトコンストラクタをMapで呼び出すことも可能（ただし、別のコンストラクタを定義すると使えない）
class MyClass {
    String name
    int age

    static foo() {
        println this
        println this.class
    }
}
def c = new MyClass(name:"ノワール", age:18)
println c.name
println c.age
println c.foo()

// デフォルト引数指定できる
def foo3(int data = 333) {
    println data
}

foo3()
foo3(999)
