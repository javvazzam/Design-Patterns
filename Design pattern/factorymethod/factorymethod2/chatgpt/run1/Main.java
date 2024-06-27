package factorymethod.factorymethod2.chatgpt.run1;

import java.util.Random;

// Button interface
interface Button {
    void render();
    void onClick(Runnable f);
}

// WindowsButton implementation
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Render Windows button.");
    }

    @Override
    public void onClick(Runnable f) {
        System.out.println("Windows button click event bound.");
        f.run();
    }
}

// HTMLButton implementation
class HTMLButton implements Button {
    @Override
    public void render() {
        System.out.println("Render HTML button.");
    }

    @Override
    public void onClick(Runnable f) {
        System.out.println("HTML button click event bound.");
        f.run();
    }
}

// Dialog abstract class
abstract class Dialog {
    public void render(Button button) {
        button.onClick(this::closeDialog);
        button.render();
    }

    private void closeDialog() {
        System.out.println("Dialog closed.");
    }
}

// WindowsDialog implementation
class WindowsDialog extends Dialog {}

// HTMLDialog implementation
class HTMLDialog extends Dialog {}

// ButtonFactory interface
interface ButtonFactory {
    Button createButton();
}

// DialogFactory interface
interface DialogFactory {
    Dialog createDialog();
}

// Concrete factories for Windows components
class WindowsButtonFactory implements ButtonFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

class WindowsDialogFactory implements DialogFactory {
    @Override
    public Dialog createDialog() {
        return new WindowsDialog();
    }
}

// Concrete factories for HTML components
class HTMLButtonFactory implements ButtonFactory {
    @Override
    public Button createButton() {
        return new HTMLButton();
    }
}

class HTMLDialogFactory implements DialogFactory {
    @Override
    public Dialog createDialog() {
        return new HTMLDialog();
    }
}

// Application class
class Application {
    private Dialog dialog;
    private Button button;

    void initialize(ButtonFactory buttonFactory, DialogFactory dialogFactory) throws Exception {
        button = buttonFactory.createButton();
        dialog = dialogFactory.createDialog();
    }

    void runApplication() {
        try {
            initialize(getButtonFactory(), getDialogFactory());
            dialog.render(button);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ButtonFactory getButtonFactory() {
        String configOS = readApplicationConfigFile();
        if ("Windows".equals(configOS)) {
            return new WindowsButtonFactory();
        } else if ("Web".equals(configOS)) {
            return new HTMLButtonFactory();
        } else {
            throw new RuntimeException("Error! Unknown operating system.");
        }
    }

    private DialogFactory getDialogFactory() {
        String configOS = readApplicationConfigFile();
        if ("Windows".equals(configOS)) {
            return new WindowsDialogFactory();
        } else if ("Web".equals(configOS)) {
            return new HTMLDialogFactory();
        } else {
            throw new RuntimeException("Error! Unknown operating system.");
        }
    }

    private String readApplicationConfigFile() {
        String[] options = {"Windows", "Web"};
        Random random = new Random();
        return options[random.nextInt(options.length)];
    }

    public static void main(String[] args) {
        new Application().runApplication();
    }
}
