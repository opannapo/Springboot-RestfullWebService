package com.lamaknyo.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "app_settings", schema = "lamaknyo_dabe", catalog = "")
public class AppSettingsEntity {
    private int id;
    private String banner;
    private String icon;
    private String welcomeText;
    private String ctWa;
    private String ctTelg;
    private String ctMail;
    private String tnc;
    private String pp;
    private String guide;
    private String androidAppVersion;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "banner", nullable = true, length = 100)
    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    @Basic
    @Column(name = "icon", nullable = true, length = 100)
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "welcome_text", nullable = true, length = -1)
    public String getWelcomeText() {
        return welcomeText;
    }

    public void setWelcomeText(String welcomeText) {
        this.welcomeText = welcomeText;
    }

    @Basic
    @Column(name = "ct_wa", nullable = true, length = 20)
    public String getCtWa() {
        return ctWa;
    }

    public void setCtWa(String ctWa) {
        this.ctWa = ctWa;
    }

    @Basic
    @Column(name = "ct_telg", nullable = true, length = 20)
    public String getCtTelg() {
        return ctTelg;
    }

    public void setCtTelg(String ctTelg) {
        this.ctTelg = ctTelg;
    }

    @Basic
    @Column(name = "ct_mail", nullable = true, length = 40)
    public String getCtMail() {
        return ctMail;
    }

    public void setCtMail(String ctMail) {
        this.ctMail = ctMail;
    }

    @Basic
    @Column(name = "tnc", nullable = true, length = 100)
    public String getTnc() {
        return tnc;
    }

    public void setTnc(String tnc) {
        this.tnc = tnc;
    }

    @Basic
    @Column(name = "pp", nullable = true, length = 100)
    public String getPp() {
        return pp;
    }

    public void setPp(String pp) {
        this.pp = pp;
    }

    @Basic
    @Column(name = "guide", nullable = true, length = 100)
    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    @Basic
    @Column(name = "android_app_version", nullable = true, length = 10)
    public String getAndroidAppVersion() {
        return androidAppVersion;
    }

    public void setAndroidAppVersion(String androidAppVersion) {
        this.androidAppVersion = androidAppVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppSettingsEntity that = (AppSettingsEntity) o;
        return id == that.id &&
                Objects.equals(banner, that.banner) &&
                Objects.equals(icon, that.icon) &&
                Objects.equals(welcomeText, that.welcomeText) &&
                Objects.equals(ctWa, that.ctWa) &&
                Objects.equals(ctTelg, that.ctTelg) &&
                Objects.equals(ctMail, that.ctMail) &&
                Objects.equals(tnc, that.tnc) &&
                Objects.equals(pp, that.pp) &&
                Objects.equals(guide, that.guide) &&
                Objects.equals(androidAppVersion, that.androidAppVersion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, banner, icon, welcomeText, ctWa, ctTelg, ctMail, tnc, pp, guide, androidAppVersion);
    }
}
