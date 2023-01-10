package com.example.springbootstarter.saml.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IdentityProviderController {
    @GetMapping
    public String selectProvider() {
        log.info("Sample IDP Application - Select an SP to log into!");
        return "redirect:/saml/idp/select";
    }

}
