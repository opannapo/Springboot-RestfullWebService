package com.lamaknyo.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "loc_cities", schema = "lamaknyo_dabe", catalog = "")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LocCitiesEntity {
    private int id;
    private String name;
    private int prvnId;
    private Integer isCapital;
    private Integer citCnyId;
    private int citReferenceId;
    private String citJneCode;
    private String citJneId;
    private String citJneCodeId;
    private String citJneOriginCode;
    private double citLatitude;
    private double citLongitude;
    private String citDescription;
    private String citHistory;
    private String citPracticalInfo;
    private String citGettingAround;
    private String citTips;
    private Double citAvgRating;
    private Integer citTimeZone;
    private byte[] citImage;
    private String citImageName;
    private String citImageSize;
    private String citImageType;
    private Long citCountViews;
    private Integer citCountReview;
    private Long citCountMembers;
    private Integer citCountCorporate;
    private Integer citCountEvents;
    private Short citWeatherId;
    private String citSights;
    private Integer citDatetime;
    private Integer citDatetimeInsert;
    private Integer citDatetimeUpdate;
    private Integer citDatetimeDelete;
    private Integer citAduIdInsert;
    private Integer citAduIdUpdate;
    private Integer citAduIdDelete;
    private int citStatus;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "prvn_id", nullable = false)
    public int getPrvnId() {
        return prvnId;
    }

    public void setPrvnId(int prvnId) {
        this.prvnId = prvnId;
    }

    @Basic
    @Column(name = "is_capital", nullable = true)
    public Integer getIsCapital() {
        return isCapital;
    }

    public void setIsCapital(Integer isCapital) {
        this.isCapital = isCapital;
    }

    @Basic
    @Column(name = "cit_cny_id", nullable = true)
    public Integer getCitCnyId() {
        return citCnyId;
    }

    public void setCitCnyId(Integer citCnyId) {
        this.citCnyId = citCnyId;
    }

    @Basic
    @Column(name = "cit_reference_id", nullable = false)
    public int getCitReferenceId() {
        return citReferenceId;
    }

    public void setCitReferenceId(int citReferenceId) {
        this.citReferenceId = citReferenceId;
    }

    @Basic
    @Column(name = "cit_jne_code", nullable = true, length = 100)
    public String getCitJneCode() {
        return citJneCode;
    }

    public void setCitJneCode(String citJneCode) {
        this.citJneCode = citJneCode;
    }

    @Basic
    @Column(name = "cit_jne_id", nullable = true, length = 100)
    public String getCitJneId() {
        return citJneId;
    }

    public void setCitJneId(String citJneId) {
        this.citJneId = citJneId;
    }

    @Basic
    @Column(name = "cit_jne_code_id", nullable = true, length = 100)
    public String getCitJneCodeId() {
        return citJneCodeId;
    }

    public void setCitJneCodeId(String citJneCodeId) {
        this.citJneCodeId = citJneCodeId;
    }

    @Basic
    @Column(name = "cit_jne_origin_code", nullable = true, length = 100)
    public String getCitJneOriginCode() {
        return citJneOriginCode;
    }

    public void setCitJneOriginCode(String citJneOriginCode) {
        this.citJneOriginCode = citJneOriginCode;
    }

    @Basic
    @Column(name = "cit_latitude", nullable = false, precision = 0)
    public double getCitLatitude() {
        return citLatitude;
    }

    public void setCitLatitude(double citLatitude) {
        this.citLatitude = citLatitude;
    }

    @Basic
    @Column(name = "cit_longitude", nullable = false, precision = 0)
    public double getCitLongitude() {
        return citLongitude;
    }

    public void setCitLongitude(double citLongitude) {
        this.citLongitude = citLongitude;
    }

    @Basic
    @Column(name = "cit_description", nullable = true, length = -1)
    public String getCitDescription() {
        return citDescription;
    }

    public void setCitDescription(String citDescription) {
        this.citDescription = citDescription;
    }

    @Basic
    @Column(name = "cit_history", nullable = true, length = -1)
    public String getCitHistory() {
        return citHistory;
    }

    public void setCitHistory(String citHistory) {
        this.citHistory = citHistory;
    }

    @Basic
    @Column(name = "cit_practical_info", nullable = true, length = -1)
    public String getCitPracticalInfo() {
        return citPracticalInfo;
    }

    public void setCitPracticalInfo(String citPracticalInfo) {
        this.citPracticalInfo = citPracticalInfo;
    }

    @Basic
    @Column(name = "cit_getting_around", nullable = true, length = -1)
    public String getCitGettingAround() {
        return citGettingAround;
    }

    public void setCitGettingAround(String citGettingAround) {
        this.citGettingAround = citGettingAround;
    }

    @Basic
    @Column(name = "cit_tips", nullable = true, length = -1)
    public String getCitTips() {
        return citTips;
    }

    public void setCitTips(String citTips) {
        this.citTips = citTips;
    }

    @Basic
    @Column(name = "cit_avg_rating", nullable = true, precision = 0)
    public Double getCitAvgRating() {
        return citAvgRating;
    }

    public void setCitAvgRating(Double citAvgRating) {
        this.citAvgRating = citAvgRating;
    }

    @Basic
    @Column(name = "cit_time_zone", nullable = true)
    public Integer getCitTimeZone() {
        return citTimeZone;
    }

    public void setCitTimeZone(Integer citTimeZone) {
        this.citTimeZone = citTimeZone;
    }

    @Basic
    @Column(name = "cit_image", nullable = true)
    public byte[] getCitImage() {
        return citImage;
    }

    public void setCitImage(byte[] citImage) {
        this.citImage = citImage;
    }

    @Basic
    @Column(name = "cit_image_name", nullable = true, length = 50)
    public String getCitImageName() {
        return citImageName;
    }

    public void setCitImageName(String citImageName) {
        this.citImageName = citImageName;
    }

    @Basic
    @Column(name = "cit_image_size", nullable = true, length = 10)
    public String getCitImageSize() {
        return citImageSize;
    }

    public void setCitImageSize(String citImageSize) {
        this.citImageSize = citImageSize;
    }

    @Basic
    @Column(name = "cit_image_type", nullable = true, length = 30)
    public String getCitImageType() {
        return citImageType;
    }

    public void setCitImageType(String citImageType) {
        this.citImageType = citImageType;
    }

    @Basic
    @Column(name = "cit_count_views", nullable = true)
    public Long getCitCountViews() {
        return citCountViews;
    }

    public void setCitCountViews(Long citCountViews) {
        this.citCountViews = citCountViews;
    }

    @Basic
    @Column(name = "cit_count_review", nullable = true)
    public Integer getCitCountReview() {
        return citCountReview;
    }

    public void setCitCountReview(Integer citCountReview) {
        this.citCountReview = citCountReview;
    }

    @Basic
    @Column(name = "cit_count_members", nullable = true)
    public Long getCitCountMembers() {
        return citCountMembers;
    }

    public void setCitCountMembers(Long citCountMembers) {
        this.citCountMembers = citCountMembers;
    }

    @Basic
    @Column(name = "cit_count_corporate", nullable = true)
    public Integer getCitCountCorporate() {
        return citCountCorporate;
    }

    public void setCitCountCorporate(Integer citCountCorporate) {
        this.citCountCorporate = citCountCorporate;
    }

    @Basic
    @Column(name = "cit_count_events", nullable = true)
    public Integer getCitCountEvents() {
        return citCountEvents;
    }

    public void setCitCountEvents(Integer citCountEvents) {
        this.citCountEvents = citCountEvents;
    }

    @Basic
    @Column(name = "cit_weather_id", nullable = true)
    public Short getCitWeatherId() {
        return citWeatherId;
    }

    public void setCitWeatherId(Short citWeatherId) {
        this.citWeatherId = citWeatherId;
    }

    @Basic
    @Column(name = "cit_sights", nullable = true, length = -1)
    public String getCitSights() {
        return citSights;
    }

    public void setCitSights(String citSights) {
        this.citSights = citSights;
    }

    @Basic
    @Column(name = "cit_datetime", nullable = true)
    public Integer getCitDatetime() {
        return citDatetime;
    }

    public void setCitDatetime(Integer citDatetime) {
        this.citDatetime = citDatetime;
    }

    @Basic
    @Column(name = "cit_datetime_insert", nullable = true)
    public Integer getCitDatetimeInsert() {
        return citDatetimeInsert;
    }

    public void setCitDatetimeInsert(Integer citDatetimeInsert) {
        this.citDatetimeInsert = citDatetimeInsert;
    }

    @Basic
    @Column(name = "cit_datetime_update", nullable = true)
    public Integer getCitDatetimeUpdate() {
        return citDatetimeUpdate;
    }

    public void setCitDatetimeUpdate(Integer citDatetimeUpdate) {
        this.citDatetimeUpdate = citDatetimeUpdate;
    }

    @Basic
    @Column(name = "cit_datetime_delete", nullable = true)
    public Integer getCitDatetimeDelete() {
        return citDatetimeDelete;
    }

    public void setCitDatetimeDelete(Integer citDatetimeDelete) {
        this.citDatetimeDelete = citDatetimeDelete;
    }

    @Basic
    @Column(name = "cit_adu_id_insert", nullable = true)
    public Integer getCitAduIdInsert() {
        return citAduIdInsert;
    }

    public void setCitAduIdInsert(Integer citAduIdInsert) {
        this.citAduIdInsert = citAduIdInsert;
    }

    @Basic
    @Column(name = "cit_adu_id_update", nullable = true)
    public Integer getCitAduIdUpdate() {
        return citAduIdUpdate;
    }

    public void setCitAduIdUpdate(Integer citAduIdUpdate) {
        this.citAduIdUpdate = citAduIdUpdate;
    }

    @Basic
    @Column(name = "cit_adu_id_delete", nullable = true)
    public Integer getCitAduIdDelete() {
        return citAduIdDelete;
    }

    public void setCitAduIdDelete(Integer citAduIdDelete) {
        this.citAduIdDelete = citAduIdDelete;
    }

    @Basic
    @Column(name = "cit_status", nullable = false)
    public int getCitStatus() {
        return citStatus;
    }

    public void setCitStatus(int citStatus) {
        this.citStatus = citStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocCitiesEntity that = (LocCitiesEntity) o;
        return id == that.id &&
                prvnId == that.prvnId &&
                citReferenceId == that.citReferenceId &&
                Double.compare(that.citLatitude, citLatitude) == 0 &&
                Double.compare(that.citLongitude, citLongitude) == 0 &&
                citStatus == that.citStatus &&
                Objects.equals(name, that.name) &&
                Objects.equals(isCapital, that.isCapital) &&
                Objects.equals(citCnyId, that.citCnyId) &&
                Objects.equals(citJneCode, that.citJneCode) &&
                Objects.equals(citJneId, that.citJneId) &&
                Objects.equals(citJneCodeId, that.citJneCodeId) &&
                Objects.equals(citJneOriginCode, that.citJneOriginCode) &&
                Objects.equals(citDescription, that.citDescription) &&
                Objects.equals(citHistory, that.citHistory) &&
                Objects.equals(citPracticalInfo, that.citPracticalInfo) &&
                Objects.equals(citGettingAround, that.citGettingAround) &&
                Objects.equals(citTips, that.citTips) &&
                Objects.equals(citAvgRating, that.citAvgRating) &&
                Objects.equals(citTimeZone, that.citTimeZone) &&
                Arrays.equals(citImage, that.citImage) &&
                Objects.equals(citImageName, that.citImageName) &&
                Objects.equals(citImageSize, that.citImageSize) &&
                Objects.equals(citImageType, that.citImageType) &&
                Objects.equals(citCountViews, that.citCountViews) &&
                Objects.equals(citCountReview, that.citCountReview) &&
                Objects.equals(citCountMembers, that.citCountMembers) &&
                Objects.equals(citCountCorporate, that.citCountCorporate) &&
                Objects.equals(citCountEvents, that.citCountEvents) &&
                Objects.equals(citWeatherId, that.citWeatherId) &&
                Objects.equals(citSights, that.citSights) &&
                Objects.equals(citDatetime, that.citDatetime) &&
                Objects.equals(citDatetimeInsert, that.citDatetimeInsert) &&
                Objects.equals(citDatetimeUpdate, that.citDatetimeUpdate) &&
                Objects.equals(citDatetimeDelete, that.citDatetimeDelete) &&
                Objects.equals(citAduIdInsert, that.citAduIdInsert) &&
                Objects.equals(citAduIdUpdate, that.citAduIdUpdate) &&
                Objects.equals(citAduIdDelete, that.citAduIdDelete);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, name, prvnId, isCapital, citCnyId, citReferenceId, citJneCode, citJneId, citJneCodeId, citJneOriginCode, citLatitude, citLongitude, citDescription, citHistory, citPracticalInfo, citGettingAround, citTips, citAvgRating, citTimeZone, citImageName, citImageSize, citImageType, citCountViews, citCountReview, citCountMembers, citCountCorporate, citCountEvents, citWeatherId, citSights, citDatetime, citDatetimeInsert, citDatetimeUpdate, citDatetimeDelete, citAduIdInsert, citAduIdUpdate, citAduIdDelete, citStatus);
        result = 31 * result + Arrays.hashCode(citImage);
        return result;
    }
}
