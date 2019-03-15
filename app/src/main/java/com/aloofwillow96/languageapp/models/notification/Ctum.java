
package com.aloofwillow96.languageapp.models.notification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ctum {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("deeplink")
    @Expose
    private String deeplink;
    @SerializedName("action_type")
    @Expose
    private Integer actionType;
    @SerializedName("iconUrls")
    @Expose
    private IconUrls_ iconUrls;
    @SerializedName("iconId")
    @Expose
    private Integer iconId;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDeeplink() {
        return deeplink;
    }

    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    public Integer getActionType() {
        return actionType;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }

    public IconUrls_ getIconUrls() {
        return iconUrls;
    }

    public void setIconUrls(IconUrls_ iconUrls) {
        this.iconUrls = iconUrls;
    }

    public Integer getIconId() {
        return iconId;
    }

    public void setIconId(Integer iconId) {
        this.iconId = iconId;
    }

}
