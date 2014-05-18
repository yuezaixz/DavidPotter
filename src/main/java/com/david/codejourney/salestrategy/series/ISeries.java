package com.david.codejourney.salestrategy.series;

import com.david.codejourney.salestrategy.book.Book;

public interface ISeries {  
    /** 
     * 判断栈是否为空 
     */  
    boolean isEmpty();  
    /** 
     * 清空栈 
     */  
    void clear();  
    /** 
     * 栈的长度 
     */  
    int length();  
    /** 
     * 数据入栈 
     */  
    boolean push(Book data);  
    /** 
     * 数据出栈 
     */  
    Book pop();  
}  