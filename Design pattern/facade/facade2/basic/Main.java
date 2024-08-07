package facade.facade2.basic;

//Crear una cadena de string y hacer transformaciones en base a un facade

class ToUpperCase {
    public String convert(String input) {
        return input.toUpperCase();
    }
}

class ToLowerCase {
    public String convert(String input) {
        return input.toLowerCase();
    }
}

class ReverseString {
    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}

class ReplaceSpaces {
    public String replace(String input) {
        return input.replace(" ", "_");
    }
}

//I want to encapsulate the funcionality of these classes in order to apply it to a string
