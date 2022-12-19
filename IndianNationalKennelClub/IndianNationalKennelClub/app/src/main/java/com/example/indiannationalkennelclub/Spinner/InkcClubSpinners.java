package com.example.indiannationalkennelclub.Spinner;

public class InkcClubSpinners {

    public String kennel_club_id,kennel_club_name,kennel_club_prefix;

    public InkcClubSpinners(String kennel_club_id, String kennel_club_name, String kennel_club_prefix) {
        this.kennel_club_id = kennel_club_id;
        this.kennel_club_name = kennel_club_name;
        this.kennel_club_prefix = kennel_club_prefix;
    }

    @Override
    public String toString() {
        return kennel_club_name ;
    }
}
