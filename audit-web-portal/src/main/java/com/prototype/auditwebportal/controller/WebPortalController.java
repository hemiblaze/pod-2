package com.prototype.auditwebportal.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prototype.auditwebportal.feignclients.AuditCheckListProxy;
import com.prototype.auditwebportal.feignclients.AuditSeverityProxy;
import com.prototype.auditwebportal.feignclients.AuthClient;
import com.prototype.auditwebportal.model.AuditDetails;
import com.prototype.auditwebportal.model.AuditRequest;
import com.prototype.auditwebportal.model.AuditResponse;
import com.prototype.auditwebportal.model.AuditType;
import com.prototype.auditwebportal.model.ProjectDetails;
import com.prototype.auditwebportal.model.ProjectManager;
import com.prototype.auditwebportal.model.Questions;
import com.prototype.auditwebportal.model.QuestionsEntity;
import com.prototype.auditwebportal.model.User;

@Controller
public class WebPortalController {

	@Autowired
	AuthClient authClient;
	
	@Autowired
	AuditRequest auditRequest;
	
	@Autowired
	AuditCheckListProxy auditCheckListProxy;
	
	@Autowired
	AuditSeverityProxy auditSeverityProxy;
	
	@GetMapping("/login-page")
	public String loginPage(@ModelAttribute User user){

		
		return "login";
	}
	
	@PostMapping("/home")
	public String getHome(@ModelAttribute("user") User userCredentials ,HttpServletRequest request,ModelMap map) {
		System.out.println(userCredentials.getUserId()+" "+userCredentials.getPassword());
		ResponseEntity<ProjectManager> token = null;
		ProjectManager projectManager = null;
		map.addAttribute("auditType", new AuditType());
		map.addAttribute("projectDetails",new ProjectDetails());
		
		try {
			token = (ResponseEntity<ProjectManager>) authClient.login(userCredentials);
			 projectManager = token.getBody();
			 request.getSession().setAttribute("token", "Bearer " + projectManager.getAuthToken());
			return "home";
		} catch (Exception e) {
			return "error-login";
		}
	}
	
	@PostMapping("/AuditCheckListQuestions")
	public String getResponses(@ModelAttribute("projectDetails") ProjectDetails projectDetails,
			@ModelAttribute("auditType") AuditType auditType,RedirectAttributes redirectAttributes,HttpSession request,ModelMap map){
				List<QuestionsEntity> questions = new ArrayList<>();
				auditRequest.setProjectName(projectDetails.getProjectName());
				auditRequest.setManagerName(projectDetails.getManagerName());
				auditRequest.setOwnerName(projectDetails.getOwnerName());
				try {
					System.out.println("audit type"+auditType);
					questions =  auditCheckListProxy.getQuestions(request.getAttribute("token").toString(), auditType).getBody();
					System.out.println(questions);
					
					
				}catch(IndexOutOfBoundsException e) {
					if (e.getMessage().contains("invalid audit type")) {
						return "internalServerError";
					}
				}
				catch(Exception e) {

					if(e.getMessage().contains("token expired"))
						return "forbidden";
				}
				for(QuestionsEntity question:questions) {
					System.out.println("questions "+question);
					if(question.getResponse()!=null) {
						question.setResponse(null);
					}
					
				}
				Questions questionslist = new Questions();
				questionslist.setQuestionsEntity(questions);
				System.out.println(questionslist.getQuestionsEntity());
				redirectAttributes.addFlashAttribute("questions",questionslist);
				redirectAttributes.addFlashAttribute("auditType",auditType);
				return "redirect:/questions";
					
	}
	@GetMapping("/questions")
	public String getQuestions(@ModelAttribute("questions") Questions
	questions,@ModelAttribute("auditType") AuditType auditType,HttpSession session,ModelMap map) {
		ResponseEntity<?> authResponse=null;
		try {
			
				authResponse = authClient.getValidity(session.getAttribute("token").toString());
//				map.addAttribute("questions", questions);
//				map.addAttribute("auditType",auditType);
				
		}
		catch(Exception e) {
			if(e.getMessage().contains("token expired"))
				return "tokenExpiredPage";
			if(e.getMessage().contains("auth.failed"))
				return "authFailed";
			
			return "redirect:/logout";
		}
		if(authResponse==null) {
			return "tokenExpiredPage";

		}
		return "questions";
		
	}
	
	@PostMapping("/questions")
	public String getResponses(@ModelAttribute("questions") Questions
	questions,HttpSession session ) {
		ResponseEntity<?> authResponse = null;
		List<QuestionsEntity> responseEntity=null;
		List<QuestionsEntity> questionsEntity = questions.getQuestionsEntity();
		try {
			authResponse = authClient.getValidity(session.getAttribute("token").toString());
			System.out.println("after submission "+questionsEntity);
			responseEntity = auditCheckListProxy.saveResponses(session.getAttribute("token").toString(), questionsEntity).getBody();

		}
		catch(Exception e) {
			if(e.getMessage().contains("token expired"))
				return "tokenExpiredPage";
			if(e.getMessage().contains("auth.failed"))
				return "authFailed";
			
			return "redirect:/logout";
		}
		if(authResponse==null || responseEntity==null) {
			return "tokenExpiredPage";

		}
		AuditDetails auditDetails = new AuditDetails(questions.getQuestionsEntity().get(0).getAuditType(),new Date());
		auditRequest.setAuditDetails(auditDetails);
		return "redirect:/status";
	}
	
	@GetMapping("/status")
	public String getProjectExecutionStatus(HttpSession request,ModelMap map) {
		AuditResponse auditResponse = null;
		try {
			auditResponse = auditSeverityProxy.auditSeverity(request.getAttribute("token").toString(),auditRequest).getBody();
			 
		}
		catch(Exception e) {
			if(e.getMessage().contains("string.token.exp"))
				return "tokenExpiredPage";

			return "tokenExpiredPage";
		}
		map.addAttribute("auditResponse",auditResponse);
		return "status";
		
	}
	
	
	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/login-page";
	}

}
