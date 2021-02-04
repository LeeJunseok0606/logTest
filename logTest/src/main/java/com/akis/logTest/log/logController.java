package com.akis.logTest.log;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ObjectMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/log/*")
public class logController {

	private static Logger log = LogManager.getLogger(logController.class);

	
	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Map<String, String> map = new TreeMap();
		map.put("name", "Junseok");
		map.put("email", "junseok.lee@aekyung.kr");
		ObjectMessage msg = new ObjectMessage(map);
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		map.put("time", formattedDate);
		
		
		log.info(msg);
		return "home";
	}
}
