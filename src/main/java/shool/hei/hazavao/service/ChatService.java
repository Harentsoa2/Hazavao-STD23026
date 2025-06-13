package shool.hei.hazavao.service;

import com.shahabkondri.chatgpt.api.client.ChatGptClient;
import com.shahabkondri.chatgpt.api.model.ChatGptRequest;
import com.shahabkondri.chatgpt.api.model.ChatGptResponse;
import com.shahabkondri.chatgpt.api.model.MessageRole;
import com.shahabkondri.chatgpt.api.model.TextCompletionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatGptClient chatGptClient;

    public String chat(ChatGptRequest chatGptRequest) {
        return chatGptClient.completions(chatGptRequest)
                .filter(response -> response.choices().get(0).delta().content() != null)
                .map(response -> response.choices().get(0).delta().content())
                .collectList()
                .map(list -> String.join("", list))
                .block();
    }
}