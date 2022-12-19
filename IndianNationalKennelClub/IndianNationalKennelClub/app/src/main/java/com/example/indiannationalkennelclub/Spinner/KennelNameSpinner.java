package com.example.indiannationalkennelclub.Spinner;

public class KennelNameSpinner {
    public String kennel_id,owner_user_id,is_second_owner,second_owner_id,kennel_name,kennel_comment,kennel_status,is_kennel_name_paid;

    public KennelNameSpinner(String kennel_id, String owner_user_id, String is_second_owner, String second_owner_id, String kennel_name, String kennel_comment, String kennel_status, String is_kennel_name_paid) {
        this.kennel_id = kennel_id;
        this.owner_user_id = owner_user_id;
        this.is_second_owner = is_second_owner;
        this.second_owner_id = second_owner_id;
        this.kennel_name = kennel_name;
        this.kennel_comment = kennel_comment;
        this.kennel_status = kennel_status;
        this.is_kennel_name_paid = is_kennel_name_paid;
    }

    @Override
    public String toString() {
        return  kennel_name ;
    }
}
