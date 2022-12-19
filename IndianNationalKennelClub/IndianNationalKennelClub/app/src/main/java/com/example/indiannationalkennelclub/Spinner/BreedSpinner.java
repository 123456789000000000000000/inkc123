package com.example.indiannationalkennelclub.Spinner;

public class BreedSpinner {
    public String sub_cat_id,pet_category_id,sub_category_name,sub_category_code;

    public BreedSpinner(String sub_cat_id, String pet_category_id, String sub_category_name, String sub_category_code) {
        this.sub_cat_id = sub_cat_id;
        this.pet_category_id = pet_category_id;
        this.sub_category_name = sub_category_name;
        this.sub_category_code = sub_category_code;
    }

    @Override
    public String toString() {
        return sub_category_name;
    }
}
