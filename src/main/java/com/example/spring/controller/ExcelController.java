package com.example.spring.controller;

import com.example.spring.entity.ExcelMember;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("excel")
public class ExcelController {

    @GetMapping("download")
    public void excelDownload(HttpServletResponse res) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("custom_sheet");
        Row row = null;
        Cell cell = null;
        int rowNum = 0;

        row = sheet.createRow(0);
        cell = row.createCell(0);
        cell.setCellValue("번호");
        cell = row.createCell(1);
        cell.setCellValue("이름");
        cell = row.createCell(2);
        cell.setCellValue("성별");

        for(int i = 1; i < 5; i++) {
            row = sheet.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue("id" + i);
            cell = row.createCell(1);
            cell.setCellValue("강인재" + i);
            cell = row.createCell(2);
            cell.setCellValue("성별" + i);
        }

        res.setContentType("ms-vnd/excel");
        res.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=test.xlsx");

        workbook.write(res.getOutputStream());
        workbook.close();
    }

    @PostMapping("upload")
    public String excelUpload(@RequestParam("file") MultipartFile file, Model model) throws IOException, InvalidFormatException {
        OPCPackage opcPackage = OPCPackage.open(file.getInputStream());
        XSSFWorkbook workbook = new XSSFWorkbook(opcPackage);

        XSSFSheet sheet = workbook.getSheetAt(0);

        int sheetCount = workbook.getNumberOfSheets();
        log.info("sheetCount : {}", sheetCount);

        List<ExcelMember> memberList = new ArrayList<>();
        for(int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            ExcelMember excelMember = new ExcelMember();
            excelMember.setId(row.getCell(0).getStringCellValue());
            excelMember.setName(row.getCell(1).getStringCellValue());
            excelMember.setGender(row.getCell(2).getStringCellValue());
            memberList.add(excelMember);
        }
        model.addAttribute("memberList", memberList);
        return "success";
    }

}
