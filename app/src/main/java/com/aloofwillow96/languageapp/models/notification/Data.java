
package com.aloofwillow96.languageapp.models.notification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("summary")
    @Expose
    private Summary summary;
    @SerializedName("isKrishi")
    @Expose
    private Integer isOD;

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public Integer getIsOD() {
        return isOD;
    }

    public void setIsOD(Integer isOD) {
        this.isOD = isOD;
    }

}
