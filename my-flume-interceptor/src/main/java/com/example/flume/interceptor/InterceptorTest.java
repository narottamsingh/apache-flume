package com.example.flume.interceptor;
import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.api.RpcClient;
import org.apache.flume.api.RpcClientFactory;
import org.apache.flume.event.EventBuilder;

public class InterceptorTest {

    public static void main(String[] args) {
        // Create a Flume RPC client
        RpcClient client = RpcClientFactory.getDefaultInstance("0.0.0.0", 444);

        // Create an event and send it through the interceptor
        String message = "Hello, Flume!";
        Event event = EventBuilder.withBody(message.getBytes());
        try {
			client.append(event);
		} catch (EventDeliveryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Print the processed event
       // System.out.println(new String(processedEvent.getBody()));
        
        // Close the client
        client.close();
    }
}
