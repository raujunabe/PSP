import java.net.MalformedURLException;
import java.net.URL;

public class Ej302 {

    public static void main(String[] args) throws MalformedURLException {

        URL urlOracle = null;

        urlOracle = new URL("http://docs.oracle.com/");
        getUrlInfo(urlOracle);

        urlOracle = new URL("http","docs.oracle.com","/javase/23");
        getUrlInfo(urlOracle);

        urlOracle = new URL("http","docs.oracle.com",123,"javase/23");
        getUrlInfo(urlOracle);
    }

    private static void getUrlInfo(URL url){
        System.out.println("URL completa: "+url);
        System.out.println("getProtocol: "+url.getProtocol());
        System.out.println("getHost: "+url.getHost());
        System.out.println("getPort: "+url.getPort());
        System.out.println("getFile: "+url.getFile());
        System.out.println("getUserInfo: "+url.getUserInfo());
        System.out.println("getPath: "+url.getPath());
        System.out.println("getAuthority: "+url.getAuthority());
        System.out.println("getQuery: "+url.getQuery());
        System.out.println("getDefaultPort: "+url.getDefaultPort());
        System.out.println("==================================================");
    }
}
