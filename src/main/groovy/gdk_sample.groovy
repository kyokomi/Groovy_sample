/**
 * Created by kyokomi on 2014/05/09.
 */

def filePath = "source/hoge.txt"

new File(filePath).withWriter { writer ->
    writer << "コンパイルハート\n"
    writer << "ネプテューヌ\n"
    writer << "ラステイション\n"
}

def fileText = new File(filePath).text
println fileText


new File(filePath).eachLine { fileLine ->
    println "Line: ${fileLine}"
}

new File('.').eachFile() { file ->
    println "Filename: ${file}"
}

def htmlString = new URL('http://google.com/').getText()
println htmlString

// 外部コマンド実行
println "ifconfig".execute().getText()

println ("hello".tr('aiueo', 'AIUEO'))