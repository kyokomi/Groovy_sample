/**
 * Created by kyokomi on 2014/05/09.
 */

import groovy.sql.Sql

def sql = Sql.newInstance('jdbc:derby:memory:testdb;create=true',
        'user',
        'password',
        'org.apache.derby.jdbc.EmbeddedDriver')

sql.withTransaction {

    sql.execute('''
        create table PERSON (
            id integer not null primary key,
            first_name varchar(20),
            last_name varchar(20),
            location_id integer,
            location_name varchar(30)
        )
    ''')

    sql.execute('''
        insert into PERSON (id, first_name, last_name, location_id, location_name)
        values (1, 'K','yokomi', 10, 'Tokyo')
    ''')

    // PrepareStatement
    def personInsert = '''
        insert into PERSON (id, first_name, last_name, location_id, location_name)
        values (?, ?,?, ?, ?)
    '''
    sql.execute personInsert, [2, 'ノワール', 'ブラックハート', 11, 'ラステイション']
    sql.execute personInsert, [3, 'ネプテューヌ', 'パープルハート', 10, 'プラネテューヌ']

    // 結果を1行づつクロージャで処理する
    sql.eachRow('select * from PERSON') { println it }

    // 結果セット全体をクロージャで処理する
    sql.query('select * from PERSON') { rs ->
        while (rs.next()) {
            println "${rs.getInt(1)}, ${rs.getString(2)}"
        }
    }
}