package ch.leibacher.theraconnect.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class VoiceflowAPIIntegration {

    public static void main(String[] args) {
        String projectId = "SECRET";
        String apiToken = "SECRET";

        try {
            // Replace with your actual Voiceflow API endpoint
            String apiUrl = "https://api.voiceflow.com/v1/projects/" + projectId + "/interact";

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set headers
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + apiToken);
            connection.setDoOutput(true);

            // Construct your JSON payload if needed
            String payload = "{\"user_id\": \"user123\", \"request\": {\"type\": \"text\", \"payload\": \"Hello\"}}";

            // Send the request
            connection.getOutputStream().write(payload.getBytes());

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println("Response: " + response.toString());
            } else {
                System.out.println("Request failed with response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}