package com.aloofwillow96.languageapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;

import android.os.Build;
import android.util.Log;


import com.aloofwillow96.languageapp.activities.LandingActivity;
import com.aloofwillow96.languageapp.models.UpdateTokenRequest;
import com.aloofwillow96.languageapp.models.notification.Data_;
import com.aloofwillow96.languageapp.network.APIInterface;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;


import org.json.JSONException;
import org.json.JSONObject;


import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import androidx.core.app.NotificationCompat;

/**
 * @author ashankbharati created at 15/03/19
 */

public class KrishiFirebaseMessagingService extends FirebaseMessagingService {

	public final String TAG = getClass().getSimpleName();


	@Override
	public void onNewToken(String s) {
		super.onNewToken(s);
		KrishiPreferences.getInstance().set(Constants.FCM_TOKEN, s);
		Log.i(TAG, "Refreshed Token " + s);
		//sendTokenToServer();
	}

	private void sendTokenToServer() {
		if(FirebaseAuth.getInstance().getCurrentUser()!=null && FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber()!=null) {
			//apiInterface.updateFcmToken(new UpdateTokenRequest(FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber(), KrishiPreferences.getInstance().getString(Constants.FCM_TOKEN,"")));

		}
	}

	@Override
	public void onMessageReceived(RemoteMessage remoteMessage) {
		super.onMessageReceived(remoteMessage);
		Map data = remoteMessage.getData();
		Log.d("msg", "onMessageReceived: " + remoteMessage.getData().get("message"));

		if (data != null && !data.isEmpty()) {
			try {
				handleNotification(data);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

	}

	private void handleNotification(Map extras) throws JSONException {
		String messageJson = extras.get("summary").toString();
		JSONObject json = null;
		try {
			json = new JSONObject(messageJson);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		if (json != null) {
			JSONObject jsonObject = (JSONObject) json.get("data");
			Gson gson = new Gson();
			Data_ notificationMessage = gson.fromJson(jsonObject.toString(), Data_.class);
			Intent intent = new Intent(this, LandingActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
			String channelId = "121";
			NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
					.setContentTitle(notificationMessage.getTitle())
					.setContentText(notificationMessage.getMessage())
					.setAutoCancel(true)
					.setSmallIcon(R.drawable.ic_sprout)
					.setColor(getResources().getColor(R.color.blue))
					.setLargeIcon(((BitmapDrawable) getResources().getDrawable(R.drawable.nuts)).getBitmap())
					.setDefaults(Notification.DEFAULT_ALL)
					.setPriority(NotificationManager.IMPORTANCE_HIGH)
					.setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 })
					.setLights(Color.RED, 3000, 3000)
					.setContentIntent(pendingIntent);
			;
			NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
				NotificationChannel channel = new NotificationChannel(channelId, "Default channel", NotificationManager.IMPORTANCE_DEFAULT);
				manager.createNotificationChannel(channel);
			}
			manager.notify(0, builder.build());
		}
	}


}
