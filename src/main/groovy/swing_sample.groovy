/**
 * Created by kyokomi on 2014/05/09.
 */
import groovy.swing.SwingBuilder
import java.awt.BorderLayout as BL
import javax.swing.WindowConstants as WC

data = [
        [id:1, item:'超女神信仰ノワール 激神ブラックハート', prio:1, due:'2014/5/29'],
        [id:2, item:'限界凸記 モエロクロニクル', prio:2, due:'2014/5/15'],
        [id:3, item:'神様と運命覚醒のクロステーゼ', prio:3, due:'2014/9/25']
]

swing = new SwingBuilder()
table = swing.table() {
    tableModel(list:data) {
        propertyColumn(header: 'ID', propertyName: 'id', preferredWidth: 20)
        propertyColumn(header: 'ソフト名', propertyName: 'item', preferredWidth: 200)
        propertyColumn(header: '優先度', propertyName: 'prio', preferredWidth: 20)
        propertyColumn(header: '発売日', propertyName: 'due', preferredWidth: 50)
    }
}
frame = swing.frame (title:'購入予定ゲームリスト', layout: new BL(), defaultCloseOperation:WC.EXIT_ON_CLOSE) {
    panel(constraints:BL.NORTH) {
        label(text: '発売日一覧')
    }
    panel(constraints:BL.CENTER) {
        scrollPane {
            widget(table)
        }
    }
}
frame.pack()
frame.visible = true
//frame.show()
