package io.robe.convert.excel.parsers;

import org.apache.poi.ss.usermodel.Cell;

import java.lang.reflect.Field;

public class ParseString implements IsParser {
    @Override
    public Object parse(Object o, Field field) {
        String s = String.valueOf(o.toString());

        return s;
    }

    @Override
    public void setCell(Object o, Cell cell, Field field) {
        if (o != null) {
            cell.setCellValue(o.toString());
        }
    }
}
