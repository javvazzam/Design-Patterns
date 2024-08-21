package chainofresposability.chainofresponsability1.basic;

import java.util.Arrays;
import java.util.List;

class SupportRequest {
    enum Type {
        HARDWARE, SOFTWARE, NETWORK
    }

    private Type type;

    public SupportRequest(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}

class NetworkSupportHandler {

    private List<SupportRequest> requests;

    public NetworkSupportHandler(List<SupportRequest> requests){
        this.requests = requests;
    }
    public void handleRequest() {
        for(SupportRequest request: requests) {
            if (request.getType() == SupportRequest.Type.NETWORK) {
                System.out.println("Network Support Handler: Handling network issue.");
            }
            else if (request.getType() == SupportRequest.Type.SOFTWARE) {
                System.out.println("Software Support Handler: Handling software issue.");
            }
            else if (request.getType() == SupportRequest.Type.HARDWARE) {
                System.out.println("Hardware Support Handler: Handling hardware issue.");
            }
        }
        
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear algunas solicitudes
        SupportRequest hardwareRequest = new SupportRequest(SupportRequest.Type.HARDWARE);
        SupportRequest softwareRequest = new SupportRequest(SupportRequest.Type.SOFTWARE);
        SupportRequest networkRequest = new SupportRequest(SupportRequest.Type.NETWORK);
        List<SupportRequest> requests = Arrays.asList(hardwareRequest, softwareRequest, networkRequest);
        // Procesar las solicitudes
        System.out.println("Processing Request:");
        NetworkSupportHandler handler = new NetworkSupportHandler(requests);
        handler.handleRequest();
    }
}