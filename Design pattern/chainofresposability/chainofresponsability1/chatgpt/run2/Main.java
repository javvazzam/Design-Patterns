package chainofresposability.chainofresponsability1.chatgpt.run2;

import java.util.List;
import java.util.Arrays;

// SupportRequest class
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

// Abstract handler class
abstract class SupportHandler {
    protected SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(SupportRequest request) {
        if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No handler available for request type: " + request.getType());
        }
    }
}

// Concrete handler for hardware support
class HardwareSupportHandler extends SupportHandler {

    @Override
    public void handleRequest(SupportRequest request) {
        if (request.getType() == SupportRequest.Type.HARDWARE) {
            System.out.println("Hardware Support Handler: Handling hardware issue.");
        } else {
            super.handleRequest(request);
        }
    }
}

// Concrete handler for software support
class SoftwareSupportHandler extends SupportHandler {

    @Override
    public void handleRequest(SupportRequest request) {
        if (request.getType() == SupportRequest.Type.SOFTWARE) {
            System.out.println("Software Support Handler: Handling software issue.");
        } else {
            super.handleRequest(request);
        }
    }
}

// Concrete handler for network support
class NetworkSupportHandler extends SupportHandler {

    @Override
    public void handleRequest(SupportRequest request) {
        if (request.getType() == SupportRequest.Type.NETWORK) {
            System.out.println("Network Support Handler: Handling network issue.");
        } else {
            super.handleRequest(request);
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create some support requests
        SupportRequest hardwareRequest = new SupportRequest(SupportRequest.Type.HARDWARE);
        SupportRequest softwareRequest = new SupportRequest(SupportRequest.Type.SOFTWARE);
        SupportRequest networkRequest = new SupportRequest(SupportRequest.Type.NETWORK);

        List<SupportRequest> requests = Arrays.asList(hardwareRequest, softwareRequest, networkRequest);

        // Create handlers
        SupportHandler hardwareHandler = new HardwareSupportHandler();
        SupportHandler softwareHandler = new SoftwareSupportHandler();
        SupportHandler networkHandler = new NetworkSupportHandler();

        // Set the chain of responsibility
        hardwareHandler.setNextHandler(softwareHandler);
        softwareHandler.setNextHandler(networkHandler);

        // Process the requests
        System.out.println("Processing Requests:");
        for (SupportRequest request : requests) {
            hardwareHandler.handleRequest(request);
        }
    }
}
