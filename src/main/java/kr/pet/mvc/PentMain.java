package kr.pet.mvc;

import java.util.List;
import java.util.Scanner;

public class PentMain {
    public static void main(String[] args) {
        MedicalRecordController recordController = new MedicalRecordController();
        CustomerController customerController = new CustomerController(recordController);
        ConsoleView view = new ConsoleView();

        while (true) {
            System.out.println("===ペットケア管理システム===");
            System.out.println("1. 新規顧客情報の入力");
            System.out.println("2. 医療記録の保存");
            System.out.println("3. 診療記録の照会");
            System.out.println("4. 診療記録の削除");
            System.out.println("5. 終了");
            System.out.print("希望の機能を選択してください:");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Customer newCustomer = view.getCustomerInfo();
                    String phoneNumber = newCustomer.getPhoneNumber();
                    if (customerController.isPhoneNumberExist(phoneNumber)) {
                        view.printMessage("すでに登録されている電話番号です。");
                        continue;
                    }
                    customerController.addCustomer(newCustomer);
                    view.printMessage("顧客情報が追加されました。");
                    break;
                case 2:
                    phoneNumber = view.getPhoneNumber();
                    if (customerController.findCustomer(phoneNumber) == null) {
                        view.printMessage("その電話番号を持つ顧客情報はありません。");
                        break;
                    }
                    Customer customer = customerController.findCustomer(phoneNumber);
                    MedicalRecord newRecord = view.getMedicalRecordInfo();
                    newRecord.setPhoneNumber(phoneNumber);
                    recordController.addMedicalRecord(newRecord);
                    customer.addMedicalRecords(newRecord);
                    view.printMessage("診療記録が保存されました");
                    break;
                case 3:
                    phoneNumber = view.getPhoneNumber();
                    List<MedicalRecord> records = recordController.findMedicalRecords(phoneNumber);
                    if (records.isEmpty()) {
                        view.printMessage("その電話番号を持つ診療記録はありません。");
                        break;
                    }
                    customer = customerController.findCustomer(phoneNumber);
                    view.printMedicalRecordInfo(customer);
                    break;
                case 4:
                    phoneNumber = view.getPhoneNumber();
                    if (customerController.findCustomer(phoneNumber) == null) {
                        view.printMessage("その電話番号を持つ顧客情報はありません。");
                        break;
                    }
                    recordController.removeMedicalRecord(phoneNumber);
                    view.printMessage("診療記録情報が削除されました。");
                    break;

                case 5:
                    System.out.println("プログラムを終了します。");
                    return;

                default:
                    System.out.println("間違った選択です。");
                    break;

            }
        }
    }
}
