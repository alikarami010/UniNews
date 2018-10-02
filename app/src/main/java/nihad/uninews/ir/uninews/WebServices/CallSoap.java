package nihad.uninews.ir.uninews.WebServices;

import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class CallSoap {
    public static String TAG = "CallSoap";
    CallSoapParametrs callSoapParametrs;

    public CallSoap(CallSoapParametrs callSoapParametrs) {
        this.callSoapParametrs = callSoapParametrs;
    }

    public String Call() {
        Object response;
        SoapObject request = new SoapObject(this.callSoapParametrs.WSDL_TARGET_NAMESPACE, this.callSoapParametrs.OPERATION_NAME.toString());
        for (PropertyInfo pi : this.callSoapParametrs.parametrs) {
            request.addProperty(pi);
            Log.i(TAG, "Params =  " + pi.getName() + " = " + pi.getValue());
        }
        Log.i(TAG, "Params finish  ");
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        try {
            new HttpTransportSE(this.callSoapParametrs.SOAP_ADDRESS).call(this.callSoapParametrs.SOAP_ACTION + this.callSoapParametrs.OPERATION_NAME.toString(), envelope);
            response = envelope.getResponse();
            Log.i(TAG, "response = " + response);
        } catch (Exception exception) {
            Log.i(TAG, "Exception  = " + exception.toString());
//            Log.i(TAG,"WSDL_TARGET_NAMESPACE = "+this.callSoapParametrs.WSDL_TARGET_NAMESPACE);
//            Log.i(TAG,"OPERATION_NAME = "+this.callSoapParametrs.OPERATION_NAME.toString());
//            Log.i(TAG,"SOAP_ADDRESS = "+this.callSoapParametrs.SOAP_ADDRESS);
            response = exception.toString();
        }
//        Log.i(TAG, "response.toString() =  " + response.toString());
        return response.toString();
    }
}
