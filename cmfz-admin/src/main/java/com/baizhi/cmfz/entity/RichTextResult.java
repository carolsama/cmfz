package com.baizhi.cmfz.entity;

import java.util.List;

/**
 * @Description 文本编辑器实体类
 * @Author Administrator
 * @Time 2018/7/8 20:03
 */
public class RichTextResult {
    private Integer errno;
    private List<String> data;

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
