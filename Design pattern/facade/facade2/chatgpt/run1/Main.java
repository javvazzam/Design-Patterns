package facade.facade2.chatgpt.run1;

import java.util.ArrayList;
import java.util.List;

interface StringOperation {
    String apply(String input);
}

class ToUpperCase implements StringOperation {
    @Override
    public String apply(String input) {
        return input.toUpperCase();
    }
}

class ToLowerCase implements StringOperation {
    @Override
    public String apply(String input) {
        return input.toLowerCase();
    }
}

class ReverseString implements StringOperation {
    @Override
    public String apply(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}

class ReplaceSpaces implements StringOperation {
    @Override
    public String apply(String input) {
        return input.replace(" ", "_");
    }
}


class StringProcessor {
    private List<StringOperation> operations;

    public StringProcessor() {
        this.operations = new ArrayList<>();
    }

    public void addOperation(StringOperation operation) {
        operations.add(operation);
    }

    public String process(String input) {
        for (StringOperation operation : operations) {
            input = operation.apply(input);
        }
        return input;
    }
}


public class Main {
    public static void main(String[] args) {
        StringProcessor processor = new StringProcessor();
        
        // Add desired operations
        processor.addOperation(new ToUpperCase());
        processor.addOperation(new ReplaceSpaces());
        processor.addOperation(new ReverseString());
        
        // Process the string
        String result = processor.process("Hello World");
        
        System.out.println(result);  // Output: DLROW_OLLEH
    }
}
