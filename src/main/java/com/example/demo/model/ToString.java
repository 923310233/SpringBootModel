package com.example.demo.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Author: 吴硕涵
 * @Date: 2018/11/12 11:45 AM
 * @Version 1.0
 */
public class ToString {
    /** serialVersionUID */
////    TODO:
//    private static final long serialVersionUID = 0L;

    /**
     * 重写toString方法
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);

    }
}
