/*

 */
package com.sgse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Controller
public class IndexController {
    
   
    @RequestMapping(value = "/index.html")
    public String indexPage(){
        return "index";
    }
}
