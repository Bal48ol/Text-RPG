package org.textrpg.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.textrpg.config.GigaChatConfig;
import org.jsoup.Jsoup;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.textrpg.service.gigachat.GigaChatService;

import java.io.IOException;
import java.util.Map;

@Tag(name = "GigaChat")
@RestController
@Slf4j
@RequiredArgsConstructor
public class GigaChatController {
    private final GigaChatConfig gigaChatConfig;
    private final GigaChatService gigaChatService;
    private String answer;

    @GetMapping("/init")
    @Operation(summary = "Инициализация")
    public ResponseEntity<String> initWorld() throws IOException {

        String promt1 = gigaChatConfig.getPromtWorld1();

        String promt2 = gigaChatConfig.getPromtWorld2();

        String worldConcept = gigaChatService.getAnswer(promt1, promt2);
        log.info("Концепт: " + worldConcept);

        return ResponseEntity.ok(worldConcept);
    }

    @PostMapping("/answer")
    @Operation(summary = "Получение пересказа статьи")
    public ResponseEntity<String> generateSummary(@RequestBody Map<String, String> choise) throws IOException {
        String manText = choise.get("command");
        log.info("Юзер вписал: " + manText);
        String manTextFinal = Jsoup.parse(manText).text();

        String promt = gigaChatConfig.getPromtGameMaster();
        log.info("Промт: " + promt);
        String promtFinal = Jsoup.parse(promt).text();

        log.info("Ответ старый: " + answer);
        String answerFinal = null;
        if (answer != null){
            answerFinal = Jsoup.parse(answer).text();
        }

        answer = gigaChatService.getAnswer(manTextFinal, promtFinal + answerFinal);
        log.info("Ответ: " + answer);

        return ResponseEntity.ok(answer);
    }
}
