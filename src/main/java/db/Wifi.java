package db;

public class Wifi {

    private double distance;
    private int maintenanceNumber;
    private String gu;
    private String name;
    private String address;
    private int floor;

    public Wifi(String gu, double distance, int maintenanceNumber, String name, String address, int floor) {
        this.gu = gu;
        this.distance = distance;
        this.maintenanceNumber = maintenanceNumber;
        this.name = name;
        this.address = address;
        this.floor = floor;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getMaintenanceNumber() {
        return maintenanceNumber;
    }

    public void setMaintenanceNumber(int maintenanceNumber) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
