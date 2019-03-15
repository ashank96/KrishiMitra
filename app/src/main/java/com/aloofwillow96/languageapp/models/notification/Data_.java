
package com.aloofwillow96.languageapp.models.notification;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data_ {

    @SerializedName("notificationId")
    @Expose
    private Integer notificationId;
    @SerializedName("sound")
    @Expose
    private Integer sound;
    @SerializedName("imageUrls")
    @Expose
    private ImageUrls imageUrls;
    @SerializedName("iconUrls")
    @Expose
    private IconUrls iconUrls;
    @SerializedName("cta")
    @Expose
    private List<Ctum> cta = null;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("deeplink")
    @Expose
    private String deeplink;
    @SerializedName("expiryTime")
    @Expose
    private Integer expiryTime;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("isSticky")
    @Expose
    private Boolean isSticky;
    @SerializedName("userId")
    @Expose
    private Integer userId;

    public Integer getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }

    public Integer getSound() {
        return sound;
    }

    public void setSound(Integer sound) {
        this.sound = sound;
    }

    public ImageUrls getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(ImageUrls imageUrls) {
        this.imageUrls = imageUrls;
    }

    public IconUrls getIconUrls() {
        return iconUrls;
    }

    public void setIconUrls(IconUrls iconUrls) {
        this.iconUrls = iconUrls;
    }

    public List<Ctum> getCta() {
        return cta;
    }

    public void setCta(List<Ctum> cta) {
        this.cta = cta;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDeeplink() {
        return deeplink;
    }

    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    public Integer getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Integer expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getIsSticky() {
        return isSticky;
    }

    public void setIsSticky(Boolean isSticky) {
        this.isSticky = isSticky;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
