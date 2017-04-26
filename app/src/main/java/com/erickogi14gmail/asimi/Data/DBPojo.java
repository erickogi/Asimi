package com.erickogi14gmail.asimi.Data;

/**
 * Created by kimani kogi on 4/21/2017.
 */

public class DBPojo {


    private int ID;
    private String REMAINDER_NAME;
    private String REMAINDER_DESCRIPTION;
    private String REMAINDER_PLACE_LATITUDE;
    private String REMAINDER_PLACE_LONGITUDE;
    private String REMAINDER_STATE;
    private String REMAINDER_KEY;
    private String REMAINDER_PLACE_NAME;
    private String REMAINDER_TIME;
    private String REMINDER_DATE;

    public DBPojo(int ID, String REMAINDER_NAME, String REMAINDER_DESCRIPTION, String REMAINDER_PLACE_LATITUDE,
                  String REMAINDER_PLACE_LONGITUDE, String REMAINDER_STATE, String REMAINDER_KEY, String REMAINDER_PLACE_NAME,
                  String REMAINDER_TIME, String REMINDER_DATE ) {
        this.ID = ID;
        this.REMAINDER_NAME = REMAINDER_NAME;
        this.REMAINDER_DESCRIPTION = REMAINDER_DESCRIPTION;
        this.REMAINDER_PLACE_LATITUDE = REMAINDER_PLACE_LATITUDE;
        this.REMAINDER_PLACE_LONGITUDE = REMAINDER_PLACE_LONGITUDE;
        this.REMAINDER_STATE = REMAINDER_STATE;
        this.REMAINDER_KEY = REMAINDER_KEY;
        this.REMAINDER_PLACE_NAME = REMAINDER_PLACE_NAME;
        this.REMAINDER_TIME = REMAINDER_TIME;
        this.REMINDER_DATE = REMINDER_DATE;
    }

    public DBPojo() {

    }

    public String getREMAINDER_TIME() {
        return REMAINDER_TIME;
    }

    public void setREMAINDER_TIME(String REMAINDER_TIME) {
        this.REMAINDER_TIME = REMAINDER_TIME;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getREMAINDER_NAME() {
        return REMAINDER_NAME;
    }

    public void setREMAINDER_NAME(String REMAINDER_NAME) {
        this.REMAINDER_NAME = REMAINDER_NAME;
    }

    public String getREMAINDER_DESCRIPTION() {
        return REMAINDER_DESCRIPTION;
    }

    public void setREMAINDER_DESCRIPTION(String REMAINDER_DESCRIPTION) {
        this.REMAINDER_DESCRIPTION = REMAINDER_DESCRIPTION;
    }

    public String getREMAINDER_PLACE_LATITUDE() {
        return REMAINDER_PLACE_LATITUDE;
    }

    public void setREMAINDER_PLACE_LATITUDE(String REMAINDER_PLACE_LATITUDE) {
        this.REMAINDER_PLACE_LATITUDE = REMAINDER_PLACE_LATITUDE;
    }

    public String getREMAINDER_PLACE_LONGITUDE() {
        return REMAINDER_PLACE_LONGITUDE;
    }

    public void setREMAINDER_PLACE_LONGITUDE(String REMAINDER_PLACE_LONGITUDE) {
        this.REMAINDER_PLACE_LONGITUDE = REMAINDER_PLACE_LONGITUDE;
    }

    public String getREMAINDER_STATE() {
        return REMAINDER_STATE;
    }

    public void setREMAINDER_STATE(String REMAINDER_STATE) {
        this.REMAINDER_STATE = REMAINDER_STATE;
    }

    public String getREMAINDER_KEY() {
        return REMAINDER_KEY;
    }

    public void setREMAINDER_KEY(String REMAINDER_KEY) {
        this.REMAINDER_KEY = REMAINDER_KEY;
    }

    public String getREMAINDER_PLACE_NAME() {
        return REMAINDER_PLACE_NAME;
    }

    public void setREMAINDER_PLACE_NAME(String REMAINDER_PLACE_NAME) {
        this.REMAINDER_PLACE_NAME = REMAINDER_PLACE_NAME;
    }

    public String getREMINDER_DATE() {
        return REMINDER_DATE;
    }

    public void setREMINDER_DATE(String REMINDER_DATE) {
        this.REMINDER_DATE = REMINDER_DATE;
    }
}
