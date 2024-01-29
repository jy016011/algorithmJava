package testDome;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* 67% test cases passed */
public class Folders {
    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
        Collection<String> collection = new ArrayList<>();
        String targetStart = "<folder name=\"" + startingLetter;
        int folderNameLength = targetStart.length() - 1;
        List<Integer> startIndexes = new ArrayList<>();
        int indexStart = xml.indexOf(targetStart);
        while (indexStart != -1) {
            startIndexes.add(indexStart);
            indexStart = xml.indexOf(targetStart, indexStart + 1);
        }
        for (int start : startIndexes) {
            String subStr = xml.substring(start + folderNameLength);
            int endIdx = subStr.indexOf("\"") + start + folderNameLength;
            subStr = xml.substring(start + folderNameLength, endIdx);
            collection.add(subStr);
        }
        return collection;
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"uc\">" +
                        "<folder name=\"uprogram files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for (String name : names) {
            System.out.println(name);
        }
    }
}
