package com.monetroom.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataHandlers 
{
  public static String getDataFromPropertyFile(String filepath,String key)
  
  {
	  String data=null;
	  
	  try
	  {
		  File f=new File(filepath);
		  FileInputStream fis=new FileInputStream(f);
	      Properties p=new Properties();
	      p.load(fis);
	      data=(String)p.getProperty(key);
	      
	  }
	  
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return data;
	  
	}
 public static String getDataFromExcel(String filepath,String sheetname,int rowIndex,int cellIndex)
  
  {
	  String data=null;
	  
	  try
	  {
		  File f=new File(filepath);
		  FileInputStream fis=new FileInputStream(f);
	      Workbook wb=WorkbookFactory.create(fis);
	      Sheet st=wb.getSheet(sheetname);
	      Row r=st.getRow(rowIndex);
	      Cell c=r.getCell(cellIndex);
	      data=c.toString();	      
	  }
	  
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return data;
}
}
