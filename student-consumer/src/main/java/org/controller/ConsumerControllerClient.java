package org.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
@Controller
public class ConsumerControllerClient {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	public void getEmployee() throws RestClientException, IOException {
		
		//EMPLOYEE-ZUUL-SERVICE
		List<ServiceInstance> instances=discoveryClient.getInstances("student-producer");
		
		//List<ServiceInstance> instances=discoveryClient.getInstances("student-producer");
		
		ServiceInstance serviceInstance=instances.get(0);
		
		String baseUrl="http://localhost:8089";
				//serviceInstance.getUri().toString();
		
		baseUrl=baseUrl+"/student";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl,
				HttpMethod.GET, getHeaders(),String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		//System.out.println("response is  : "+response.getBody());
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        
		return new HttpEntity<Object>(headers);
	}
}