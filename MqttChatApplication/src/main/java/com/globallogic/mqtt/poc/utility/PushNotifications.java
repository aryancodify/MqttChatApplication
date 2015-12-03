package com.globallogic.mqtt.poc.utility;

import java.util.Set;

import com.globallogic.mqtt.poc.exceptions.PushNotificationException;
import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;
import com.notnoop.apns.ApnsServiceBuilder;

public final class PushNotifications {
	ClassLoader classLoader = getClass().getClassLoader();

	private PushNotifications() {
	}

	private static PushNotifications pushNotifications = new PushNotifications();

	public static PushNotifications getPushNotificationInstance() {
		return pushNotifications;

	}

	public boolean pushNotification(Set<String> deviceTokens, String message,String topicId) {
		String certPath = classLoader.getResource(
				"FinalServerCertificateAndKey.p12").getPath();
		ApnsServiceBuilder serviceBuilder = APNS.newService();

		try {
			serviceBuilder.withCert(certPath, "").withSandboxDestination();

			String payload = APNS.newPayload().alertBody(message)
					.sound("default").customField("topicId", topicId)
					.build();
			ApnsService service = serviceBuilder.build();
			System.out.println("payload: " + payload);
			for (String deviceToken : deviceTokens) 
				service.push(deviceToken, payload);
		} catch (Exception ex) {
			throw new PushNotificationException(deviceTokens, message);
		}
		return true;

	}
}
