package com.umfrancisco;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;

public class Application {
	
	public static void main(String[] args) {
		ChatLanguageModel model = OllamaChatModel.builder()
				.baseUrl("http://192.168.15.6:9090")
				.modelName("phi3:mini")
				.timeout(Duration.ofMinutes(2))
				.temperature(0.7)
				.logRequests(true)
				.logResponses(true)
				.build();
		
		String prompt1 = "What is your name?";
        String prompt2 = "Quote Shakespeare";
        
        chat(model, prompt1);
        chat(model, prompt2);
	}
	
	public static String getDateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return now.format(formatter);
	}
	
	public static void chat(ChatLanguageModel model, String prompt) {
		System.out.println("["+getDateTime()+"] Prompt: " + prompt);
        System.out.println("-- Sending request to Ollama --");
        
        try {
            String response = model.generate(prompt);
            System.out.println("\n["+getDateTime()+"] Response:\n"+response+"\n");
        } catch (Exception e) {
            System.err.println("Error communicating with Ollama: " + e.getMessage());
            System.err.println("Ensure Ollama is actively running on port 9090 and the model is pulled.");
        }
	}
}
