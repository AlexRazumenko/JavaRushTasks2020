package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    private static Person person = null;

    public static void main(String[] args) throws ParseException {
        //start here - начни тут

        if (args.length < 1) throw new UnsupportedOperationException();

        switch (args[0]) {
            case "-c":
                create(args);
                break;
            case "-u":
                update(args);
                break;
            case "-d":
                delete(args);
                break;
            case "-i":
                print(args);
                break;
            default:
                break;
        }
    }

    public static void create(String args[]) throws ParseException {
        String name = args[1];

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = dateFormat1.parse(args[3]);

        if (args[2].equals("м")) person = Person.createMale(name, date);
        else if (args[2].equals("ж")) person = Person.createFemale(name, date);
        allPeople.add(person);
        System.out.println(allPeople.indexOf(person));
    }

    public static void update(String args[]) throws ParseException {
        person = allPeople.get(Integer.parseInt(args[1]));
        person.setName(args[2]);
        if (args[3].equals("м")) person.setSex(Sex.MALE);
        else if (args[3].equals("ж")) person.setSex(Sex.FEMALE);

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = dateFormat1.parse(args[4]);

        person.setBirthDate(date);
    }

    public static void delete(String args[]) {
        person = allPeople.get(Integer.parseInt(args[1]));
        person.setName(null);
        person.setSex(null);
        ;
        person.setBirthDate(null);
    }

    public static void print(String args[]) throws ParseException {
        person = allPeople.get(Integer.parseInt(args[1]));
        String sex = "";
        if (person.getSex() == Sex.MALE) sex = "м";
        if (person.getSex() == Sex.FEMALE) sex = "ж";

        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        System.out.println(person.getName() + " " + sex + " " + dateFormat2.format(person.getBirthDate()));
    }
}
