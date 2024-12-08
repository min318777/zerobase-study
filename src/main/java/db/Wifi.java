package db;

public class Wifi {

    private String distance;
    private String maintenanceNumber;
    private String gu;
    private String name;
    private String address1;
    private String address2;
    private String floor;
    private String type;
    private String is;
    private String sv;
    private String network;
    private String year;
    private String inOut;
    private String remars3;
    private String lat;
    private String lon;
    private String workDttm;


    public Wifi(String distance, String maintenanceNumber, String gu, String name, String address1, String address2, String floor, String type, String is, String sv, String network, String year, String inOut, String remars3, String lat, String lon, String workDttm) {
        this.distance = distance;
        this.maintenanceNumber = maintenanceNumber;
        this.gu = gu;
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.floor = floor;
        this.type = type;
        this.is = is;
        this.sv = sv;
        this.network = network;
        this.year = year;
        this.inOut = inOut;
        this.remars3 = remars3;
        this.lat = lat;
        this.lon = lon;
        this.workDttm = workDttm;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getMaintenanceNumber() {
        return maintenanceNumber;
    }

    public void setMaintenanceNumber(String maintenanceNumber) {
        this.maintenanceNumber = maintenanceNumber;
    }

    public String getGu() {
        return gu;
    }

    public void setGu(String gu) {
        this.gu = gu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getIs() {
        return is;
    }

    public void setIs(String is) {
        this.is = is;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSv() {
        return sv;
    }

    public void setSv(String sv) {
        this.sv = sv;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getInOut() {
        return inOut;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut;
    }

    public String getRemars3() {
        return remars3;
    }

    public void setRemars3(String remars3) {
        this.remars3 = remars3;
    }

    public String getWorkDttm() {
        return workDttm;
    }

    public void setWorkDttm(String workDttm) {
        this.workDttm = workDttm;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
