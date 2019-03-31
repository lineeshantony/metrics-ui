package com.barclays.metrics.integrations;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

public class SonarDataRetrieverTest {

	//@Test
	public void test_getChart() throws ClientProtocolException, IOException{
		SonarDataRetriever sonarDataRetriever = new SonarDataRetriever();
		sonarDataRetriever.pullSonarMetrics();
	}
}
