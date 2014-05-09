/**
 * Created by kyokomi on 2014/05/09.
 */
import groovy.xml.MarkupBuilder
import groovy.xml.StreamingMarkupBuilder
import groovy.xml.XmlUtil

// XMLビルダー
def xml = new StreamingMarkupBuilder()

def writable = xml.bind{
    Products() {
        Product(type: 'regular') {
            Name('Instant Node')
            Price(147)
        }
    }
}
println writable.toString()
XmlUtil.serialize(writable.toString(), new FileOutputStream("source/hoge.xml"))

def xmlbuild = new MarkupBuilder()
xmlbuild.Products() {
    Product(type: 'regular') {
        Name('Instant Node')
        Price(147)
    }
}
println xmlbuild.toString()
