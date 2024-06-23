package com.student.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.student.Entity.EStudent;
import com.student.respo.ICourse;
import com.student.respo.iservice;

@Controller
public class StudentController {
    
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final ICourse icourse;
    private final iservice respo;
    @Autowired
    private EmailController emailController;

    @Autowired
    public StudentController(ICourse icourse, iservice respo) {
        this.icourse = icourse;
        this.respo = respo;
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("courses", icourse.findAll());
        model.addAttribute("stu", new EStudent());
        icourse.findAll().forEach(course -> logger.info(course.toString()));
        return "registration";
    }

    @PostMapping("/save")
    public ModelAndView setSave(EStudent eStudent) {
        ModelAndView mav = new ModelAndView();
        boolean register = respo.SaveRegister(eStudent);

        if (register && eStudent.getId() != null) {
            logger.info("Student registered with ID: " + eStudent.getId());
            mav.addObject("stu", eStudent);
            mav.addObject("succmsg", "Congratulations! " + eStudent.getName());
            emailController.sendEmail(eStudent.getEmail(),
            		
            		 "<html>"
            	                + "<body>"
            	                + "<h1>Hello,</h1>"
            	                + "<p>This is a Register Successfully.</p>"
            	                + "<table border='1' style='border-collapse: collapse;'>"
            	                + "<tr><th>Student ID</th><td>" + eStudent.getId() + "</td></tr>"
            	                + "<tr><th>Name</th><td>" + eStudent.getName() + "</td></tr>"
            	                + "<tr><th>Mobile</th><td>" + eStudent.getMobile() + "</td></tr>"
            	                + "<tr><th>Email</th><td>" + eStudent.getEmail() + "</td></tr>"
            	                + "<tr><th>Gender</th><td>" + eStudent.getGender() + "</td></tr>"
            	                + "<tr><th>Course</th><td>" + eStudent.getCourse() + "</td></tr>"
            	                + "<tr><th>Timing</th><td>" + eStudent.getTiming() + "</td></tr>"
            	                + "</table>"
            	                + "<p>Best regards,<br>Your Company</p>"
            	                + "</body>"
            	                + "</html>");	
            mav.setViewName("reg_success");
        } else {
            mav.setViewName("reg_failure"); 
        }

        return mav;
    }
    
    @GetMapping("/home")
    public String getUser(Model model) {
    	List<EStudent> list = respo.Registed();
    	model.addAttribute("student",list);
    	return "users";
    }
}
