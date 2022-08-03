package com.situ.web.util;


import com.situ.web.pojo.Teacher;

import java.util.List;

public class PageInfo<T>{
//    存放的数据
    private List<T> list;
//    当前页
    private Integer pageNo;
//    一页显示的数据数量
    private Integer pageSize;
//    总共的页数
    private Integer totalPages;

    public PageInfo() {

    }

    public PageInfo(List<T> list, Integer pageNo, Integer pageSize, Integer totalPages) {
        this.list = list;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "list=" + list +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalPages=" + totalPages +
                '}';
    }
}
