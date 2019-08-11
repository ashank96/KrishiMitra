
package com.aloofwillow96.languageapp.models.notification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Summary {

    @SerializedName("deviceHash")
    @Expose
    private String deviceHash;
    @SerializedName("userIdentifier")
    @Expose
    private String userIdentifier;
    @SerializedName("notificationType")
    @Expose
    private String notificationType;
    @SerializedName("sessionId")
    @Expose
    private Integer sessionId;
    @SerializedName("notificationChannelId")
    @Expose
    private String notificationChannelId;
    @SerializedName("channelName")
    @Expose
    private String channelName;
    @SerializedName("channelPriority")
    @Expose
    private Integer channelPriority;
    @SerializedName("sessionHash")
    @Expose
    private String sessionHash;
    @SerializedName("campaignId")
    @Expose
    private String campaignId;
    @SerializedName("createdAtUnixTimeStamp")
    @Expose
    private Integer createdAtUnixTimeStamp;
    @SerializedName("data")
    @Expose
    private Data_ data;

    public String getDeviceHash() {
        return deviceHash;
    }

    public void setDeviceHash(String deviceHash) {
        this.deviceHash = deviceHash;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public String getNotificationChannelId() {
        return notificationChannelId;
    }

    public void setNotificationChannelId(String notificationChannelId) {
        this.notificationChannelId = notificationChannelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Integer getChannelPriority() {
        return channelPriority;
    }

    public void setChannelPriority(Integer channelPriority) {
        this.channelPriority = channelPriority;
    }

    public String getSessionHash() {
        return sessionHash;
    }

    public void setSessionHash(String sessionHash) {
        this.sessionHash = sessionHash;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public Integer getCreatedAtUnixTimeStamp() {
        return createdAtUnixTimeStamp;
    }

    public void setCreatedAtUnixTimeStamp(Integer createdAtUnixTimeStamp) {
        this.createdAtUnixTimeStamp = createdAtUnixTimeStamp;
    }

    public Data_ getData() {
        return data;
    }

    public void setData(Data_ data) {
        this.data = data;
    }

}
