package factorymethod.factorymethod2.chatgpt.run2;

import java.util.Random;

abstract class Dialog {
    public void render(Button button) {
        button.onClick(this::closeDialog);
        button.render();
    }

    private void closeDialog() {
        System.out.println("Dialog closed.");
    }
}

interface Button {
    void render();
    void onClick(Runnable f);
}

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

interface DialogFactory {
    Dialog createDialog();
    Button createButton();
}

class WindowsDialogFactory implements DialogFactory {
    @Override
    public Dialog createDialog() {
        return new Dialog() {};
    }

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

class HTMLDialogFactory implements DialogFactory {
    @Override
    public Dialog createDialog() {
        return new Dialog() {};
    }

    @Override
    public Button createButton() {
        return new HTMLButton();
    }
}

class Application {
    private Dialog dialog;
    private Button button;

    void initialize() throws Exception {
        DialogFactory factory;
        String configOS = readApplicationConfigFile();

        if ("Windows".equals(configOS)) {
            factory = new WindowsDialogFactory();
        } else if ("Web".equals(configOS)) {
            factory = new HTMLDialogFactory();
        } else {
            throw new Exception("Error! Unknown operating system.");
        }

        this.dialog = factory.createDialog();
        this.button = factory.createButton();
    }

    private String readApplicationConfigFile() {
        String[] options = {"Windows", "Web"};
        Random random = new Random();
        return options[random.nextInt(options.length)];
    }

    void main() throws Exception {
        this.initialize();
        dialog.render(button);
    }

    public static void main(String[] args) {
        try {
            new Application().main();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



