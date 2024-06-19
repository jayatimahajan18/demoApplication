package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xslf.usermodel.XSLFTable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class ReadExcelData {

    static Workbook workbook;
    static Sheet sheet;
    static FileOutputStream fileOutputStream;

    public static Integer readData() throws IOException {
        FileInputStream excel = new FileInputStream(ConfigReader.getValue("TestData_Path"));
        workbook = WorkbookFactory.create(excel);
        sheet = workbook.getSheet(ConfigReader.getValue("SheetName"));
        int lastrow = 0;
        for (Row row : sheet) {
            for (Cell cell : row) {
                System.out.print(cell.toString() + "\t");
                lastrow = sheet.getPhysicalNumberOfRows();
            }
            System.out.println();
        }
        return lastrow;
    }

    public static void writeIntoExcel(String soNumber, String shipmentNumber) {
        try {
            int lastRow = readData();
            int i = lastRow;
            Row row = sheet.createRow(lastRow);
            Cell cell1 = row.createCell(0);
            Cell cell2 = row.createCell(1);
            Cell cell3 = row.createCell(2);
            cell1.setCellValue(i - 1);
            cell2.setCellValue(soNumber);
            cell3.setCellValue(shipmentNumber);
            fileOutputStream = new FileOutputStream(ConfigReader.getValue("TestData_Path"));
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getTestData() {
        try {
            readData();
            sheet = workbook.getSheet(ConfigReader.getValue("SheetName"));
                System.out.println(sheet.getPhysicalNumberOfRows());
                Row row=sheet.getRow((sheet.getPhysicalNumberOfRows())-1);
                Cell cell = row.getCell(1);
                //System.out.println(cell);
                return cell.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
