package com.epam;


import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContentPrinter {

    public static void main(String[] args) throws UnsupportedOperationException, IOException {

        if (args.length==0) {
            System.out.println("Please, add url argument!");
            return;
        }

        String url = args[0];

        HttpResponse response = getHttpResponse(url);

        printContent(response);

    }

    private static HttpResponse getHttpResponse(String url) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        return client.execute(request);
    }

    private static void printContent(HttpResponse response) throws IOException {
    	
        System.out.println(IOUtils.toString(response.getEntity().getContent()));
    }

}
