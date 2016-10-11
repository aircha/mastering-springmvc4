package com.aircha.controller;

import com.aircha.common.KRLocalDateFormatter;
import com.aircha.model.ProfileForm;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;

/**
 * Created by 정현 on 2016-10-12.
 */
@Controller
public class ProfileController {

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(ProfileController.class);

    @RequestMapping("/profile")
    public String displayProfile(ProfileForm profileForm) {
        return "profile/profilePage";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String saveProfile(@Valid ProfileForm profileForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "profile/profilePage";
        logger.debug("save ok {}", profileForm);
        return "redirect:/profile";
    }

    @ModelAttribute("dateFormat")
    public String localeFormat(Locale locale) {
        return KRLocalDateFormatter.getPattern(locale);
    }
}
