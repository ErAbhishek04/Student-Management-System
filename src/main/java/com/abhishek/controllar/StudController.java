package com.abhishek.controllar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.abhishek.entity.Student;
import com.abhishek.service.StudService;

import antlr.collections.List;




@Controller

public class StudController {
	
	@Autowired
	private StudService service;
	
	@GetMapping("/")
	public String home(Model m) {
		
		java.util.List<Student> stud =service.getAllStud();
		m.addAttribute("stud",stud);
		return "index";
	}
	@GetMapping("/addstudent")
public String addStud() {
		
		return "add_student";
	}
	@PostMapping("/register")
public String studReg(@ModelAttribute Student e,HttpSession session) {
		System.out.println(e);
	
		service.addStud(e);
		session.setAttribute("msg", "Student Entry Added Successfully");
		
		return "redirect:/";
		
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		
		Student e = service.getStudById(id);
		
		m.addAttribute("stud",e);
		
		
		return "edit";
		
		
	}
	
	@PostMapping("/update")
	public String updateStud(@ModelAttribute Student e,HttpSession session) {
			service.addStud(e);
			session.setAttribute("msg", "Student Data Updated Successfully");
			return "redirect:/";
			
		}
	@GetMapping("/delete/{id}")
	public String deleteStud(@PathVariable int id,HttpSession session) {
		
		service.deleteEmp(id);
		session.setAttribute("msg", "Student Data Deleted Successfully");
		return "redirect:/";
		
	}
	
	
}
