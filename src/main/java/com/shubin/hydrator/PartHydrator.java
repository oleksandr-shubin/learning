package com.shubin.hydrator;

import com.shubin.model.computer.parts.Part;
import com.shubin.model.computer.parts.PartType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartHydrator implements Hydrator<Part> {
    @Override
    public List<Part> hydrateList(ResultSet rs) throws SQLException {
        List<Part> parts = new ArrayList<>();
        while (rs.next()) {
            Part part = new Part();
            part.setPartId(rs.getInt("part_id"));
            part.setType(PartType.valueOf(rs.getString("type")));
            part.setInfo(rs.getString("info"));
            part.setAmount(rs.getInt("amount"));
            part.setPrice(rs.getInt("price"));
            parts.add(part);
        }
        return parts;
    }
}
