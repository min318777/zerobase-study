package db;

import test.WifiInfo;

import java.io.IOException;
import java.util.List;


public class WifiService {

    public static void main(String[] args) throws IOException {

        WifiInfo explorer = new WifiInfo();
        List<Wifi> result = explorer.wifiList("3.0","3.0");
        for(Wifi wifi : result) {
            System.out.println(wifi.getAddress1());
        }


    }
}
