package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface{

        private ATableInterface aTable;

        public TableInterfaceWrapper(ATableInterface aTable) { this.aTable = aTable; }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            aTable.setModel(rows);
        }

        @Override
        public String getHeaderText() { return aTable.getHeaderText().toUpperCase(); }

        @Override
        public void setHeaderText(String newHeaderText) { aTable.setHeaderText(newHeaderText); }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) { }
}