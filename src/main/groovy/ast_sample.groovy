import groovy.transform.Immutable

/**
 * Created by kyokomi on 2014/05/10.
 */

@Singleton
class FooSingleton {
    def hello() { "hello" }
}

assert FooSingleton.instance.hello() == "hello"

// シングルトンなのでRuntimeException発生
//def a = new FooSingleton()

@Immutable
class FooImmutable {
    int x;
    Date date = new Date(1000)
}

a = new FooImmutable(x:1)
assert a.x == 1

// 変更しようとしてもコピーなので変更されない
assert a.date.getTime() == 1000
a.date.setTime(2000)
assert a.date.getTime() == 1000

// ReadOnlyPropertyExceptionが発生する
//a.x = 3