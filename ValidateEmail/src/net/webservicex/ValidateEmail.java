
package net.webservicex;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "ValidateEmail", targetNamespace = "http://www.webservicex.net", wsdlLocation = "http://www.webservicex.net/ValidateEmail.asmx?WSDL")
public class ValidateEmail
    extends Service
{

    private final static URL VALIDATEEMAIL_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(net.webservicex.ValidateEmail.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = net.webservicex.ValidateEmail.class.getResource(".");
            url = new URL(baseUrl, "http://www.webservicex.net/ValidateEmail.asmx?WSDL");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://www.webservicex.net/ValidateEmail.asmx?WSDL', retrying as a local file");
            logger.warning(e.getMessage());
        }
        VALIDATEEMAIL_WSDL_LOCATION = url;
    }

    public ValidateEmail(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ValidateEmail() {
        super(VALIDATEEMAIL_WSDL_LOCATION, new QName("http://www.webservicex.net", "ValidateEmail"));
    }

    /**
     * 
     * @return
     *     returns ValidateEmailSoap
     */
    @WebEndpoint(name = "ValidateEmailSoap")
    public ValidateEmailSoap getValidateEmailSoap() {
        return super.getPort(new QName("http://www.webservicex.net", "ValidateEmailSoap"), ValidateEmailSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ValidateEmailSoap
     */
    @WebEndpoint(name = "ValidateEmailSoap")
    public ValidateEmailSoap getValidateEmailSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.webservicex.net", "ValidateEmailSoap"), ValidateEmailSoap.class, features);
    }

}