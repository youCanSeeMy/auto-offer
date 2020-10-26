package zy.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import zy.core.model.ResponseData;
import zy.user.entity.ShareSysAccount;
import zy.user.service.IShareSysAccountService;

import java.util.List;

/**
 * <p>
 * 登录账号 前端控制器
 * </p>
 *
 * @author zy
 * @since 2020-08-31
 */
@RestController
@RequestMapping("/user/account")
public class ShareSysAccountController {
    @Autowired
    IShareSysAccountService accountService;

    @RequestMapping(path = "/list",method = RequestMethod.GET)
    public ResponseData list(){
        List<ShareSysAccount> list = accountService.list();
        return ResponseData.success(list);
    }
}
