package nihad.uninews.ir.uninews.WebServices;

import org.ksoap2.serialization.PropertyInfo;

import java.util.ArrayList;
import java.util.List;

public class CallSoapParametrs {
    public OperationList OPERATION_NAME;
    public String SOAP_ACTION = "http://nezaratemdad.ir";
    public String SOAP_ADDRESS = "http://NezaratEmdad.ir/Daneshjoo.asmx";
    public String WSDL_TARGET_NAMESPACE = "http://nezaratemdad.ir/";
    public List<PropertyInfo> parametrs = new ArrayList();
}
