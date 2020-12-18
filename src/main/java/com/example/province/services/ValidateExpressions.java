package com.example.province.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.*; 

@Service
@Transactional
public class ValidateExpressions {
	public boolean isValidName(String name) {
		// Regex to check valid username. 
        String regex = "^[A-Za-z]*\\S+.*\\w{5,29}$";
        // Compile the ReGex 
        Pattern p = Pattern.compile(regex);
        
        // Pattern class contains matcher() method 
        // to find matching between given username 
        // and regular expression. 
        Matcher m = p.matcher(name); 
  
        // Return if the username 
        // matched the ReGex 
        return m.matches(); 
	}
}
