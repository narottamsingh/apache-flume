package com.example.flume.interceptor;

import org.apache.flume.Channel;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.Transaction;
import org.apache.flume.conf.Configurable;
import org.apache.flume.sink.AbstractSink;

public class EmailSink extends AbstractSink implements Configurable {

	private String smtpHost;
	private int smtpPort;
	private String username;
	private String password;

	public Status process() throws EventDeliveryException {
		System.out.println("Email sync...........");
		// Retrieve events from the channel
		Channel channel = getChannel();
		Transaction transaction = channel.getTransaction();
		transaction.begin();
		try {
			Event event = channel.take();
			System.out.println("Event is : " + event);
			transaction.commit();
			return Status.READY;
		} catch (Exception e) {
			transaction.rollback();
			throw new EventDeliveryException("Failed to process event", e);
		} finally {
			transaction.close();
		}
	}

	public void configure(Context context) {
		System.out.println("SMTP COnfiguration..............");
		// Load configuration properties (e.g., SMTP settings)
		smtpHost = context.getString("smtp.host");
		smtpPort = context.getInteger("smtp.port", 25);
		username = context.getString("smtp.username");
		password = context.getString("smtp.password");
	}
}
