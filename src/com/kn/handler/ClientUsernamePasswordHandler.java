package com.kn.handler;

import java.io.IOException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.wss4j.common.ext.WSPasswordCallback;

public class ClientUsernamePasswordHandler implements CallbackHandler {
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		WSPasswordCallback callback = (WSPasswordCallback) callbacks[0];
		int usage = callback.getUsage();
		System.out.println("identifier: " + callback.getIdentifier());
		System.out.println("usage: " + callback.getUsage());
		if (usage == WSPasswordCallback.USERNAME_TOKEN) {
			callback.setPassword("admin");
		}
	}
}
