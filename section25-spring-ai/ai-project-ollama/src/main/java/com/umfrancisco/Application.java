package com.umfrancisco;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;

public class Application {
	
	public static void main(String[] args) {
		Model[] models = {
				new Model("phi3:mini", 2.2), 
				new Model("smallthinker:3b", 3.6), 
				new Model("qwen3.5:9b", 6.6)
		};
		int index = 0;
		
		ChatLanguageModel model = OllamaChatModel.builder()
				.baseUrl(Port.IPv4)
				.modelName(models[index].name())
				.timeout(Duration.ofMinutes(2))
				.temperature(0.7)
				.logRequests(true)
				.logResponses(true)
				.build();
		
		String p1 = "What is your name?";
        String p2 = "Quote a sentence from Rainer Maria Rilke";
        String p3 = "Quote a sentence from Rilke in german";
        String p4 = "Quote a sentence from Federico Garcia Lorca";
        String p5 = "Quote a sentence from Federico Garcia Lorca in spanish";
        
        chat(model, p1, models[index]);
        chat(model, p2, models[index]);
        chat(model, p3, models[index]);
        chat(model, p4, models[index]);
        chat(model, p5, models[index]);
	}
	
	public static void chat(ChatLanguageModel model, String prompt, Model m) {
		System.out.println("["+getDateTime()+"] Prompt: " + prompt);
        System.out.println("-- Sending request to %s -- ".formatted(m.name()));
        
        try {
            String response = model.generate(prompt);
            System.out.println("\n["+getDateTime()+"] Response:\n"+response+"\n");
        } catch (Exception e) {
            System.err.println("Error communicating with Ollama: " + e.getMessage());
            System.err.println("Ensure Ollama is actively running on port 9090 and the model is pulled.");
        }
	}
	
	public static String getDateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return now.format(formatter);
	}
}
