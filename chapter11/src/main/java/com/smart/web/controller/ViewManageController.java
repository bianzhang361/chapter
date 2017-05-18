package com.smart.web.controller;

import com.smart.domain.ViewSpace;
import com.smart.service.ViewSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/5/18.
 */
@Controller
public class ViewManageController extends BaseController {

    @Autowired
    private ViewSpaceService viewSpaceService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String listViewSpaces(HttpServletRequest request) {
        List<ViewSpace> viewSpaces = viewSpaceService.getAllViewSpace();
        request.setAttribute("viewSpaces", viewSpaces);
        return "/listViewSpaces";
    }
}
