package oracle.tool.dBSchema;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DBSchema {
	
	@SuppressWarnings("unchecked")
	public static void readXLSXFile() throws IOException, EncryptedDocumentException, InvalidFormatException
	{
		InputStream ExcelFileToRead = new FileInputStream("C:/Users/hsbisht/Desktop/Data Model Totol Preparation/DataModel.xls");
		
		Workbook workBook = WorkbookFactory.create(ExcelFileToRead);    
		Sheet sheet  = workBook.getSheetAt(3);
		Row row; 
		Cell cell = null;
		
		Iterator rows = sheet.rowIterator();
		int columnCounter;
		String cellValue= GlobalConstants.GeneralConst.BLANK;
		
		ArrayList<Entity> entity = new ArrayList<Entity>();
		
		/*This map stores the TableName as a key and all other details about column in List object which stored
		in the map as a value. */
		Map<String, List<Object>> tableToColumnsMap= new HashMap<String, List<Object>>();
		
		
		ArrayList<ForeignKeyEntity> foreignKeyEntity = new ArrayList<ForeignKeyEntity>();
		Map<String, List<Object>> tableToForeignTableMap= new HashMap<String, List<Object>>();
		
		Map<Integer,String> mergedColumnFirstRow = new HashMap<Integer,String>();
		int index=0;
		boolean firstRowPassedFlag=false;
		if(rows.hasNext())
			rows.next();
		
		String tableName=GlobalConstants.GeneralConst.BLANK;
		
		while (rows.hasNext())
		{
			
			row=(Row) rows.next();
			columnCounter=0;
			index=0;
			Entity excelRow = new Entity();
			ForeignKeyEntity foreignRow = new ForeignKeyEntity();
			
			Iterator cells = row.cellIterator();
			while (cells.hasNext())
			{
				cell=(Cell) cells.next();
				columnCounter++;
				index++;
				cellValue = cell.getStringCellValue();
				switch(columnCounter)
				{
					case 1: if(!cellValue.equals(GlobalConstants.GeneralConst.BLANK))
								mergedColumnFirstRow.put(index, cellValue);
							excelRow.setEntityStatus(mergedColumnFirstRow.get(index));
							break;
					case 2: if(!cellValue.equals(GlobalConstants.GeneralConst.BLANK)){
								mergedColumnFirstRow.put(index, cellValue);
								if(firstRowPassedFlag==false){
									tableName = cellValue;
									firstRowPassedFlag =true;
								}
							}
							excelRow.setTableName(mergedColumnFirstRow.get(index));
							break;
					case 3: if(!cellValue.equals(GlobalConstants.GeneralConst.BLANK))
								mergedColumnFirstRow.put(index, cellValue);
							excelRow.setNewTableName(mergedColumnFirstRow.get(index));
							break;
					case 4: if(!cellValue.equals(GlobalConstants.GeneralConst.BLANK))
								mergedColumnFirstRow.put(index, cellValue);
							excelRow.setTableDescription(mergedColumnFirstRow.get(index));
							break;
					case 5: if(!cellValue.equals(GlobalConstants.GeneralConst.BLANK))
								mergedColumnFirstRow.put(index, cellValue);
							excelRow.setTablespace(mergedColumnFirstRow.get(index));
							break;
					case 6: if(!cellValue.equals(GlobalConstants.GeneralConst.BLANK))
								mergedColumnFirstRow.put(index, cellValue);
							excelRow.setTemporary(mergedColumnFirstRow.get(index));
							break;
					case 7: if(!cellValue.equals(GlobalConstants.GeneralConst.BLANK))
								mergedColumnFirstRow.put(index, cellValue);
							excelRow.setMlsSupportModel(mergedColumnFirstRow.get(index));
							break;
					case 8: if(!cellValue.equals(GlobalConstants.GeneralConst.BLANK))
								mergedColumnFirstRow.put(index, cellValue);
							excelRow.setTableShortname(mergedColumnFirstRow.get(index));
							break;
					case 9: excelRow.setColumnStatus(cellValue);
							break;
					case 10:excelRow.setColumnName(cellValue);
							foreignRow.setColumnName(cellValue);
							break;
					case 11: excelRow.setNewColumnName(cellValue);
							break;
					case 12: excelRow.setDataType(cellValue);
							break;
					case 13: excelRow.setColumnDescription(cellValue);
							break;
					case 14: excelRow.setDefaultValue(cellValue);
							break;
					case 15: excelRow.setNullable(cellValue);
							break;
					case 16: excelRow.setSecurityClassification(cellValue);
							break;
					case 17: excelRow.setColumnShortname(cellValue);
							break;
					case 18: excelRow.setPrimaryKeyName(cellValue);
							break;
					case 19: excelRow.setPrimaryKey(cellValue);
							break;
					case 20: foreignRow.setForeignKeyName(cellValue);
							break;
					case 21: foreignRow.setForeignKeyTable(cellValue);
							break;
					case 22: foreignRow.setForeignKeyColumn(cellValue);
							break;
					case 23: excelRow.setTranslatable(cellValue);
							break;
					case 24: excelRow.setWhoColumn(cellValue);
							break;
					default: break;
				}
			}
			
			if(!tableName.equals(excelRow.getTableName()))
			{
				tableToColumnsMap.put(tableName, (List<Object>) entity.clone());
				tableToForeignTableMap.put(tableName, (List<Object>) foreignKeyEntity.clone());
				
				tableName = excelRow.getTableName();
				entity.clear();
				foreignKeyEntity.clear();
			}
			
			entity.add(excelRow);
			
			if(!foreignRow.getForeignKeyTable().equals(GlobalConstants.GeneralConst.BLANK)){
				foreignKeyEntity.add(foreignRow);
			}
		}
		
		tableToColumnsMap.put(tableName, (List<Object>) entity.clone());
		tableToForeignTableMap.put(tableName, (List<Object>) foreignKeyEntity.clone());
	}
	
	public static void main(String[] args) throws IOException {
		
		try {
			readXLSXFile();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
	}
}