package mediator.antipattern;

import java.util.*;

abstract class Component {
    public abstract void receiveMessage(String message);
}

class ComponentA extends Component {
    private ComponentB componentB;
    private ComponentC componentC;
    private ComponentD componentD;
    private Map<String, Integer> messageCounts = new HashMap<>();

    public void setComponentB(ComponentB componentB) {
        this.componentB = componentB;
    }

    public void setComponentC(ComponentC componentC) {
        this.componentC = componentC;
    }

    public void setComponentD(ComponentD componentD) {
        this.componentD = componentD;
    }

    public void sendMessage(String message) {
        System.out.println("ComponentA sending: " + message);
        if (message.contains("urgent")) {
            if (componentC != null) componentC.receiveMessage("Urgent update from A");
        } else if (message.contains("process")) {
            if (componentB != null) componentB.receiveMessage("Processing request from A");
        } else if (messageCounts.getOrDefault(message, 0) > 3) {
            if (componentD != null) componentD.receiveMessage("High Count: " + message);
        }
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("ComponentA received: " + message);
        messageCounts.put(message, messageCounts.getOrDefault(message, 0) + 1);
    }

    public int getMessageCount(String message) {
        return messageCounts.getOrDefault(message, 0);
    }

    public void printMessageCounts() {
        System.out.println("Message counts in ComponentA:");
        for (Map.Entry<String, Integer> entry : messageCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

class ComponentB extends Component {
    private ComponentC componentC;
    private List<String> pendingMessages = new ArrayList<>();

    public void setComponentC(ComponentC componentC) {
        this.componentC = componentC;
    }

    public void sendMessage(String message) {
        System.out.println("ComponentB sending: " + message);
        if (message.contains("process")) {
            if (componentC != null) componentC.receiveMessage("Processed by B: " + message);
        }
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("ComponentB received: " + message);
        pendingMessages.add(message);
        processPendingMessages();
    }

    private void processPendingMessages() {
        for (String msg : new ArrayList<>(pendingMessages)) {
            pendingMessages.remove(msg);
            if (msg.contains("processed")) {
                if (componentC != null) componentC.receiveMessage("Further processed by B: " + msg);
            }
        }
    }

    public void printPendingMessages() {
        System.out.println("Pending messages in ComponentB:");
        for (String msg : pendingMessages) {
            System.out.println(msg);
        }
    }
}

class ComponentC extends Component {
    private ComponentD componentD;
    private List<String> messageLog = new ArrayList<>();
    private boolean urgentMessageReceived = false;

    public void setComponentD(ComponentD componentD) {
        this.componentD = componentD;
    }

    public void sendMessage(String message) {
        System.out.println("ComponentC sending: " + message);
        if (message.contains("urgent")) {
            if (componentD != null) componentD.receiveMessage("Urgent forwarded from C: " + message);
        }
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("ComponentC received: " + message);
        messageLog.add(message);
        processMessage(message);
    }

    private void processMessage(String message) {
        if (message.contains("urgent")) {
            urgentMessageReceived = true;
            System.out.println("Urgent message processed by ComponentC.");
        } else if (message.contains("processed")) {
            System.out.println("Processed message handled by ComponentC.");
        } else {
            System.out.println("Regular message processed by ComponentC.");
        }
    }

    public void printMessageLog() {
        System.out.println("Message log in ComponentC:");
        for (String msg : messageLog) {
            System.out.println(msg);
        }
    }

    public boolean isUrgentMessageReceived() {
        return urgentMessageReceived;
    }
}

class ComponentD extends Component {
    private List<String> messageLog = new ArrayList<>();
    private int urgentMessageCount = 0;

    @Override
    public void receiveMessage(String message) {
        System.out.println("ComponentD received: " + message);
        messageLog.add(message);
        if (message.contains("Urgent")) {
            urgentMessageCount++;
            System.out.println("Urgent message count in ComponentD: " + urgentMessageCount);
        }
    }

    public void printMessageLog() {
        System.out.println("Message log in ComponentD:");
        for (String msg : messageLog) {
            System.out.println(msg);
        }
    }

    public int getUrgentMessageCount() {
        return urgentMessageCount;
    }
}

