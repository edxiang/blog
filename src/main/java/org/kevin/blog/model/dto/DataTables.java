package org.kevin.blog.model.dto;

import org.kevin.blog.model.Finance;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2018-12-28
 */
public class DataTables {
    private int start;
    private int length;
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<Finance> data;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<Finance> getData() {
        return data;
    }

    public void setData(List<Finance> data) {
        this.data = data;
    }
}
