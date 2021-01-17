package com.xp.neo4jdemo;

import jdk.nashorn.internal.objects.annotations.Where;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.statement.create.view.CreateView;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.Join;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.util.TablesNamesFinder;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestJSQLP {
    public static void main(String[] args) throws Exception {
        System.out.println(getTableNameBySql("create temporary table ccid as select * from dw_clsfd.user as user left join dw_clsfd.ad as ad on user.id=ad.id  right join dw_clsfd.reply as reply on user.id=reply.id  where id not in (select id from dw_csfd.msg) and user.id!=5 and id=6"));
    }

    public static List<String> getTableNameBySql(String sql) throws JSQLParserException {
        CCJSqlParserManager parser = new CCJSqlParserManager();
        StringReader reader = new StringReader(sql);
        List<String> list = new ArrayList<String>();
        Statement stmt = parser.parse(new StringReader(sql));
        if (stmt instanceof CreateTable){
            CreateTable createTable=(CreateTable) stmt;
            System.out.println( createTable.getTable().getName());
            PlainSelect plainSelect=(PlainSelect)createTable.getSelect().getSelectBody();
            Table table=(Table) plainSelect.getFromItem();
            System.out.println(table.getSchemaName()+"."+table.getName());
            List<Join>  joins=plainSelect.getJoins();
            for (Join join:joins){
                Table table1=(Table) join.getRightItem();
                System.out.println(table1.getSchemaName()+"."+table1.getName());
            }
        }else if (stmt instanceof CreateView){

        }else if (stmt  instanceof Insert){

        }else {
            System.out.println(stmt.getClass().toString());
        }
        return list;
    }
}
