package com.inn.main.exampleLogger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class LoggingController {
	Logger logger = LoggerFactory.getLogger(LoggingController.class);
	 @RequestMapping("/")
	  public String index() {
		    logger.trace("This is a TRACE message.");
		    logger.debug("This is a DEBUG message.");
		    logger.info("This is an INFO message.");
		    logger.warn("This is a WARN message.");
		    logger.error("You guessed it, an ERROR message.");
	    return "Welcome to Spring Logging!";
	  }
}
