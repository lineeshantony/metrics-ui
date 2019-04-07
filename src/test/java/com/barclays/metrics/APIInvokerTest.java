package com.barclays.metrics;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.barclays.metrics.web.APIInvoker;

public class APIInvokerTest {
	
	//@Test
	public void test_callAPI() throws ClientProtocolException, IOException{
		APIInvoker apiInvoker = new APIInvoker();
		apiInvoker.callAPI();
	}

}
