package com.nt.client;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.Courier;
import com.nt.sbeans.Flipkart;

public class ShipChoiceTest {
    public static void main(String[] args) {
        Scanner sc;
        try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml")) {
            Flipkart fpkt = ctx.getBean("fpkt", Flipkart.class);
            sc = new Scanner(System.in);
            System.out.println("Choose courier (bDart/dhl/dtdc): ");
            String courierType = sc.nextLine();
            System.out.println("Enter Seller Name");
            String name = sc.nextLine();
            Courier selectedCourier = ctx.getBean(courierType, Courier.class);
            fpkt.setCourier(selectedCourier);
            String result = fpkt.processOrder(
                    new String[] {"Shirt", "Pant"},
                    new double[] {500.0, 1000.0},
                    courierType
            );  System.out.println(result+" By "+name);
        }
        sc.close();
    }
}