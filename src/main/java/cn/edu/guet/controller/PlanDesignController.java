package cn.edu.guet.controller;

import cn.edu.guet.common.ResponseData;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.PlanDesignService;

import java.util.ResourceBundle;

@Controller
public class PlanDesignController {

    private PlanDesignService planDesignService;

    public void setPlanDesignService(PlanDesignService planDesignService) {
        this.planDesignService = planDesignService;
    }
    /**/
    @RequestMapping("/selectRouteCableList")
    public ResponseData selectRouteCableList(){
        return planDesignService.selectRouteCableList();
    }
}
