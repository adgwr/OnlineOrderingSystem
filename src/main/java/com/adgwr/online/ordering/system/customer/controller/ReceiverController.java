package com.adgwr.online.ordering.system.customer.controller;

import com.adgwr.online.ordering.system.customer.service.ReceiverService;
import com.adgwr.online.ordering.system.domain.Customer;
import com.adgwr.online.ordering.system.domain.Receiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 实现了收货人的Controller
 *
 * @author lyc
 * @version 1.0
 */
@Controller
public class ReceiverController {

    @Autowired
    private ReceiverService receiverService;

    @RequestMapping(value = "prepareModReceiver", method = RequestMethod.GET)
    public String prepareModReceiver(@RequestParam("rId")Integer rId,
                                     Model model) {
        Receiver receiver = receiverService.getReceiverById(rId);
        model.addAttribute("receiver", receiver);
        return "modReceiver";
    }

    @RequestMapping(value = "modifyReceiver", method = RequestMethod.POST)
    public String modifyReceiver(@RequestParam("receiverID")Integer rId,
                                 @RequestParam("receiverName")String receiverName,
                                 @RequestParam("tel")String tel,
                                 @RequestParam("address")String address) {
        receiverService.modifyReceiver(rId,receiverName,address,tel);
        return "redirect:returnToBalance";
    }

    @RequestMapping(value = "addReceiver", method = RequestMethod.GET)
    public String addReceiver() {
        return "addReceiver";
    }

    @RequestMapping(value = "addReceiver", method = RequestMethod.POST)
    public String addReceiver(@RequestParam("receiverName")String receiverName,
                              @RequestParam("tel")String tel,
                              @RequestParam("address")String address,
                              HttpServletRequest request) {
        String cId = ((Customer)request.getSession().getAttribute("customer")).getcId();
        receiverService.addReceiver(cId,receiverName, address, tel);
        return "redirect:returnToBalance";
    }

    @RequestMapping(value = "deleteReceiver", method = RequestMethod.GET)
    public String deleteReceiver(@RequestParam("rId")Integer rId) {
        receiverService.deleteReceiver(rId);
        return "redirect:returnToBalance";
    }
}