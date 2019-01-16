package com.lookingforstar.server.controller;

import com.lookingforstar.server.model.TwitterItem;
import com.lookingforstar.server.service.TwitterCrawlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class TwitterController {

    @Autowired
    TwitterCrawlService twitterCrawlService;

    List<TwitterItem> twitList;

    @RequestMapping("/twitter")
    public ModelAndView twitterResponse(HttpServletRequest request, HttpServletResponse response,
                                        @ModelAttribute("choice") String choice) throws IOException {
        System.out.println("twitter choice = " + choice);
        ModelAndView mv = new ModelAndView();

        choice = "redvelvet";

        twitList = twitterCrawlService.TwitterCrawling(choice,"english");
        mv.addObject("twit_result", twitList);
        mv.setViewName("/twitter");

        mv.addObject("choice", choice);
        mv.setViewName("/twitter");
        return mv;
    }
}
