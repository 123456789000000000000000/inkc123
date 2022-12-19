package com.example.indiannationalkennelclub;

public class SpinnerMicroImplementedby {
    String emp_type_id,emp_type_name;

    public SpinnerMicroImplementedby(String emp_type_id, String emp_type_name) {
        this.emp_type_id = emp_type_id;
        this.emp_type_name = emp_type_name;
    }

    @Override
    public String toString() {
        return emp_type_name;
    }
}
