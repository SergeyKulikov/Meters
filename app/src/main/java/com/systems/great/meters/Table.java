package com.systems.great.meters;

import java.util.ArrayList;

/**
 * Created by Sergey on 05.08.2017.
 */

public class Table {
    private String tableName;
    private ArrayList<Field> fields;
//    private ArrayList<FieldIndex> index_list;

    public Table(String tableName, ArrayList<Field> fields) {
        this.tableName = tableName;
        this.fields = fields;
    }

    public String getTableName() {
        return tableName;
    }

    public String generateTableCreateCode() {
        // Auto code create
        StringBuilder rez = new StringBuilder();
        rez.append("CREATE TABLE "+tableName);
        rez.append("(");

        for (int i=0; i<fields.size(); i++) {
            String name = fields.get(i).getName();
            rez.append(name);
            if (name.equals("_id")) {
                rez.append(" PRIMARY KEY");
            }
            rez.append((i == fields.size()-1) ? "" : ",");
        }
        rez.append(")");

        return rez.toString();
    }

}
