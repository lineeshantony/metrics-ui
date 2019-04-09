package com.barclays.metrics.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Component;

@Component
public class APIInvoker {

	public String callAPI(String apiURL) throws ClientProtocolException, IOException {
		if (apiURL.contains("/org?")) {
			return "{\"tc-1\":124, \"tc-2\":121}";
		} else if (apiURL.contains("/org/tc-1?")) {
			return "{\"geo-1\":124, \"geo-2\":121, \"geo-3\":121}";
		} else if (apiURL.contains("/org/tc-1/geo-1?")) {
			return "{\"pro-1\":124, \"pro-2\":121}";
		} else if (apiURL.contains("/org/tc-1/geo-1/pro-1?")) {
			return "{\"repo-1\":124, \"repo-2\":121, \"repo-3\":121}";
		} else {
			return "";
		}
		/*System.out.println("Inside callAPI");
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(apiURL);
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line;
		String allData = "";
		while ((line = rd.readLine()) != null) {
			allData = allData + line;
		}
		return allData;*/
	}
}
