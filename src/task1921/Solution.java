package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        String fileName = args[0];
        FileReader fr = new FileReader(fileName);
        BufferedReader br1 = new BufferedReader(fr);

        String line;
        while ((line = br1.readLine()) != null) {
            String[] dataFromLine = line.split(" ");
            StringBuilder sbName = new StringBuilder("");
            StringBuilder sbDate = new StringBuilder("");

            for (int i = 0; i < dataFromLine.length; i++) {
                try {
                    int data = Integer.parseInt(dataFromLine[i]);
                    sbDate.append(data).append(" ");
                } catch (NumberFormatException e) {
                    sbName.append(dataFromLine[i]).append(" ");
                    continue;
                }
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd M yyyy");
            Date birthDate = sdf.parse(sbDate.toString().trim());
            Person person = new Person(sbName.toString().trim(), birthDate);
            PEOPLE.add(person);
        }
        fr.close();
        br1.close();

    }
}
