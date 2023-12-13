package com.example.flume.interceptor;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

public class TimestampInterceptor implements Interceptor {

	public void initialize() {
		System.out.println("Hell0..........................");
	}

	public Event intercept(Event event) {
		System.out.println("New event received ................" + event);
		// Modify the event here
		byte[] body = event.getBody();
		System.out.println("Body "+new String(body));
		String timestampedBody = new String(body, StandardCharsets.UTF_8) + " [Timestamp: " + System.currentTimeMillis()
				+ "]";
		System.out.println("timestampedBody : " + timestampedBody);
		event.setBody(timestampedBody.getBytes(StandardCharsets.UTF_8));
		return event;
	}

	public List<Event> intercept(List<Event> events) {
		for (Event event : events) {
			intercept(event);
		}
		return events;
	}

	public void close() {
		// Cleanup code, if needed
	}

	public static class Builder implements Interceptor.Builder {
		public Interceptor build() {
			return new TimestampInterceptor();
		}

		public void configure(Context context) {
			// Configuration code, if needed
		}
	}
}
