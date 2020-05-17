import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ApacheHttp {

        public boolean postUser(String link,String login, String password) {
            boolean code=true;
            try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
                //Create client and post request with header and jsond data
                HttpPost httpPost = new HttpPost(link);
                httpPost.setHeader("Accept", "application/json");
                httpPost.setHeader("Content-type", "application/json");
                String json = String.format("{\r\n" +
                        "  \"login\": \"%s\",\r\n" +
                        "  \"password\": \"%s\",\r\n" +
                        "}", login, password);
                StringEntity stringEntity = new StringEntity(json);
                httpPost.setEntity(stringEntity);
                System.out.println("Executing request " + httpPost.getRequestLine());
                HttpResponse response = httpclient.execute(httpPost);

                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    System.out.println(status);
                    code = true;

                } else {
                    System.out.println(status);
                    code = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return code;
        }
}
