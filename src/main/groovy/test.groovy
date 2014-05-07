import org.json.*

/**
 * Created by kyokomi on 2014/05/07.
 */

// Livedoorのお天気情報APIを利用してJSON形式のデータを取得する
URL url = new URL("http://weather.livedoor.com/forecast/webservice/json/v1?city=130010");
URLConnection connection = url.openConnection();
InputStream is = connection.getInputStream();
BufferedReader reader = new BufferedReader(new InputStreamReader(is));
JSONObject json = new JSONObject(reader.readLine());

println json




