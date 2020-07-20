package task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) {

        String xmlString = "";
        try {
            StringWriter sw = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(obj, sw);
            xmlString = sw.toString();
        } catch (JAXBException e) {
        }
        String openTag = "<" + tagName;
        comment = "<!--" + comment + "-->";

        if (xmlString.isEmpty()) return null;
        if (!xmlString.contains(tagName)) return xmlString;

        List<Integer> cdataIndexes = new ArrayList<>();
        int openIndex = 0;
        int closeIndex = 0;
        while ((openIndex = xmlString.indexOf("<![CDATA", openIndex)) != -1) {
            cdataIndexes.add(openIndex);
            openIndex = openIndex + 8;
        }
        while ((closeIndex = xmlString.indexOf("]]>", closeIndex)) != -1) {
            cdataIndexes.add(closeIndex);
            closeIndex += 4;
        }
        Collections.sort(cdataIndexes);

        StringBuilder sb = new StringBuilder(xmlString);
        int tagIndex = 0;
        int delta = openTag.length() + comment.length();
        while ((tagIndex = sb.indexOf(openTag, tagIndex)) != -1) {

            boolean isInCData = false;
            for (int i = 1; i < cdataIndexes.size(); i += 2) {
                isInCData = false;
                if ((tagIndex > cdataIndexes.get(i - 1)) && (tagIndex < cdataIndexes.get(i))) {
                    isInCData = true;
                    break;
                }
            }
            if (!isInCData) {
                for (int i = 0; i < cdataIndexes.size(); i++) {
                    if (cdataIndexes.get(i) >= tagIndex)
                    cdataIndexes.set(i, cdataIndexes.get(i) + comment.length());
                }
                sb.insert(tagIndex, comment);
                tagIndex += delta;
            } else {
                tagIndex += 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String result = toXmlWithComment(new Date(), "second", "it's a comment");
//        System.out.println(result);
    }
}
