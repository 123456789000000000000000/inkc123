package com.example.indiannationalkennelclub;

public class KennelInfoLitterRegister {
    String kennel_id,owner_user_id,is_second_owner,kennel_name;

    public KennelInfoLitterRegister(String kennel_id, String owner_user_id, String is_second_owner, String kennel_name) {
        this.kennel_id = kennel_id;
        this.owner_user_id = owner_user_id;
        this.is_second_owner = is_second_owner;
        this.kennel_name = kennel_name;
    }

    @Override
    public String toString() {
        return kennel_name;
    }
}
