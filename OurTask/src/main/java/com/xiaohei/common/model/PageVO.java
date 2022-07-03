package com.xiaohei.common.model;

/**
 * Created by cc on 2022/7/3
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Data
@Setter
@Getter
public class PageVO<T> {

    private Long current;

    private Long pages;

    private Long size;

    private Long total;

    private List<T> records;

    private Boolean hasNext;

    public PageVO() {
    }

    public PageVO(Long current, Long pages, Long size, Long total, List<T> records) {
        this.current = current;
        this.pages = pages;
        this.size = size;
        this.total = total;
        this.records = records;
        this.hasNext = pages > current;
    }

    public static <T> PageVO<T> convert(Long current, Long pages, Long size, Long total, List<T> records) {
        return new PageVO(current, pages, size, total, records);
    }

    public static <T> PageVO<T> convert(IPage page, List<T> records) {
        PageVO<T> pageVO = new PageVO();
        pageVO.setCurrent(page.getCurrent());
        pageVO.setPages(page.getPages());
        pageVO.setSize(page.getSize());
        pageVO.setTotal(page.getTotal());
        pageVO.setRecords(records);
        pageVO.setHasNext(page.getCurrent() < page.getPages());
        return pageVO;
    }

    public static <T> PageVO<T> convert(Page<?> page, List<T> list) {
        return convert(page, list, 1);
    }

    public static <T> PageVO<T> convert(Page<T> page, int startPage) {
        return convert(page, page.getContent(), startPage);
    }

    public static <T> PageVO<T> convert(Page<?> page, List<T> list, int startPage) {
        PageVO<T> pageVO = new PageVO();
        pageVO.setCurrent((long) page.getNumber() + (long) startPage);
        pageVO.setPages((long) page.getTotalPages());
        pageVO.setSize((long) page.getSize());
        pageVO.setTotal(page.getTotalElements());
        pageVO.setRecords(list);
        pageVO.setHasNext(page.hasNext());
        return pageVO;
    }

    public static <T> PageVO<T> createEmptyVO(PageQueryRequest request) {
        PageVO<T> pageVO = new PageVO();
        pageVO.setCurrent(request.getCurrent());
        pageVO.setPages(0L);
        pageVO.setSize(request.getSize());
        pageVO.setTotal(0L);
        pageVO.setRecords(new ArrayList());
        pageVO.setHasNext(false);
        return pageVO;
    }

    public static <T> PageVO<T> empty(Long current, Long size) {
        PageVO<T> pageVO = new PageVO();
        pageVO.setCurrent(current);
        pageVO.setPages(0L);
        pageVO.setSize(size);
        pageVO.setTotal(0L);
        pageVO.setRecords(Collections.emptyList());
        pageVO.setHasNext(false);
        return pageVO;
    }

    public static <T> PageVO<T> empty(Integer current, Integer size) {
        PageVO<T> pageVO = new PageVO();
        pageVO.setCurrent((long) current);
        pageVO.setPages(0L);
        pageVO.setSize((long) size);
        pageVO.setTotal(0L);
        pageVO.setRecords(Collections.emptyList());
        pageVO.setHasNext(false);
        return pageVO;
    }

    public static <T> PageVO<T> convert(PageVO pageVO, List<T> records) {
        PageVO<T> pageVONew = new PageVO();
        pageVONew.setCurrent(pageVO.getCurrent());
        pageVONew.setPages(pageVO.getPages());
        pageVONew.setSize(pageVO.getSize());
        pageVONew.setTotal(pageVO.getTotal());
        pageVONew.setRecords(records);
        pageVONew.setHasNext(pageVO.getHasNext());
        return pageVONew;
    }


}
