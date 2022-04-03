package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteCell {
    private static final String BREAK_LINE = "\n";

    public static List<String> readCellData(String pathToXlsx, int firstRowNumber, int columnNumber) throws IOException {
        List<String> cellsValue = new ArrayList<>();
        Workbook wb = new XSSFWorkbook(new FileInputStream(pathToXlsx));
        Sheet sheet = wb.getSheetAt(0);
        Row row;

        for (int rowIndex = firstRowNumber; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            row = sheet.getRow(rowIndex);
            if (row != null) {
                Cell cell = row.getCell(columnNumber);
                cell.setCellType(CellType.STRING);
                cellsValue.add(cell.getStringCellValue());
            }
        }

        return cellsValue;
    }

    public static void writeCellData(String path, List<String> cellsToWrite, String sqlQuery) throws IOException {
        Writer output = new BufferedWriter(new FileWriter(path, true));
        for (String cellValue : cellsToWrite) {
            String str = String.format(sqlQuery, cellValue);
            output.append(BREAK_LINE);
            output.append(str);
        }
        output.close();
    }

}
