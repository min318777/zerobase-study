package test;

import db.Wifi;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class WifiInfo {

    public List<Wifi> wifiList(String lat, String lon)throws IOException{
        List<Wifi> list = new ArrayList<Wifi>();
        StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /*URL*/
        urlBuilder.append("/" + URLEncoder.encode("537a736a486d696e33346659767a6e", "UTF-8")); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
        urlBuilder.append("/" + URLEncoder.encode("json", "UTF-8")); /*요청파일타입 (xml,xmlf,xls,json) */
        urlBuilder.append("/" + URLEncoder.encode("TbPublicWifiInfo", "UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
        urlBuilder.append("/" + URLEncoder.encode("1", "UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
        urlBuilder.append("/" + URLEncoder.encode("20", "UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
        // 상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.

        // 서비스별 추가 요청 인자이며 자세한 내용은 각 서비스별 '요청인자'부분에 자세히 나와 있습니다.
        //urlBuilder.append("/" + URLEncoder.encode("서대문구", "UTF-8")); /* 서비스별 추가 요청인자들*/


        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
        BufferedReader rd;

        // 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }

        System.out.println(sb.toString());
        rd.close();
        conn.disconnect();

        JSONObject jsonObject = null;
        try {
            JSONParser jsonParser = new JSONParser();

            jsonObject = (JSONObject)jsonParser.parse(sb.toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        JSONObject tbPublicWifiInfo = (JSONObject)jsonObject.get("TbPublicWifiInfo");
        JSONArray arr = (JSONArray) tbPublicWifiInfo.get("row");

        for(int i = 0; i < arr.size(); i++){

            JSONObject tmp =  (JSONObject) arr.get(i);

            String distance = "3.0";
            String maintenanceNum = (String)tmp.get("X_SWIFI_MGR_NO");
            String gu = (String)tmp.get("X_SWIFI_WRDOFC");
            String name = (String)tmp.get("X_SWIFI_MAIN_NM");
            String address1 = (String)tmp.get("X_SWIFI_ADRES1");
            String address2 = (String)tmp.get("X_SWIFI_ADRES2");
            String floor = (String)tmp.get("X_SWIFI_INSTL_FLOOR");
            String type = (String)tmp.get("X_SWIFI__INSTL_TY");
            String is = (String)tmp.get("X_SWIFI_INSTL_MBY");
            String sv = (String)tmp.get("X_SWIFI_SVC_SE");
            String network = (String)tmp.get("X_SWIFI_CMCWR");
            String year = (String)tmp.get("X_SWIFI_CNSTC_YEAR");
            String inOut = (String)tmp.get("X_SWIFI_INOUT_DOOR");
            String remars3 = (String)tmp.get("X_SWIFI_REMARS3");
            String lat1 = (String)tmp.get("LAT");
            String lon1 = (String)tmp.get("LNT");
            String workDttm = (String)tmp.get("WORK_DTTM");



            Wifi wifi = new Wifi(distance, maintenanceNum, gu, name, address1, address2, floor, type, is, sv, network, year, inOut, remars3, lat1, lon1, workDttm);
            list.add(wifi);


        }

        return list;
    }
}

