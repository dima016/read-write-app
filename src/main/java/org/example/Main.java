package org.example;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class Main {

    private static final ResourceBundle rb = ResourceBundle.getBundle("app");
    private static final Integer columnNumberToRead = Integer.parseInt(rb.getString("colNumberToRead"));
    private static final Integer rowNumberToRead = Integer.parseInt(rb.getString("startRowNumberToRead"));
    private static final String XlsxPathToRead = rb.getString("XlsxPathToRead");
    private static final String SqlPathToWrite = rb.getString("SqlPathToWrite");
    private static final String QUERY_SQL = rb.getString("SqlQuery");

    public static void main(String[] args) {
        try {
            List<String> cellsToWrite = ReadWriteCell.readCellData(XlsxPathToRead, rowNumberToRead, columnNumberToRead);
            ReadWriteCell.writeCellData(SqlPathToWrite, cellsToWrite, QUERY_SQL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}