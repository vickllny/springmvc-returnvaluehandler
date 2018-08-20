package com.vickllny.returnhandler.controller;

import com.vickllny.returnhandler.annotation.PlanInfoAction;
import com.vickllny.returnhandler.entity.ResultJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("index")
public class DashboardController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DashboardController.class);

    @RequestMapping("first")
    @ResponseBody
    @PlanInfoAction
    public ResultJson first(String msg){
        LOGGER.info("first receive msg============"+msg);
        return new ResultJson(200,"AHhhhhhhhh~  I get the msg");
    }

    @RequestMapping("second")
    @ResponseBody
    public ResultJson second(String msg){
        LOGGER.info("second receive msg============"+msg);
        return new ResultJson(200,"AHhhhhhhhh~  I get the msg");
    }

    @RequestMapping("index")
    public String index(final Model model){
        return "/return/index";
    }
}
