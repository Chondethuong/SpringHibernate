package springpractise.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import springpractise.entity.Customer;
import springpractise.service.CustomerService;

public class ExcelReport extends AbstractXlsView{
	
	@Autowired
	CustomerService customerService;
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"customersReport.xls\"");

        @SuppressWarnings("unchecked")
        List<Customer> customers = (List<Customer>) model.get("customers");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("Customer List");

        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Name");
        header.createCell(1).setCellValue("Date of Birth");
        header.createCell(2).setCellValue("Phone");
        header.createCell(3).setCellValue("Email");
        header.createCell(4).setCellValue("Gender");
        header.createCell(5).setCellValue("Address");
        header.createCell(6).setCellValue("Title");
        // Create data cells
        int rowCount = 1;
        for (Customer customer : customers){
            Row courseRow = sheet.createRow(rowCount++);
            courseRow.createCell(0).setCellValue(customer.getName().trim());
            courseRow.createCell(1).setCellValue(customer.getDob().toString());
            courseRow.createCell(2).setCellValue(customer.getPhone().trim());
            courseRow.createCell(3).setCellValue(customer.getEmail().trim());
            courseRow.createCell(4).setCellValue(customer.getGender() ? "Male" : "Female");
            courseRow.createCell(5).setCellValue(customer.getAddress().trim());
            courseRow.createCell(6).setCellValue(customer.getTitle().trim());
        }
		
	}

}
