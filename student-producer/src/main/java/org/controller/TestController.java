package org.controller;

import org.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public Student firstPage() {

		CallDB c = new CallDB();
		Student stud = c.getStatus();
		return stud;
	}

}