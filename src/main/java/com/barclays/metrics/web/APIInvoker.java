package com.barclays.metrics.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class APIInvoker {

	public void callAPI() throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(
				"http://97.64.189.84:9000/metrics/build/duration/org/Cards/US/CardNG?fromDate=2019-01-01&toDate=2019-05-01");
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line;
		String allData = "";
		while ((line = rd.readLine()) != null) {
			allData = allData + line;
		}
		System.out.println(allData);
	}
}
