package com.lookingforstar.server.controller;

import com.lookingforstar.server.model.YouTubeItem;
import com.lookingforstar.server.service.YouTubeApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class YoutubeController {

    @Autowired
    YouTubeApiService youtubeService;

    private static final Logger logger = LoggerFactory.getLogger(YoutubeController.class);

    @RequestMapping("/youtube")
    public ModelAndView youtubeResponse(HttpServletRequest request, HttpServletResponse response,
                                        @ModelAttribute("choice") String choice,
                                        @RequestParam(value = "items", required = false, defaultValue = "26") String items) throws IOException {
        String select = request.getParameter("select");

        System.out.println("youtube choice = " + choice);
        System.out.println("youtube select = " + select);

        ModelAndView mv = new ModelAndView();

        choice = "redvelvet";

        List<YouTubeItem> youtuberesult;
        int max = Integer.parseInt(items);

        if (choice != null && select != null) {
            youtuberesult = youtubeService.youTubeSearch(choice, select, max);
            mv.addObject("youtube", youtuberesult);
            mv.setViewName("/youtube");
        }
        else if (choice != null && select == null)  {
            youtuberesult = youtubeService.youTubeSearch(choice, max);
            mv.addObject("youtube", youtuberesult);
            mv.setViewName("/youtube");
        }

        mv.addObject("choice", choice);
        mv.addObject("select", select);

//        setCookie(request,response);

        return mv;
    }

}
