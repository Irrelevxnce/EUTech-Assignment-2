package com.irrelevxnce;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileOutputStream;

public class Report {
    String parsedName;
    String parsedMonday;
    String parsedTuesday;
    String parsedWednesday;
    String parsedThursday;
    String parsedFriday;
    String parsedDate;
    String[] mondayTasks;
    String[] tuesdayTasks;
    String[] wednesdayTasks;
    String[] thursdayTasks;
    String[] fridayTasks;
    int monLength = 0;
    int tueLength = 0;
    int wedLength = 0;
    int thuLength = 0;
    int friLength = 0;
    static HSSFWorkbook workbook;
    static CellStyle style1;
    static CellStyle style2;
    Row [] rowTasks;


    public Report(String parsedName, String parsedMonday, String parsedTuesday, String parsedWednesday, String parsedThursday, String parsedFriday, String parsedDate) {
        this.parsedName = parsedName;
        this.parsedMonday = parsedMonday;
        this.parsedTuesday = parsedTuesday;
        this.parsedWednesday = parsedWednesday;
        this.parsedThursday = parsedThursday;
        this.parsedFriday = parsedFriday;
        this.parsedDate = parsedDate;
    }
    public void saveReport() {
        File docDirectory = new File(System.getProperty("user.home").concat("\\Documents"));
        File EUTechFolder = new File(docDirectory.toString().concat("\\EUTechReporting"));
        File userFolder = new File(EUTechFolder.toString().concat("\\" + parsedName));
        if(userFolder.mkdirs()) {
            xlsMaker(userFolder);
        } else {
            System.out.println("Unable to create folder (might already exist on disk.)");
            xlsMaker(userFolder);
        }
    }

    public void xlsMaker (File folderToWriteTo) {
        File userDoc = new File(folderToWriteTo.toString().concat("\\" + parsedName + " - " + parsedDate.replace("/", ".") + ".xls"));
        try  {
            if (userDoc.createNewFile()) {
                workbook =  new HSSFWorkbook();
                HSSFSheet sheet = workbook.createSheet(parsedName.concat(".info"));
                sheet.addMergedRegion(CellRangeAddress.valueOf("A1:B1"));
                sheet.addMergedRegion(CellRangeAddress.valueOf("C1:E1"));
                style1 = workbook.createCellStyle();
                HSSFFont font = workbook.createFont();
                font.setFontHeightInPoints((short)10);
                font.setColor(IndexedColors.WHITE.getIndex());
                style1.setFont(font);
                style1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                style1.setFillForegroundColor(HSSFColor.BLACK.index);
                style1.setFillBackgroundColor(HSSFColor.BLACK.index);
                style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                style2 = workbook.createCellStyle();
                style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                style2.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
                style2.setFillBackgroundColor(HSSFColor.LIGHT_BLUE.index);
                style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                //Create Heading
                Row rowHeading = sheet.createRow(0);
                rowHeading.createCell(0).setCellValue("Name: " + parsedName);
                rowHeading.createCell(2).setCellValue("Date Interval: " + parsedDate);
                for (int i = 0; i < rowHeading.getLastCellNum(); i += 2) {
                    Cell cell = rowHeading.getCell(i);
                    cell.setCellStyle(style1);
                }
                Row rowTitles = sheet.createRow(1);
                rowTitles.createCell(0).setCellValue("Monday");
                rowTitles.createCell(1).setCellValue("Tuesday");
                rowTitles.createCell(2).setCellValue("Wednesday");
                rowTitles.createCell(3).setCellValue("Thursday");
                rowTitles.createCell(4).setCellValue("Friday");
                for (int i = 0; i < rowTitles.getLastCellNum(); i++) {
                    Cell cell = rowTitles.getCell(i);
                    cell.setCellStyle(style2);
                }
                if (parsedMonday != null) {
                    mondayTasks = parsedMonday.split("\n");
                    monLength = mondayTasks.length;
                }
                if (parsedTuesday != null) {
                    tuesdayTasks = parsedTuesday.split("\n");
                    tueLength = tuesdayTasks.length;
                }
                if (parsedWednesday != null) {
                    wednesdayTasks = parsedWednesday.split("\n");
                    wedLength = wednesdayTasks.length;
                }
                if (parsedThursday != null) {
                    thursdayTasks = parsedThursday.split("\n");
                    thuLength = thursdayTasks.length;
                }
                if (parsedFriday != null) {
                    fridayTasks = parsedFriday.split("\n");
                    friLength = fridayTasks.length;
                }
                int max = Math.max(monLength, Math.max(tueLength, Math.max(wedLength, Math.max(thuLength, friLength))));
                rowTasks = new Row[max];
                for (int i = 0 ; i < max - 1; i++) {
                    rowTasks[i] = sheet.createRow(i + 2);
                    rowTasks[i].createCell(0).setCellValue(writeToWB(mondayTasks, i));
                    rowTasks[i].createCell(1).setCellValue(writeToWB(tuesdayTasks, i));
                    rowTasks[i].createCell(2).setCellValue(writeToWB(wednesdayTasks, i));
                    rowTasks[i].createCell(3).setCellValue(writeToWB(thursdayTasks, i));
                    rowTasks[i].createCell(4).setCellValue(writeToWB(fridayTasks, i));
                }
                FileOutputStream out = new FileOutputStream(userDoc);
                for (int i = 0 ; i < 5 ; i++) {
                    sheet.autoSizeColumn(i);
                }
                workbook.write(out);
                out.flush();
                out.close();
                System.out.println("File Created");
            }
            else {
                System.out.println("Unable to create file (might already exist in folder)");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String writeToWB (String [] dayTasks, int i) {
        try {
            return dayTasks[i + 1];
        } catch (Exception e) {
            return "";
        }
    }
}
