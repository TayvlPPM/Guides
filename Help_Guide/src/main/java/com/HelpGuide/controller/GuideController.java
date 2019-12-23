package com.HelpGuide.controller;


import com.HelpGuide.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/guide")
public class GuideController {


    private GuideService guideServiceImpl;

    @Autowired
    public GuideController(GuideService guideServiceImpl) {
        this.guideServiceImpl = guideServiceImpl;
    }

    @GetMapping("get_guide/{url}")
    public ResponseEntity<?> showGuide(@PathVariable String url) {
        return new ResponseEntity<>(guideServiceImpl.getGuide(url),HttpStatus.OK);
    }

    @GetMapping("/{url}")
    public String homePage(@PathVariable String url, Model model){
        model.addAttribute("content",guideServiceImpl.getGuide(url));
        return "guide";
    }

    @GetMapping("/menu")
    public ResponseEntity<?> getHtmlPage() {
        return new ResponseEntity<>(guideServiceImpl.getGuideList(),HttpStatus.OK);
    }
}