package com.lookingforstar.server.controller;

import com.lookingforstar.server.model.AlbumItem;
import com.lookingforstar.server.service.AlbumCrawlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProfileController {

    @Autowired
    AlbumCrawlService albumCrawlService;

    List<AlbumItem> albumList;

    @RequestMapping("/profile")
    public ModelAndView sendResult(HttpServletRequest request, HttpServletResponse response,
                                   @ModelAttribute("choice") String choice,
                                   @RequestParam(value = "items", required = false, defaultValue = "26") String items) throws IOException {
        ModelAndView mv = new ModelAndView();

        albumList =new ArrayList<AlbumItem>();

        choice = "redvelvet";

        albumList = albumCrawlService.AlbumCrawling(choice);
        mv.addObject("album_result", albumList);

        mv.setViewName("/profile");

        mv.addObject("choice", choice);



        return mv;
    }

}
