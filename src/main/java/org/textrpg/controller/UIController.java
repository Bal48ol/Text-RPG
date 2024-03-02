package org.textrpg.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Tag(name = "GigaChat")
@Controller
@Slf4j
@RequiredArgsConstructor
public class UIController {

    @GetMapping("/")
    @Operation(summary = "Стартовая страница консоли")
    public String getConsole(Model model){
        model.addAttribute("title", "The Chronicles of Eldreth");
        return "console";
    }
}
