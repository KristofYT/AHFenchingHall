package com.aihui.fenchinghall.controller;


import com.aihui.fenchinghall.model.Notice;
import com.aihui.fenchinghall.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/notice",method = RequestMethod.GET)
    public ModelAndView notice(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        Notice notice = noticeService.findNoticeById(1);
        String noticeMeg = notice.content;
        modelAndView.addObject("noticeMeg", noticeMeg);
        modelAndView.setViewName("notice");
        return modelAndView;
    }

    @RequestMapping(value = "/bgnotice",method = RequestMethod.GET)
    public ModelAndView bgnotice(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        Notice notice = noticeService.findNoticeById(1);
        String noticeMeg = notice.content;
        modelAndView.addObject("bgnoticeMeg", noticeMeg);

        Notice news = noticeService.findNoticeById(2);
        String bgnewsMeg = news.content;
        modelAndView.addObject("bgnewsMeg", bgnewsMeg);
        modelAndView.setViewName("bgnotice");
        return modelAndView;
    }

    @PostMapping(value = "/bgnotice")// save appointment
    public String saveNotice(@RequestParam String ntcontent) {
        System.out.println( " saveNotice  ntcontent = " + ntcontent);
        if( ntcontent == null ){
            return "failed";
        }
        Notice notice = new Notice();
        notice.id = 1;
        notice.content = ntcontent;
        noticeService.saveNotice(notice);
        return "success";
    }

    @RequestMapping(value = "/news",method = RequestMethod.GET)
    public ModelAndView news(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        Notice notice = noticeService.findNoticeById(2);
        String newsMeg = notice.content;
        modelAndView.addObject("newsMeg", newsMeg);
        modelAndView.setViewName("news");
        return modelAndView;
    }

    @PostMapping(value = "/bgnews")// save appointment
    public String saveNews(@RequestParam String newscontent) {
        System.out.println( " saveNews  newscontent = " + newscontent);
        if( newscontent == null ){
            return "failed";
        }
        Notice notice = new Notice();
        notice.id = 2;
        notice.content = newscontent;
        noticeService.saveNotice(notice);
        return "success";
    }


}
