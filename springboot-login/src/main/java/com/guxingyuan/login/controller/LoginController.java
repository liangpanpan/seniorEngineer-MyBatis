package com.guxingyuan.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URL;

/**
 * <pre>
 * @Describe
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/6/1       create this file
 * </pre>
 */
@RestController
public class LoginController {

    @GetMapping(value = {"/", ""})
    public void toLogin(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String referer = req.getHeader("Referer");
        URL url = new URL(referer);

        String baseUrl = "";
        if (url.getPort() == -1) {
            baseUrl = url.getProtocol() + "://" + url.getHost() + "/";

        } else {
            baseUrl =
                    url.getProtocol() + "://" + url.getHost() + ":" + url.getPort() + "/";

        }

        HttpSession session = req.getSession();
        String loginUrl = "";
        if (session.getAttribute("userId") == null) {
            resp.sendRedirect(baseUrl + loginUrl);
            return;
        } else {
            session.removeAttribute("curUser");
            session.removeAttribute("realName");
            session.removeAttribute("userId");
            resp.sendRedirect(baseUrl + loginUrl);
            return;
        }
    }

}
