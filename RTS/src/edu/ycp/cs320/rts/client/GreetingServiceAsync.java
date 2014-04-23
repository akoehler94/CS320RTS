package edu.ycp.cs320.rts.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;

	void login(String username, String password, AsyncCallback<Boolean> callback);

	void newuser(String username, String password, String email,
			AsyncCallback<Boolean> callback);
}
