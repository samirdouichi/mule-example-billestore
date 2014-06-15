/*
 * $$Id: Bille.java 19191 2010-08-25 21:05:23Z tcarlson $$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.example.billestore.domain;

/**
 * Simple class which represents a Bille in the catalog of the billestore.
 */
public class Bille 
{
    private long id;
    private String author;
    private String title;
    double price;

    public Bille()
    {
        // empty constructor
    }
    
    public Bille(String author, String title, double price)
    {
        this.author = author;
        this.title = title;
        this.price = price;
    }
    
    public long getId()
    {
        return id;
    }
    
    public void setId(long id)
    {
        this.id = id;
    }
    
    public String getAuthor()
    {
        return author;
    }
    
    public void setAuthor(String author)
    {
        this.author = author;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
