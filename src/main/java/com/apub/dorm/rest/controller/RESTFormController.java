package com.apub.dorm.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apub.dorm.domain.CheckInForm;
import com.apub.dorm.domain.CheckOutForm;
import com.apub.dorm.domain.Student;
import com.apub.dorm.service.CheckInService;
import com.apub.dorm.service.CheckOutService;
import com.apub.dorm.service.StudentService;;

@RestController
@RequestMapping("/api/form")
public class RESTFormController {
	
	@Autowired 
	private CheckInService checkInService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CheckOutService checkOutService;
	
	@RequestMapping(value="/checkin/{id}",method=RequestMethod.GET)
	public List<CheckInForm> getAllCheckInForm(@PathVariable("id") int id){
			Student student = studentService.findOne(id); 
			return checkInService.findByStudent(student);
	}
	
	@RequestMapping(value="/checkout/{id}",method=RequestMethod.GET)
	public List<CheckOutForm> getAllCheckOutForm(@PathVariable("id") int id){
			Student student = studentService.findOne(id); 
			return checkOutService.findByStudent(student);
	}
}
