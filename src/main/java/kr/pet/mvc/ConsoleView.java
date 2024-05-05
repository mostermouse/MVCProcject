package kr.pet.mvc;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private Scanner sc = new Scanner(System.in);

    //電話番号を入力する画面
    public String getPhoneNumber() {
        System.out.print("電話番号を入力してください :");
        return sc.nextLine();
    }

    //신규고객정보 입력 화면
    public Customer getCustomerInfo() {
        System.out.println("新しい顧客情報を入力してください。");
        System.out.print("電話番号 :");
        String phoneNumber = sc.nextLine();
        System.out.print("所有者名 :");
        String ownerName = sc.nextLine();
        System.out.print("動物名 :");
        String petName = sc.nextLine();
        System.out.print("住所 :");
        String address = sc.nextLine();
        System.out.print("種類 :");
        String species = sc.nextLine();
        System.out.print("誕生年(yyyy) :");
        int birthYear = sc.nextInt();
        sc.nextLine();
        return new Customer(phoneNumber, ownerName, petName, address, species, birthYear);
    }

    //診療記録を入力する画面
    public MedicalRecord getMedicalRecordInfo() {
        System.out.print("診療日を入力してください :");
        String date = sc.nextLine();

        System.out.print("診療内容を入力してください :");
        String content = sc.nextLine();

        return new MedicalRecord(null, date, content);
    }

    // 診療記録照会による出力
    public void printMedicalRecordInfo(Customer customer) {
        List<MedicalRecord> records = customer.getMedicalRecords();
        System.out.println("[" + customer.getPetName() + "]の診療記録");
        for (MedicalRecord record : records) {
            System.out.println("- 診療日: " + record.getDate());
            System.out.println("  診療内容: " + record.getContent());
            System.out.println("  所有者名: " + customer.getOwnerName());
            System.out.println("  動物名: " + customer.getPetName());
            System.out.println("  住所: " + customer.getAddress());
            System.out.println("  種類: " + customer.getSpecies());
            System.out.println("  誕生年: " + customer.getBirthYear());
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
