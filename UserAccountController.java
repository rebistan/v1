package com.Alansari.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import com.Alansari.entity.Clients;
import com.Alansari.entity.ConfirmationToken;
import com.Alansari.entity.Fleets;
import com.Alansari.entity.User;
import com.Alansari.repository.ConfirmationTokenRepository;
import com.Alansari.repository.UserRepository;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/*
 * Author Rebistan
 * 
 */

@Controller
public class UserAccountController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	
	/*
	 * Registration
	 */
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView displayRegistration(ModelAndView modelAndView, User user) {
		modelAndView.addObject("user", user);
		modelAndView.setViewName("register");	
	    return modelAndView;	
	}
    /*
     * 	generating OTP 
     */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView registerUser(ModelAndView modelAndView, User user) throws IOException, UnirestException {		
		User existingUser = userRepository.findByQidIgnoreCase(user.getQid());
		if(existingUser != null) {
			modelAndView.addObject("message","This Qid already exists!");
			modelAndView.setViewName("error");
		} else {
			user.setPassword(encoder.encode(user.getPassword()));
			userRepository.save(user);			
			ConfirmationToken confirmationToken = new ConfirmationToken(user);
			confirmationTokenRepository.save(confirmationToken);
		    System.out.println(confirmationToken.getConfirmationToken());	    			
	
		//	+"http://localhost:8082/confirm-account?token="+confirmationToken.getConfirmationToken());
			
		    HttpResponse<String> response = Unirest.post("https://telesign-telesign-send-sms-verification-code-v1.p.rapidapi.com/sms-verification-code?phoneNumber="+user.getPhone()+"&verifyCode="+confirmationToken.getConfirmationToken())
		    		.header("x-rapidapi-host", "telesign-telesign-send-sms-verification-code-v1.p.rapidapi.com")
		    		.header("x-rapidapi-key", "35e6e42600msh5b4db7a605d60c6p10a1adjsnf6b91daff5f8")
		    		.header("content-type", "application/x-www-form-urlencoded")
		    		.asString();  
		    
			modelAndView.addObject("qid", user.getQid());	
			modelAndView.setViewName("successfulRegisteration");
		}
		
		return modelAndView;
	}

	/*
	 * OTP verification
	 */
	@RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token")String confirmationToken) {
		ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
		
		if(token != null)
		{
			User user = userRepository.findByQidIgnoreCase(token.getUser().getQid());
			user.setEnabled(true);
			userRepository.save(user);
			modelAndView.setViewName("accountVerified");
		}
		else
		{
			modelAndView.addObject("message","The link is invalid or broken!");
			modelAndView.setViewName("error");
		}
		
		return modelAndView;
	}	

   /*
    * Login 
    */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView displayLogin(ModelAndView modelAndView, User user) {
		modelAndView.addObject("user", user);
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginUser(ModelAndView modelAndView, User user) {
		
		User existingUser = userRepository.findByQidIgnoreCase(user.getQid());
		if(existingUser != null) {
		
			if (encoder.matches(user.getPassword(), existingUser.getPassword())){
				modelAndView.addObject("message", "Successfully logged in!");
				modelAndView.setViewName("successLogin");
			} else {
				modelAndView.addObject("message", "Incorrect password. Try again.");
				modelAndView.setViewName("login");
			}
		} else {	
			modelAndView.addObject("message", "The Qid provided does not exist!");
			modelAndView.setViewName("login");

		}
		
		return modelAndView;
	}
	
	 /*
	  * Resetting Password
	  */
	@RequestMapping(value="/forgot-password", method=RequestMethod.GET)
	public ModelAndView displayResetPassword(ModelAndView modelAndView, User user) {
		modelAndView.addObject("user", user);
		modelAndView.setViewName("forgotPassword");
		return modelAndView;
	}

	/*
	 * Generating OTP
	 */
	
	@RequestMapping(value="/forgot-password", method=RequestMethod.POST)
	public ModelAndView forgotUserPassword(ModelAndView modelAndView, User user) throws UnirestException {
		User existingUser = userRepository.findByQidIgnoreCase(user.getQid());
		if(existingUser != null) {
			ConfirmationToken confirmationToken = new ConfirmationToken(existingUser);
			confirmationTokenRepository.save(confirmationToken);
						
	//	"To complete the password reset process, please click here: "
	//		+"http://localhost:8082/confirm-reset?token="+confirmationToken.getConfirmationToken());
			
			
			 HttpResponse<String> response = Unirest.post("https://telesign-telesign-send-sms-verification-code-v1.p.rapidapi.com/sms-verification-code?phoneNumber="+user.getPhone()+"&verifyCode="+confirmationToken.getConfirmationToken())
			    		.header("x-rapidapi-host", "telesign-telesign-send-sms-verification-code-v1.p.rapidapi.com")
			    		.header("x-rapidapi-key", "sHr1Al5YeEmshTbA3Qm2YPfrzrSZp1x8MKujsnCJrMsalveWcY")
			    		.header("content-type", "application/x-www-form-urlencoded")
			    		.asString();   
			
			modelAndView.addObject("message", "Request to reset password received. Check your inbox for the reset link.");
			modelAndView.setViewName("successForgotPassword");

		} else {	
			modelAndView.addObject("message", "This email does not exist!");
			modelAndView.setViewName("error");
		}
		
		return modelAndView;
	}

    /*
     * OTP verification
     */
	@RequestMapping(value="/confirm-reset", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView validateResetToken(ModelAndView modelAndView, @RequestParam("token")String confirmationToken)
	{
		ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
		
		if(token != null) {
			User user = userRepository.findByQidIgnoreCase(token.getUser().getQid());
			user.setEnabled(true);
			userRepository.save(user);
			modelAndView.addObject("user",user);
			modelAndView.addObject("qid", user.getQid());
			modelAndView.setViewName("resetPassword");
		} else {
			modelAndView.addObject("message", "The link is invalid or broken!");
			modelAndView.setViewName("error");
		}
		
		return modelAndView;
	}	

	/**
	 * Receive the token from the link sent via phone and display form to reset password
	 */
	@RequestMapping(value = "/reset-password", method = RequestMethod.POST)
	public ModelAndView resetUserPassword(ModelAndView modelAndView, User user) {
		
		if(user.getQid() != null) {
		
			User tokenUser = userRepository.findByQidIgnoreCase(user.getQid());
			tokenUser.setEnabled(true);
			tokenUser.setPassword(encoder.encode(user.getPassword()));
			
			userRepository.save(tokenUser);
			modelAndView.addObject("message", "Password successfully reset. You can now log in with the new credentials.");
			modelAndView.setViewName("successResetPassword");
		} else {
			modelAndView.addObject("message","The link is invalid or broken!");
			modelAndView.setViewName("error");
		}
		
		return modelAndView;
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}
	
	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public ConfirmationTokenRepository getConfirmationTokenRepository() {
		return confirmationTokenRepository;
	}

	public void setConfirmationTokenRepository(ConfirmationTokenRepository confirmationTokenRepository) {
		this.confirmationTokenRepository = confirmationTokenRepository;
	}
}
