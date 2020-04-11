package com.example.demo.service;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.User;
import com.example.demo.util.UploadUtil;

@Service
public class UploadService {
	List<User> userList= new ArrayList<User>();
	private final UploadUtil uploadUtil;
	public UploadService(UploadUtil uploadUtil) {
		this.uploadUtil=uploadUtil;
	}
	
		public /*List<Map<String,String>>*/List<User> upload(MultipartFile file)throws Exception{
			
			Workbook workbook=getWorkBook(file);
			Sheet sheet= workbook.getSheetAt(0);
			Iterator<Row> rows=sheet.iterator();
			rows.next();
			while (rows.hasNext()) {
			User user=new User();
			Row row=rows.next();
			
			user.setId(row.getCell(0).getDateCellValue());
			user.setFirstName(row.getCell(1).getStringCellValue());
			user.setLastName(row.getCell(2).getStringCellValue());
			user.setEmails(row.getCell(3).getStringCellValue());
			user.setPhoneNumber((int)row.getCell(4).getNumericCellValue());
			System.out.println(user);
			userList.add(user);
			System.out.println("userlist===="+userList);
			}
			System.out.println("userlist?????"+userList);
			return userList;
			
			
			/*List<User> tempStudentList = new ArrayList<User>();
			Workbook workbook=getWorkBook(file);
			Sheet worksheet= workbook.getSheetAt(0);
		    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
		        User user = new User();

		        Row row = worksheet.getRow(i);

		        user.setId(row.getCell(0).getNumericCellValue());
				user.setFirstName(row.getCell(1).getStringCellValue());
				user.setLastName(row.getCell(2).getStringCellValue());
				user.setEmails(row.getCell(3).getStringCellValue());
				user.setPhoneNumber(row.getCell(4).getNumericCellValue());
				
		            tempStudentList.add(user);  
		            System.out.println(tempStudentList);
		    }
		    System.out.println(tempStudentList);
			return tempStudentList;*/
			
			
			
			
			
			
			/*Path tempDir = Files.createTempDirectory("");
		 
			File tempFile = tempDir.resolve(file.getOriginalFilename()).toFile();
		
			file.transferTo(tempFile);
		
			Workbook workbook = WorkbookFactory.create(tempFile);
		
			Sheet sheet= workbook.getSheetAt(0);

			//		Stream<Row> rowStream= StreamSupport.stream(sheet.spliterator(), false);
			//		Stream<Row> rowStream= uploadUtil.getStream(sheet);
			Supplier<Stream<Row>> rowStreamSupplier= uploadUtil.getRowStreamSupplier(sheet);

			//		Row headerRow=rowStream.findFirst().get();
			Row headerRow=rowStreamSupplier.get().findFirst().get();
		
		List<String> headerCell = uploadUtil.getStream(headerRow)
				.map(Cell::getStringCellValue).collect(Collectors.toList());
		
		int colCount=headerCell.size();
		
//		System.out.println(headerCell);

		return rowStreamSupplier.get()
		.skip(1)
		.map(row->{
			//given a row,get callStream from it
//			Stream<Cell> cellStream = StreamSupport.stream(row.spliterator(),false);
			
			List<String> cellList = uploadUtil.getStream(row)
					.map(Cell::getStringCellValue)
					.collect(Collectors.toList());
			
			List<String> cellvals = cellStream.map(cell->{
				String cellval = cell.getStringCellValue();
				return cellval;
			}).collect(Collectors.toMap(keyMapper, valueMapper));
			return uploadUtil.cellIteratorSupplier(colCount)
			.get()
			.collect(Collectors.toMap(
					headerCell::get,cellList::get));
			
		})
		.collect(Collectors.toList());*/
//			return null;
	}

		private Workbook getWorkBook(MultipartFile file) {
			Workbook workBook=null;
			String extension=FilenameUtils.getExtension(file.getOriginalFilename());
			try {
				if(extension.equalsIgnoreCase("xlsx")) {
					workBook=new XSSFWorkbook(file.getInputStream());
				}else if(extension.equalsIgnoreCase("xls")) {
					workBook=new HSSFWorkbook(file.getInputStream());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return workBook;
		}

		
}
