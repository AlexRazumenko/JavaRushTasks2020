package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException, NumberFormatException {
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    create(args);
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    update(args);
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    delete(args);
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    print(args);
                }
                break;
            default:
        }
    }

    public static void create(String[] args) throws ParseException {
        Person person;
        for (int i = 1; i < args.length; i++) {
            if (i % 3 == 0) {
                SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date date = sd.parse(args[i]);
                if (args[i - 1].equals("м")) person = Person.createMale(args[i - 2], date);
                else if (args[i - 1].equals("ж")) person = Person.createFemale(args[i - 2], date);
                else continue;
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            }
        }
    }

    public static void update(String[] args) throws ParseException {
        for (int i = 1; i < args.length; i++) {
            if (i % 4 == 0) {
                int index = Integer.parseInt(args[i-3]);
                Person person = allPeople.get(index);
                person.setName(args[i - 2]);
                if (args[i - 1].equals("м")) person.setSex(Sex.MALE);
                else if (args[i - 1].equals("ж")) person.setSex(Sex.FEMALE);

                SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                person.setBirthDate(sd.parse(args[i]));
                allPeople.set(index, person);
            }
        }
    }

    public static void delete(String[] args) throws NumberFormatException {
        Person person;
        for (int i = 1; i < args.length; i++) {
            int index = Integer.parseInt(args[i]);
            person = allPeople.get(index);
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
        }
    }

    public static void print(String[] args) {
        for (int i = 1; i < args.length; i++) {
            SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

            int index = Integer.parseInt(args[i]);
            Person person = allPeople.get(index);
            System.out.println(String.format("%s %s %s", person.getName(), person.getSex() == Sex.FEMALE ? "ж" : "м",
                    format.format(person.getBirthDate())));
        }
    }
}
