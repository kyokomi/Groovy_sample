/**
 * Created by kyokomi on 2014/05/09.
 */

//////////////////
// GroovyでCUIベースのコマンドラインオプションを見通しよく行うビルダー
def cli = new CliBuilder(usage: 'groovy CliBuildersSample.groovy -f filename [-d]')

cli.h(longOpt:'help', 'ヘルプ')
cli.f(longOpt:'file', required:true, args:1, '処理対象ファイル名')
cli.d(longOpt:'debug', 'デバッグモード')

def options = cli.parse(args)

if (!options) return

if (options.h) {
    cli.usage()
    return
}

if (options.d) println "オプション-dが指定されました（デバッグモードに移行します）"

if (options.f) println "オプション-fが指定されました（引数=${options.f}）"

///////////////////////
// Antビルダー
def ant = new AntBuilder()

ant.copy(todir:'dest') {
    fileset(dir:'source') {
        include(name:'*.properties')
    }
}
