package kr.pet.mvc;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordController {
    private List<MedicalRecord> records = new ArrayList<>();

    //診療記録を登録するメソッド
    public void addMedicalRecord(MedicalRecord record){
        records.add(record);
    }

    //診療記録を削除するメソッド
    public void removeMedicalRecord(String phoneNumber){
        for(int i = 0; i< records.size(); i++){
            if(records.get(i).getPhoneNumber().equals(phoneNumber)){
                records.remove(i);
                break;
            }
        }
    }

    //電話番号に対応するすべての診療記録を検索して新しいList<MedicalRecord>を作成するメソッド
    public List<MedicalRecord> findMedicalRecords(String phoneNumber){
        List<MedicalRecord> result = new ArrayList<>();
        for(MedicalRecord record : records){
            if(record.getPhoneNumber().equals(phoneNumber)){
                result.add(record);
            }
        }
        return result;
    }

}
