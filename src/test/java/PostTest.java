import org.junit.Assert;
import org.junit.Test;



public class PostTest {

    private ApacheHttp apacheHttp;

    @Test
    public void postRequest(){
        apacheHttp = new ApacheHttp();
        //if test passed means that 200<=status code<300, which means post request was successful
        Assert.assertTrue(apacheHttp.postUser("https://www.google.com/","login","password"));




    }
}

