package kr.pet.mvc;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    private List<Customer> customers;
    private MedicalRecordController recordController; //診療記録を管理するコントローラ

    public CustomerController(MedicalRecordController recordController) {
        this.customers = new ArrayList<>();
        this.recordController = recordController;
    }

    // 顧客情報を登録するメソッド
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // 顧客情報を削除するメソッド（必ずその顧客の診療記録も一緒に削除）
    public void removeCustomer(String phoneNumber) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getPhoneNumber().equals(phoneNumber)) {
                customers.remove(i);
                recordController.removeMedicalRecord(phoneNumber); //その顧客の診療記録を削除する
                break;
            }
        }
    }

    // 顧客登録を確認するメソッド
    public Customer findCustomer(String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return customer;
            }
        }
        return null;
    }

    //既存の電話番号で登録された顧客がいるかどうかを確認するメソッド（重複チェック）
    public boolean isPhoneNumberExist(String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
