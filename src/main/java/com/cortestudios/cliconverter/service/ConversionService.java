package com.cortestudios.cliconverter.service;

import com.cortestudios.cliconverter.model.RequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ConversionService {

    private final ChatClient chatClient;

    public String convert(String inputData, String inputFormat, String outputFormat) {
        RequestModel message = RequestModel.builder()
                .object(inputData)
                .sourceFormat(inputFormat)
                .destinationFormat(outputFormat)
                .build();

        System.out.println("Converting: " + message);

        Map<String, String> response = Map.of("completion",
                Objects.requireNonNull(chatClient.prompt()
                        .user(message.toString()).call().content()));

        System.out.println("Bla bla bla bla");

        return response.get("completion");

    }


}
