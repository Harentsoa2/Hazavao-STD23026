package shool.hei.hazavao.endpoint.rest.controller.health;

import com.shahabkondri.chatgpt.api.model.ChatGptRequest;
import com.shahabkondri.chatgpt.api.model.MessageRole;
import com.shahabkondri.chatgpt.api.model.TextCompletionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shool.hei.hazavao.service.ChatService;

import java.util.List;

@RestController
public class HazavaoHealthController {
    @Autowired
    private ChatService chatService;

    @GetMapping("/hazavao")
    public String hazavao(@RequestParam String teny) {
        TextCompletionModel model = TextCompletionModel.GPT_3_5_TURBO;
        List<ChatGptRequest.Message> messages = List.of(new ChatGptRequest.Message(MessageRole.USER, "donner la definition en Malagasy de" + teny));
        ChatGptRequest request = new ChatGptRequest(model, messages);
        return chatService.chat(request);
    }
}
