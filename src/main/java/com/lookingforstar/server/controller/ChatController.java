package com.lookingforstar.server.controller;

import com.lookingforstar.server.dao.ChatsDao;
import com.lookingforstar.server.dao.UserDao;
import com.lookingforstar.server.model.User;
import com.lookingforstar.server.service.RandomNameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class ChatController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RandomNameService randomNameService;

    @Autowired
    private UserDao _userDao;

    @Autowired
    private ChatsDao _chatDao;

    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public ModelAndView createUser(HttpServletRequest request,
                                   RedirectAttributes redirectAttributes, @RequestParam("choice") String choice, @RequestParam("language") String lang) {
        String name="";
        try {
            // User 객체 생성
            User user = new User();
            // (익명 아이디 부여)
            name = randomNameService.getRandomName();
            // User=> [Name, Time] 설정
            user.setName(name);
            user.setTimestamp(new Date().getTime());

            System.out.println("-------------"+_userDao.getByName(name));

            // save user in db (if new)
            // 만약에 새로운 user라면 DB 저장함.

            _userDao.save(user); // DB 객체 저장


        } catch (Exception e) {
            logger.error("Exception in creating user: ", e.getStackTrace());
        }
        redirectAttributes.addFlashAttribute("name", name);
        redirectAttributes.addAttribute("choice", choice);
        redirectAttributes.addAttribute("language", lang);

        return new ModelAndView("redirect:/feed");
    }

}
