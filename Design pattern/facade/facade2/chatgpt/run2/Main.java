package facade.facade2.chatgpt.run2;


import java.util.ArrayList;
import java.util.List;

interface StringTransformer {
    String transform(String input);
}

class ToUpperCase implements StringTransformer {
    @Override
    public String transform(String input) {
        return input.toUpperCase();
    }
}

class ToLowerCase implements StringTransformer {
    @Override
    public String transform(String input) {
        return input.toLowerCase();
    }
}

class ReverseString implements StringTransformer {
    @Override
    public String transform(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}

class ReplaceSpaces implements StringTransformer {
    @Override
    public String transform(String input) {
        return input.replace(" ", "_");
    }
}

class StringTransformationManager {
    private List<StringTransformer> transformers = new ArrayList<>();

    // Method to add a transformer to the list
    public void addTransformer(StringTransformer transformer) {
        transformers.add(transformer);
    }

    // Method to apply all transformers to a string
    public String applyTransformations(String input) {
        String result = input;
        for (StringTransformer transformer : transformers) {
            result = transformer.transform(result);
        }
        return result;
    }

    // Method to clear all transformers
    public void clearTransformers() {
        transformers.clear();
    }
}

public class Main {
    public static void main(String[] args) {
        // Define the input string
        String input = "Hello World";

        // Create the transformation manager
        StringTransformationManager manager = new StringTransformationManager();

        // Add transformations
        manager.addTransformer(new ToUpperCase());
        manager.addTransformer(new ReverseString());
        manager.addTransformer(new ReplaceSpaces());

        // Apply transformations
        String result = manager.applyTransformations(input);

        // Output the result
        System.out.println("Original: " + input);    // Output: Hello World
        System.out.println("Transformed: " + result); // Output: DLROW_OLLEH
    }
}
