package org.textrpg.config;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class GigaChatConfig {
    final String promtWorld1 = "Расскажи мне, что я придумал, но не используй в ответе слов приветсвия игрока. ";
    final String promtWorld2 = "Представь себя Гейм-Мастером, который должен вести текстовую рпг игру. Придумай фантастический, абсолютно случайный, приключенческий мир, чтобы в дальнейшем общении с тобой можно было исследовать этот мир.";
    final String promtGameMaster = "Помни про придуманный мир (жестокость разрешается) и то, что я ГеймМастер а не игрок и я должен строить историю по отетам игрока, но не сам: ";
}
