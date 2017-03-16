package test;

import java.io.*;
import java.util.*;

import org.apache.commons.lang.ArrayUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.ArrayUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class LeerExcel {

	static DataFormatter formatter = new DataFormatter();


	@SuppressWarnings("deprecation")
	public static void main(String args[]) throws IOException{
	//FileInputStream file = new FileInputStream(new File("prueb_excel.xls"));
	FileInputStream file = new FileInputStream("src/Characters.xlsx");

	// Crear el objeto que tendra el libro de Excel
	XSSFWorkbook workbook = new XSSFWorkbook(file);

	/*
	 * Obtenemos la primera pestaña a la que se quiera procesar indicando el indice.
	 * Una vez obtenida la hoja excel con las filas que se quieren leer obtenemos el iterator
	 * que nos permite recorrer cada una de las filas que contiene.
	 */
	XSSFSheet sheet = workbook.getSheetAt(0);
	
	Iterator<Row> rowIterator = sheet.iterator();
	
	
	/************** BASICS **************/
	int firstRow = 1;
	int lastRow = 8;
	int EXCEL_COLUMN = 1;
	List<String> basics = new ArrayList<String>();
	
	readCharacterDataFromExcelSingleColumn(sheet, firstRow, lastRow, basics, EXCEL_COLUMN);
	
	/************** ATTRIBUTES **************/
	firstRow = 12;
	lastRow = 18;
	EXCEL_COLUMN = 1;
	List<String> attributes = new ArrayList<String>();
	
	readCharacterDataFromExcelSingleColumn(sheet, firstRow, lastRow, attributes, EXCEL_COLUMN);
	
	/************** DESCRIPTION **************/
	firstRow = 1;
	lastRow = 8;
	EXCEL_COLUMN = 4;
	List<String> description1 = new ArrayList<String>();
	
	readCharacterDataFromExcelSingleColumn(sheet, firstRow, lastRow, description1, EXCEL_COLUMN);
	
	firstRow = 1;
	lastRow = 8;
	EXCEL_COLUMN = 6;
	List<String> description2 = new ArrayList<String>();
	readCharacterDataFromExcelSingleColumn(sheet, firstRow, lastRow, description2, EXCEL_COLUMN);
	
	List<String> description = new ArrayList<String>(description1);
	description.addAll(description2);
	
	/************** LANGUAGES **************/
	firstRow = 11;
	lastRow = 19;
	EXCEL_COLUMN = 3;
	List<String []> languages = new ArrayList<String []>();
	readCharacterDataFromExcelDoubleColumn(sheet, firstRow, lastRow, languages, EXCEL_COLUMN);
	
	/************** SPELLS **************/
	firstRow = 1;
	lastRow = 15;
	EXCEL_COLUMN = 8;
	List<String []> spells = new ArrayList<String []>();
	readCharacterDataFromExcelDoubleColumn(sheet, firstRow, lastRow, spells, EXCEL_COLUMN);
	
	
	/************** SKILLS *************/
	firstRow = 1;
	lastRow = 45;
	EXCEL_COLUMN = 11;
	List<String []> skills = new ArrayList<String []>();
	readCharacterDataFromExcelSkills(sheet, firstRow, lastRow, skills, EXCEL_COLUMN);

	
	/************** GEAR IN USE (WEAPONS) *************/
	firstRow = 23;
	lastRow = 25;
	int LEFT_COLUMN = 0;
	int RIGHT_COLUMN = 5;
	List<List> weapons = new ArrayList<List>();
	readCharacterDataFromExcelWeapons(sheet, firstRow, lastRow, weapons, LEFT_COLUMN, RIGHT_COLUMN);
	
	boolean dualWielding = weapons.size() == 2;
	
	/************** GEAR IN USE (ARMOUR, DEFENSIVE, RINGS) *************/
	int firstItemRow = 28;
	int lastItemRow = 29;
	int lastSectionRow = 42;
	LEFT_COLUMN = 0;
	RIGHT_COLUMN = 5;
	List<List> armourItems = new ArrayList<List>();
	readCharacterDataFromExcelDefensiveItems(sheet, firstItemRow, lastItemRow, lastSectionRow, armourItems, LEFT_COLUMN, RIGHT_COLUMN);
	
	/*
	// Recorremos todas las filas para mostrar el contenido de cada celda
	while (rowIterator.hasNext()){
	    row = (XSSFRow) rowIterator.next();
	    // Obtenemos el iterator que permite recorres todas las celdas de una fila

	    Iterator<Cell> cellIterator = row.cellIterator();
	    XSSFCell celda;
	    while (cellIterator.hasNext()){
			celda = (XSSFCell)cellIterator.next();
			System.out.println(celda.getRichStringCellValue());
			// Dependiendo del formato de la celda el valor se debe mostrar como String, Fecha, boolean, entero...
			/*switch(celda.getCellTypeEnum()) {
				case NUMERIC:
				    if( DateUtil.isCellDateFormatted(celda) ){
				       System.out.println(celda.getDateCellValue());
				    }else{
				       System.out.println(celda.getNumericCellValue());
		
				    }
				    break;
				case STRING:
				    System.out.println(celda.getStringCellValue());
				    break;
				case BOOLEAN:
				    System.out.println(celda.getBooleanCellValue());
				    break;
				default:
					;
				}*/
			/*
	    }
	}*/

	// cerramos el libro excel
	workbook.close();
    }

	/** Lee desde el Excel los valores del Excel segun los parámetros indicados (se lee en vertical, de arriba a abajo)
	 * @sheet Hoja actual desde donde se lee
	 * @firstRow Indice de la fila inicial desde donde hay que leer
	 * @lastRow Indice de la fila final hasta donde hay que leer
	 * @list Lista donde se almacenan los valores leidos
	 * @COLUMN Columna del la hoja del excel que estamos leyendo*/
	private static void readCharacterDataFromExcelSingleColumn(XSSFSheet sheet, int firstRow, int lastRow, List list, int COLUMN) {;
		for(int i = firstRow; i <= lastRow; i++){
			XSSFRow  row = sheet.getRow(i);
			//XSSFCell cell_name = row.getCell(COLUMN - 1);
			//String testCellName = formatter.formatCellValue(cell_name);
			XSSFCell cell_value = row.getCell(COLUMN);
			if(cell_value != null) {
				list.add(formatter.formatCellValue(cell_value));
			}
		}
	}
	
	/** Lee desde el Excel los valores del Excel segun los parámetros indicados (se lee en vertical, de arriba a abajo),
	 *  En este método, dos columnas (usualmente el nombre de algo y la habilidad en ello)
	 * @sheet Hoja actual desde donde se lee
	 * @firstRow Indice de la fila inicial desde donde hay que leer
	 * @lastRow Indice de la fila final hasta donde hay que leer
	 * @list Lista donde se almacenan los valores leidos
	 * @COLUMN Columna del la hoja del excel que estamos leyendo (se lee en vertical, de arriba a abajo)*/
	private static void readCharacterDataFromExcelDoubleColumn(XSSFSheet sheet, int firstRow, int lastRow, List<String[]> list, int COLUMN) {
		
		for(int i = firstRow; i <= lastRow; i++){
			XSSFRow  row = sheet.getRow(i);
			XSSFCell cell_name = row.getCell(COLUMN);
			String testCellName = formatter.formatCellValue(cell_name);
			XSSFCell cell_value = row.getCell(COLUMN + 1);
			if(cell_value != null && !testCellName.isEmpty() && cell_name != null) {
				String[] array = {testCellName, formatter.formatCellValue(cell_value)};
				list.add(array);
			}
		}
	}
	
	/** Read from the Excel , the Skill assigned to a character */
	private static void readCharacterDataFromExcelSkills(XSSFSheet sheet, int firstRow, int lastRow, List<String[]> list, int COLUMN) {
		
		for(int i = firstRow; i <= lastRow; i++){
			XSSFRow  row = sheet.getRow(i);
			XSSFCell cell_name = row.getCell(COLUMN);
			String skillName = formatter.formatCellValue(cell_name);
			
			XSSFCell cell_grades = row.getCell(COLUMN + 1);
			String skillGrades = formatter.formatCellValue(cell_grades);
			
			XSSFCell cell_special = row.getCell(COLUMN + 2);
			String skillSpecial = formatter.formatCellValue(cell_special);
			
			XSSFCell cell_category = row.getCell(COLUMN + 3);
			String skillCategory = formatter.formatCellValue(cell_category);
			
			if(cell_name != null && cell_grades != null) {
				String[] array = {skillName, skillGrades, skillSpecial, skillCategory };
				list.add(array);
			}
		}
	}
	
	
	/** Read from the Excel , the Weapons assigned to a character */
	private static boolean readCharacterDataFromExcelWeapons(XSSFSheet sheet, int firstRow, int lastRow, List<List> list, int LEFT_COLUMN, int RIGHT_COLUMN) {
		

		String typeValue = "", nameValue  = "", qualityValue  = "";
		List<List> weapon = new ArrayList<List>();
		List<List> weaponSkills = new ArrayList<List>();
		int COLUMN = 0;
		
		for(int h = 0; h < 2; h++){
			if(h==0){
				COLUMN = LEFT_COLUMN;
			}else if(h==1){
				//This is for the second weapon (if dual wielding)
				weaponSkills = new ArrayList<List>();
				weapon = new ArrayList<List>();
				COLUMN = RIGHT_COLUMN;
			}
				
			for(int i = firstRow; i <= lastRow; i++){
				XSSFRow  row = sheet.getRow(i);
				XSSFCell cell = row.getCell(COLUMN);
				String cellTag = formatter.formatCellValue(cell);
				
				if(cellTag.equals("TYPE")){
					
					XSSFCell weaponTypeCell = row.getCell(COLUMN + 1);
					typeValue = formatter.formatCellValue(weaponTypeCell);
					if(typeValue.isEmpty()){
						return false;
					}
					
				}else if(cellTag.equals("NAME")){
					
					XSSFCell weaponNameCell = row.getCell(COLUMN + 1);
					nameValue = formatter.formatCellValue(weaponNameCell);
					
				}else if(cellTag.equals("QUALITY")){
					
					XSSFCell weaponQualityCell = row.getCell(COLUMN + 1);
					qualityValue = formatter.formatCellValue(weaponQualityCell);
				}
				
				XSSFCell weaponSkillTagCell = row.getCell(COLUMN + 2);
				String skillTagCellValue = formatter.formatCellValue(weaponSkillTagCell);
				if(!skillTagCellValue.isEmpty()){
					XSSFCell weaponSkillValueCell = row.getCell(COLUMN + 3);
					String skillValueCell = formatter.formatCellValue(weaponSkillValueCell);
					List<String> weaponSkill = new ArrayList<String>();
					weaponSkill.add(skillTagCellValue);
					weaponSkill.add(skillValueCell);
					weaponSkills.add(weaponSkill);
				}
				
			}
		
			List details = new ArrayList();
			details.add(typeValue);
			details.add(nameValue);
			details.add(qualityValue);
			
			weapon.add(details);
			weapon.add(weaponSkills);
			list.add(weapon);
		}
		
		return true;
	}
	
	/** Read from the Excel , the Weapons assigned to a character 
	 * @param lastSectionRow */
	private static void readCharacterDataFromExcelDefensiveItems(XSSFSheet sheet, int firstItemRow, int lastItemRow, int lastSectionRow, List<List> list, int LEFT_COLUMN, int RIGHT_COLUMN) {
		
		String typeValue = "", nameValue  = "";
		List<List> item = new ArrayList<List>();
		List<List> itemSkills = new ArrayList<List>();
		int COLUMN = 0;
		int rowToNextItem = 4; //rows to jump until the next item
		
		for(int k = 0; k < 4; k++){//4 rows x 2 columns = 8 ITEMS: from Shield(top left) to Right Ring (bottom right)
			
			for(int h = 0; h < 2; h++){
				if(h==0){
					COLUMN = LEFT_COLUMN;
				}else if(h==1){
					//This is for the second item column
					COLUMN = RIGHT_COLUMN;
				}
				
				boolean saltarItem = false;
				
				int itemFirstRow = firstItemRow + (rowToNextItem * k);
				int itemLastRow = lastItemRow + (rowToNextItem * k);
				
				for(int i = itemFirstRow; i <= itemLastRow && itemLastRow <= lastSectionRow ; i++){
					
					XSSFRow  row = sheet.getRow(i);
					XSSFCell cell = row.getCell(COLUMN);
					String cellTag = formatter.formatCellValue(cell);
					
					if(cellTag.equals("TYPE")){
						
						XSSFCell weaponTypeCell = row.getCell(COLUMN + 1);
						typeValue = formatter.formatCellValue(weaponTypeCell);
						if(typeValue.isEmpty()){
							saltarItem = true;
						}
						
					}else if(cellTag.equals("NAME") && !saltarItem){
						
						XSSFCell weaponNameCell = row.getCell(COLUMN + 1);
						nameValue = formatter.formatCellValue(weaponNameCell);
						
					}
					
					if(!saltarItem){
					
						XSSFCell weaponSkillTagCell = row.getCell(COLUMN + 2);
						String skillTagCellValue = formatter.formatCellValue(weaponSkillTagCell);
						if(!skillTagCellValue.isEmpty()){
							XSSFCell weaponSkillValueCell = row.getCell(COLUMN + 3);
							String skillValueCell = formatter.formatCellValue(weaponSkillValueCell);
							List<String> itemSkill = new ArrayList<String>();
							itemSkill.add(skillTagCellValue);
							itemSkill.add(skillValueCell);
							itemSkills.add(itemSkill);
						}
					
					}
				
				}

				if(!saltarItem){
					List details = new ArrayList();
					details.add(typeValue);
					details.add(nameValue);
					item.add(details);
					item.add(itemSkills);
					list.add(item);
				
					item = new ArrayList<List>();
					itemSkills = new ArrayList<List>();
				}
			}
			
		}
	}
	
}
