package com.shubin.service;

import com.shubin.mapper.PartMySQLMapper;
import com.shubin.model.computer.parts.Part;
import com.shubin.model.computer.parts.PartType;

import java.util.ArrayList;
import java.util.List;

public class PartService {
    private PartMySQLMapper mapper;

    public PartService(PartMySQLMapper mapper) {
        this.mapper = mapper;
    }

    public List<Part> findAllAvailableParts() throws IllegalStateException {
        try {
            return mapper.findAllAvailable();
        } catch (Exception e) {
            throw new IllegalStateException("Wrong response from mapper", e);
        }
    }

    public List<Part> filterPartsByType(List<Part> parts, PartType filter) {
        List<Part> filteredParts = new ArrayList<Part>();
        for (Part part : parts) {
            if (part.getType() == filter) {
                filteredParts.add(part);
            }
        }
        return filteredParts;
    }

    public Part filterPartsById(List<Part> parts, int partId) {
        for (Part part : parts) {
            if (part.getPartId() == partId) {
                return part;
            }
        }
        return null;
    }
}
