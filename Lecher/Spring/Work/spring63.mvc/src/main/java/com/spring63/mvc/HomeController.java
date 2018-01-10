package com.spring63.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome home! The client locale is {}.");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

    @RequestMapping(value = "/spring/helloworld", method = RequestMethod.GET)
    public String helloworld(Model model) {
        logger.info("/spring/helloworld");             
        model.addAttribute("msg", "Hello, Wordl!!!"  );        
        return "helloworld";
    }

    @RequestMapping(value = "/spring/sayhello", method = RequestMethod.GET)
    public ModelAndView sayhello(Model model) {
        logger.info("/spring/sayhello");             
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sayhello"); // View 이름
        mv.addObject("msg", "Hello, Wordl!!!"); // 데이터 : Model 정보
        
        return mv;
    }
    
    @RequestMapping(value = "/spring/redirect", method = RequestMethod.GET)
    public String redirect(Model model) {        
        return "redirect:/spring/helloworld";        
    }
    
    @RequestMapping(value = "/spring/forward", method = RequestMethod.GET)
    public String forward(Model model) {          
        return "forward:/spring/helloworld";        
    }

    @RequestMapping(value = "/spring/querystring", method = RequestMethod.GET)
    public String querystring(Model model, HttpServletRequest request) {          
        String name  = request.getParameter("name");
        String price = request.getParameter("price");
        
        model.addAttribute("name", name);
        model.addAttribute("price", price);
                
        return "querystring";
    }
    @RequestMapping(value = "/spring/querystring2", method = RequestMethod.GET)
    public String querystring2(Model model
                              , @RequestParam( value="name" , defaultValue=""  ) String name
                              , @RequestParam( value="price", defaultValue="0" ) int price   ) {          
               
        model.addAttribute("name", name);
        model.addAttribute("price", price);
                
        return "querystring";
    }

    @RequestMapping(value = "/spring/querypath/{name}", method = RequestMethod.GET)
    public String querypath(Model model
                           , @PathVariable(value="name") String name ) {          
               
        model.addAttribute("name", name);
                
        return "querystring";
    }

}
