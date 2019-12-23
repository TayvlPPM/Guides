package com.HelpGuide.controller;


import com.HelpGuide.Service.GuideService;
import com.HelpGuide.dto.GuideDTO;
import com.HelpGuide.dto.GetGuideRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/guide")
public class GuideController {

    private GuideService guideServiceImpl;

    @Autowired
    public GuideController(GuideService guideServiceImpl) {
        this.guideServiceImpl = guideServiceImpl;
    }

    @GetMapping("/{url}")
    public ResponseEntity<?> showGuide(@PathVariable String url) {
        GetGuideRequest getGuideRequest = new GetGuideRequest(url);
        return new ResponseEntity<>(guideServiceImpl.getGuide(getGuideRequest),HttpStatus.OK);
    }

    @PostMapping("add")
    @ResponseBody
    public GuideDTO addNewTask () {
        return guideServiceImpl.saveGuide();
    }

    @GetMapping("/home")
    public String homePage(){
        return "guide";
    }
    @GetMapping("/menu")
    public ResponseEntity<?> getHtmlPage() {
        return new ResponseEntity<>(guideServiceImpl.getGuideList(),HttpStatus.OK);
    }
}