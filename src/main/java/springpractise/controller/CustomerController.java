package springpractise.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springpractise.entity.CustomeFormData;
import springpractise.entity.Customer;
import springpractise.entity.Title;
import springpractise.service.CustomerService;
import springpractise.view.ExcelReport;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value={"customers", "search"})
	public String displayCustomer(@ModelAttribute("customerFormData")@Valid CustomeFormData customerForm, BindingResult result, 
			final Model model){
		if(result.hasErrors()){
			model.addAttribute("customerFormData", customerForm);
			return "customers";
		}
		//Customer customer = customerForm.convert();
		List<Customer> customers = customerService.searchCustomer(customerForm);
		long total = customerService.totalCustomer(customerForm);
		model.addAttribute("pages", total%5 == 0 ? total/5 : total/5 + 1);
		model.addAttribute("customers", customers);
		return "customers";
	}
	
	@RequestMapping(value = "create")
	public String createCustomer(Model model){
		model.addAttribute("titles", Title.getTitles());
		Customer customer = new Customer();
		customer.setGender(true);
		model.addAttribute("customer", customer );
		return "createCustomer";
	}
	@SuppressWarnings("finally")
	@RequestMapping(value = "saveCustomer")
	public ModelAndView createCustomer(@ModelAttribute("customer")@Valid Customer customer, BindingResult result, Model model){
		ModelAndView modelview = null;
		if(result.hasErrors()){
			model.addAttribute("customer", customer);
			model.addAttribute("titles", Title.getTitles());
			if(null != customer.getId()){
				modelview = new ModelAndView("updateCustomer");
			}else{
				modelview = new ModelAndView("createCustomer");
			}
			return modelview;
		}
		try{
			if(null != customer.getId()){
				customerService.updateCustomer(customer);
			}else{
				customerService.insertCustomer(customer);
			}
			modelview = new ModelAndView("redirect:/customers");
		}
		catch(HibernateException ex){
			modelview = new ModelAndView("createCustomer");
			modelview.addObject("customer", customer);
			model.addAttribute("titles", Title.getTitles());
			modelview.addObject("message", "Cannot save Customer");
		}
		finally {
			return modelview;
		}
	}
	
	@RequestMapping(value="updateCustomer")
	public ModelAndView displaySelectedCustomer(@RequestParam("id")Integer id, final Model model){
		Customer customer = customerService.getCustomerById(id);
		ModelAndView modelview = null;
		if (null != customer){
			modelview = new ModelAndView("updateCustomer");
			model.addAttribute("titles", Title.getTitles());
			model.addAttribute("customer", customer);
		}
		return modelview;
	}
	
	@RequestMapping(value = "export")
	public ModelAndView getExcel(){
		List<Customer> customers = customerService.getAll();
		return new ModelAndView(new ExcelReport(), "customers", customers);
	}
	
	@RequestMapping(value = "deleteCustomer")
	public ModelAndView deleteCustomer(@RequestParam String id, final Model model){
		ModelAndView modelview = null;
		try{
			if(null != id){
				String[] ids = id.split(",");
				if (ids.length !=0){
					for (String string : ids) {
						if (!string.trim().equals("")){
							Customer customer = new Customer();
							customer.setId(Integer.parseInt(string));
							customerService.deleteCustomer(customer);
						}
					}
				}
			}
			modelview = new ModelAndView("redirect:/customers");
		}
		catch(HibernateException ex){
			modelview.addObject("message", "Cannot save Customer");
		}
		finally {
			return modelview;
		}
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
