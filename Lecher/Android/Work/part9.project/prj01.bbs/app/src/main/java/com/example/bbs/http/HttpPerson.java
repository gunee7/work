package com.example.bbs.http;

import com.example.bbs.AppConstants;
import com.example.bbs.inf.IPerson;
import com.example.bbs.model.ModelPerson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpPerson implements IPerson {
    private final static String HTTP_URL_CURTIME          = AppConstants.HTT_URL_BASE + "/rest/curtime";
    private final static String HTTP_URL_LOGINPERSON      = AppConstants.HTT_URL_BASE + "/rest/loginperson";
    private final static String HTTP_URL_SELECTPARAM      = AppConstants.HTT_URL_BASE + "/rest/selectparam";
    private final static String HTTP_URL_SELECTMODEL      = AppConstants.HTT_URL_BASE + "/rest/selectmodel";
    private final static String HTTP_URL_SELECTJSON       = AppConstants.HTT_URL_BASE + "/rest/selectjson";
    private final static String HTTP_URL_SELECTMAP        = AppConstants.HTT_URL_BASE + "/rest/selectmap";
    private final static String HTTP_URL_SELECTPAGING     = AppConstants.HTT_URL_BASE + "/rest/selectpaging";
    private final static String HTTP_URL_INSERTPARAM      = AppConstants.HTT_URL_BASE + "/rest/insertparam";
    private final static String HTTP_URL_INSERTMODEL      = AppConstants.HTT_URL_BASE + "/rest/insertmodel";
    private final static String HTTP_URL_INSERTJSONOBJECT = AppConstants.HTT_URL_BASE + "/rest/insertjsonobject";
    private final static String HTTP_URL_INSERTJSONARRAY  = AppConstants.HTT_URL_BASE + "/rest/insertjsonarray";

    private HttpRequest request  = null;
    private int         httpCode = 0;

    // Request  : values
    // Response : values
    @Override
    public long curtime() {

        long result = -1;
        String response = "";

        try {
            request = new HttpRequest(HTTP_URL_CURTIME);
            request.configPostType(HttpRequest.MineType.VALUES);
            httpCode = request.post();

            if( httpCode == HttpURLConnection.HTTP_OK ) { // 정상.
                response = request.getStringResponse();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        result = Long.valueOf( response );

        return result;
    }

    // Request  : values
    // Response : values
    @Override
    public long loginperson(String id, String pw) {
        long result = -1;
        String response = "";

        try {
            request = new HttpRequest( HTTP_URL_LOGINPERSON );
            request.configPostType( HttpRequest.MineType.VALUES );
            request.addParameter("id", id);
            request.addParameter("pw", pw);

            httpCode = request.post();

            if( httpCode == HttpURLConnection.HTTP_OK ) {
                response = request.getStringResponse();
            }

            // 형변환
            result = Long.valueOf( response );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // Request  : values
    // Response : JSONArray
    @Override
    public List<ModelPerson> selectparam(String name) {
        List<ModelPerson> result = null;
        JSONArray response = null;

        try {
            request = new HttpRequest(HTTP_URL_SELECTPARAM);
            request.configPostType( HttpRequest.MineType.VALUES );
            request.addParameter("name", name);

            httpCode = request.post();

            if( httpCode == HttpURLConnection.HTTP_OK ) {
                response = request.getJSONArrayResponse();
            }

            // GSon을 사용하여 JSONArray을 List<ModelPerson> 으로 변환
            result = new Gson().fromJson( response.toString() , new TypeToken< List<ModelPerson> >(){}.getType() );

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // Request  : values( model )
    // Response : JSONArray
    @Override
    public List<ModelPerson> selectmodel(ModelPerson person) {
        List<ModelPerson> result = null;
        JSONArray  response = null;

        try {
            request = new HttpRequest( HTTP_URL_SELECTMODEL );
            request.configPostType(HttpRequest.MineType.VALUES);
            request.addParameter("id"   , person.getId()   );
            request.addParameter("pw"   , person.getPw()   );
            request.addParameter("email", person.getEmail());
            request.addParameter("name" , person.getName() );

            httpCode = request.post();

            if( httpCode == HttpURLConnection.HTTP_OK ) {
                response = request.getJSONArrayResponse();
            }

            // GSon을 사용하여 JSONArray을 List<ModelPerson> 으로 변환
            result = new Gson().fromJson( response.toString() , new TypeToken< List<ModelPerson> >(){}.getType() );

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // Request  : JSONObject
    // Response : JSONArray
    @Override
    public List<ModelPerson> selectjson(ModelPerson person) {
        List<ModelPerson> result = null;
        JSONArray response = null;
        Gson gson = new Gson();

        try {
            request = new HttpRequest( HTTP_URL_SELECTJSON );
            request.configPostType( HttpRequest.MineType.JSONObject );

            // Gson을 이용하여 ModelPerson 을 JSONObject로 변환.
            String jsonString = gson.toJson( person );
            httpCode = request.post(jsonString);

            if( httpCode == HttpURLConnection.HTTP_OK ){
                response = request.getJSONArrayResponse();
            }

            // Gson을 이용하여 JSONArray 를 List<ModelPerson>  로 변환.
            result = gson.fromJson(response.toString(), new TypeToken< List<ModelPerson> >(){}.getType() );

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // Request  : JSONObject( map )
    // Response : JSONArray
    /**
     * 클라이언트(android) ---전송(json:JSONObject)---> 서버(spring) --- 반환(json:JSONArray)--->클라이언트(andorid)
     *
     * 1. 안드로이드 ---> 스프링     : 안드로이드는 json을 스프링으로 전송한다.
     * 2. 스프링     ---> 안드로이드 : 스프링에서 안드로이드로 값을 1개 반환한다.
     *
     * var map = {
     *                'searchvalue' : { 'id': '???', 'pw':'???', 'name':'???', 'email':'???' }
     *              , 'orderby'     : 'desc'
     *           };
     */
    @Override
    public List<ModelPerson> selectmap( ModelPerson searchvalue, String orderby ) {
        List<ModelPerson> result = null;
        JSONArray response = null;
        Gson gson = new Gson();

        try {
            request = new HttpRequest( HTTP_URL_SELECTMAP );
            request.configPostType(HttpRequest.MineType.JSONObject );

            Map<String, Object> map = new HashMap<>();
            map.put("searchvalue", searchvalue);
            map.put("orderby"    , orderby    );

            // Gson을 이용하여 Map<String, Object> map 을 JSONObject로 변환.
            String jsonString = gson.toJson( map );
            httpCode = request.post( jsonString );

            if( httpCode == HttpURLConnection.HTTP_OK ){
                response = request.getJSONArrayResponse();
            }

            // Gson을 이용하여 JSONArray 를 List<ModelPerson> 로 변환.
            result = gson.fromJson( response.toString(), new TypeToken< List<ModelPerson> >(){}.getType() );

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Request  : values
    // Response : JSONArray
    @Override
    public List<ModelPerson> selectpaging(Integer start, Integer end) {
        return null;
    }

    // Request  : values
    // Response : values
    @Override
    public boolean insertparam(String name) {
        return false;
    }

    // Request  : values( model )
    // Response : values
    @Override
    public boolean insertmodel(ModelPerson person) {
        return false;
    }

    // Request  : JSONObject
    // Response : values
    @Override
    public boolean insertjsonobject(ModelPerson person) {
        return false;
    }

    // Request  : JSONArray
    // Response : values
    @Override
    public boolean insertjsonarray(List<ModelPerson> persons) {
        return false;
    }
}
