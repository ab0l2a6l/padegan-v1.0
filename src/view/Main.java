package view;

import common.StaticScanner;
import controler.PadeganControler;
import model.entity.Padegan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PadeganControler padeganControler = new PadeganControler();
        Scanner input = StaticScanner.getDate();

        for (; ; ) {
            menu();
            int requestFromUser = input.nextInt();
            input.nextLine();

            switch (requestFromUser) {
                case 1 -> {
                    Padegan padegan = new Padegan();
                    System.out.print ("id ra vared konid: ");
                    padegan.setId(input.nextLong());
                    input.nextLine();

                    System.out.print ("nam ra vared konid: ");
                    padegan.setFullName(input.nextLine());

                    System.out.print ("saat vorood ra vared konid: ");
                    padegan.setEntryTime(input.nextLine());

                    System.out.print ("saat khorooj ra vared konid: ");
                    padegan.setDepartureTime(input.nextLine());

                    System.out.print ("tarikh vorod ra vared konid: ");
                    padegan.setDate(input.nextLine());

                    padeganControler.save(padegan);
                }

                case 2 -> {
                    Padegan padegan = new Padegan();
                    System.out.print ("id ra vared konid: ");
                    padegan.setId(input.nextLong());
                    input.nextLine();

                    System.out.print ("tarikh  ra vared konid: ");
                    padegan.setDate(input.nextLine());

                    System.out.println(padeganControler.readDate(padegan.getId(), padegan.getDate()));
                }

                case 3 -> {
                    return;
                }

                default ->
                    System.out.println("wrong number");

            }

        }
    }

    private static void menu() {
        System.out.println("1.sabt vorod o khoroj");
        System.out.println("2.didan etelaat fard");
        System.out.println("3.exit");
    }

}
