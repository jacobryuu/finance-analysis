package com.finace.us.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finace.us.domain.SPYDataEntry;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class SPYDataService {

    @Value("${nasdaq.api.key}")
    private String apiKey;

    @Value("${nasdaq.api.endpoint}")
    private String apiEndpoint;

    public List<SPYDataEntry> getSPYData() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(apiEndpoint + "?assetclass=etf&fromdate=2023-04-01&todate=2023-04-02&limit=100");
        request.addHeader("accept", "application/json");
        request.addHeader("Authorization", apiKey);

        SPYDataEntry[] dataEntries = httpClient.execute(request, httpResponse -> {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(httpResponse.getEntity().getContent(), SPYDataEntry[].class);
        });

        return Arrays.asList(dataEntries);
    }
}
