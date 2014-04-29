package edu.ycp.cs320.rts.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320.rts.shared.GameState;

public class Loginscreen implements EntryPoint {

	@Override
	public void onModuleLoad() {
		
		final GetBoardServiceAsync boardservice = (GetBoardServiceAsync) GWT.create(GetBoardService.class);
		AsyncCallback<Boolean> callbackcreate = new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				GWT.log("action failed");
				
			}

			@Override
			public void onSuccess(Boolean result) {
				GWT.log("Action Success");
				if(result){
					GWT.log("Action returned true");
					
				}
				
			}
			
		};
		
		final AsyncCallback<Boolean> callbacklogin = new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				GWT.log("action failed");
				
			}

			@Override
			public void onSuccess(Boolean result) {
				GWT.log("Action Success");
				if(result){
					GWT.log("Action returned true");
					
				}
				
			}
			
		};
		
		boardservice.newuser("dmashuda", "abc123", "dmashuda@ycp.edu", callbackcreate);
		
		Timer t = new Timer() {
			
			@Override
			public void run() {
				boardservice.login("dmashuda", "ab123", callbacklogin);
				
			}
		};
		
		t.scheduleRepeating(1000);
		

	}

}
