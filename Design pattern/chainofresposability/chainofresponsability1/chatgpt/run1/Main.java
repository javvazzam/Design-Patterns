package chainofresposability.chainofresponsability1.chatgpt.run1;

import java.util.Arrays;
import java.util.List;

// SupportRequest class to represent different types of support requests
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

// SupportHandler interface defining the structure for handlers
interface SupportHandler {
    void setNextHandler(SupportHandler handler);
    void handleRequest(SupportRequest request);
}

// HardwareSupportHandler class to handle hardware-related requests
class HardwareSupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(SupportRequest request) {
        if (request.getType() == SupportRequest.Type.HARDWARE) {
            System.out.println("Hardware Support Handler: Handling hardware issue.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

// SoftwareSupportHandler class to handle software-related requests
class SoftwareSupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(SupportRequest request) {
        if (request.getType() == SupportRequest.Type.SOFTWARE) {
            System.out.println("Software Support Handler: Handling software issue.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

// NetworkSupportHandler class to handle network-related requests
class NetworkSupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(SupportRequest request) {
        if (request.getType() == SupportRequest.Type.NETWORK) {
            System.out.println("Network Support Handler: Handling network issue.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

// Main class to demonstrate the Chain of Responsibility pattern
public class Main {
    public static void main(String[] args) {
        // Create support requests
        SupportRequest hardwareRequest = new SupportRequest(SupportRequest.Type.HARDWARE);
        SupportRequest softwareRequest = new SupportRequest(SupportRequest.Type.SOFTWARE);
        SupportRequest networkRequest = new SupportRequest(SupportRequest.Type.NETWORK);
        SupportRequest anotherNetworkRequest = new SupportRequest(SupportRequest.Type.NETWORK);

        List<SupportRequest> requests = Arrays.asList(hardwareRequest, softwareRequest, networkRequest, anotherNetworkRequest);

        // Create handlers
        SupportHandler hardwareHandler = new HardwareSupportHandler();
        SupportHandler softwareHandler = new SoftwareSupportHandler();
        SupportHandler networkHandler = new NetworkSupportHandler();

        // Set up the chain of responsibility
        hardwareHandler.setNextHandler(softwareHandler);
        softwareHandler.setNextHandler(networkHandler);

        // Process the requests
        System.out.println("Processing Requests:");
        for (SupportRequest request : requests) {
            hardwareHandler.handleRequest(request);
        }
    }
}
