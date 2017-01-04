package com.shubin.validator;

import com.shubin.model.computer.parts.Part;

import java.util.List;

public class PartValidator {
    public boolean validId(List<Part> parts, int id) {
        for (Part part : parts) {
            if (part.getPartId() == id) {
                return true;
            }
        }
        return false;
    }
}
