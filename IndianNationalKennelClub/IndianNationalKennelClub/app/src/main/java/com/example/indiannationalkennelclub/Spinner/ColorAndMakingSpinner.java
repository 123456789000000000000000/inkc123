package com.example.indiannationalkennelclub.Spinner;

public class ColorAndMakingSpinner {
    public String colour_id,colour_code,colour_name,colour_status;

    public ColorAndMakingSpinner(String colour_id, String colour_code, String colour_name, String colour_status) {
        this.colour_id = colour_id;
        this.colour_code = colour_code;
        this.colour_name = colour_name;
        this.colour_status = colour_status;
    }

    @Override
    public String toString() {
        return colour_name;
    }
}
