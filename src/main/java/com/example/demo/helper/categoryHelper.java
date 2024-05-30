package com.example.demo.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.demo.entity.category;

public class categoryHelper 
{
	public static String[] HEADERS= {"id", "title", "description", "coverImage"};
	public static String SHEET_NAME = "category_sheet";
	
	public static ByteArrayInputStream dataToExcel(List<category> lists) throws IOException
	{
		Workbook workbook = new XSSFWorkbook();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try
		{
			
			Sheet sheet = workbook.createSheet("data");
			Row row = sheet.createRow(0);
			
			for(int i=0;i<HEADERS.length;i++)
			{
				Cell cell = row.createCell(i);
				cell.setCellValue(HEADERS[i]);
			}
			
			int rowCount = 1;
			for(category c:lists)
			{
				Row rows = sheet.createRow(rowCount);
				
				rows.createCell(0).setCellValue(c.getCategoryId());
				rows.createCell(1).setCellValue(c.getTitle());
				rows.createCell(2).setCellValue(c.getDescription());
				rows.createCell(3).setCellValue(c.getCoverImg());
				rowCount++;
			}
			workbook.write(outputStream);
			
		}
		catch(Exception e)
		{
			e.getStackTrace();
			System.out.println("fail to import file");
		}
		finally {
			workbook.close();
			outputStream.close();
		}
		return new ByteArrayInputStream(outputStream.toByteArray());
	}
}
