package week3;



public class FileNameManipulator {

    public char findLastCharacter(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("Empty string!");
        }
        str = str.trim();
        return str.charAt(str.length() - 1);
    }

    public String findFileExtension(String fileName) {
        if (fileName == null || fileName.isBlank() || fileName.trim().startsWith(".") || fileName.trim().endsWith(".d")) {
            throw new IllegalArgumentException("Invalid file name!");}
        return fileName.substring(fileName.indexOf("."), fileName.length());
    }

    public String findFileName(String fileName) {
        if (fileName.indexOf(".") >=1) {return fileName.substring(0, fileName.indexOf(".")-1);}
        else throw new IllegalArgumentException("There is no filename!");
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        if (ext == null || ext.isBlank()) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        if (fileName == null || ext.equals(".")) {
            throw new IllegalArgumentException("Empty string!");}
        if (fileName.equalsIgnoreCase(".d") || ext.equals(".") || fileName.isBlank()) {
            throw new IllegalArgumentException("Invalid argument!");
        }

        if (fileName.lastIndexOf('.') < 1 || (fileName.lastIndexOf('.') == fileName.length() - 1)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        return findFileExtension(fileName).equalsIgnoreCase(ext);
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName) {
        if (searchedFileName == null || actualFileName == null || searchedFileName.isBlank() || actualFileName.isBlank()) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        return searchedFileName.equalsIgnoreCase(actualFileName);
    }

    public String changeExtensionToLowerCase(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("Empty string!");
        }
        if (fileName.equals(".") ||  fileName.trim().startsWith(".")) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        // fileName == ".java" || findFileExtension(fileName).equals(".") ||
        String[] = fileName.indexOf(".");
        throw new IllegalArgumentException("Invalid argument!");

    }

    public String replaceStringPart(String fileName, String present, String target) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("Empty string!");
        }
        return fileName.replace(present, target);
    }

    public static void main(String[] args) {
        //FileNameManipulator f = new FileNameManipulator();
        //System.out.println(f.changeExtensionToLowerCase("String.JAVA"));
        //String[] str = "String.JAVA".split(".");

        String[] words = "String.JAVA.kou.hgr".split(".");
        System.out.println(words[0]);
    }
}