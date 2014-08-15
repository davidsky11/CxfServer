package com.kn.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.wss4j.common.ext.WSPasswordCallback;

public class ServerUsernamePasswordHandler implements CallbackHandler {

	// key is username, value is password
	private Map<String, String> users;

	public ServerUsernamePasswordHandler() {
		users = new HashMap<String, String>();
		users.put("admin", "admin");
	}
	
	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		WSPasswordCallback callback = (WSPasswordCallback) callbacks[0];
		String id = callback.getIdentifier();
		if (users.containsKey(id)) {
			if (!callback.getPassword().equals(users.get(id))) {
				throw new SecurityException("Incorrect password.");
			}
		} else {
			throw new SecurityException("Invalid user.");
		}
	}
}
