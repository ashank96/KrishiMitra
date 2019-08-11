
package com.aloofwillow96.languageapp.models.notification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IconUrls {

    @SerializedName("mdpi")
    @Expose
    private String mdpi;
    @SerializedName("hdpi")
    @Expose
    private String hdpi;
    @SerializedName("xhdpi")
    @Expose
    private String xhdpi;
    @SerializedName("xxhdpi")
    @Expose
    private String xxhdpi;

    public String getMdpi() {
        return mdpi;
    }

    public void setMdpi(String mdpi) {
        this.mdpi = mdpi;
    }

    public String getHdpi() {
        return hdpi;
    }

    public void setHdpi(String hdpi) {
        this.hdpi = hdpi;
    }

    public String getXhdpi() {
        return xhdpi;
    }

    public void setXhdpi(String xhdpi) {
        this.xhdpi = xhdpi;
    }

    public String getXxhdpi() {
        return xxhdpi;
    }

    public void setXxhdpi(String xxhdpi) {
        this.xxhdpi = xxhdpi;
    }

}
