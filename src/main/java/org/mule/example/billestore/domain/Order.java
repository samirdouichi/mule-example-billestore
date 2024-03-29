/*
 * $Id: Order.java 19191 2010-08-25 21:05:23Z tcarlson $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.example.billestore.domain;


/**
 * Simple class which represents a Bille Order.
 */
public class Order 
{
    private Bille bille;
    private int quantity;
    /** Shipping address */
    private String address;
    /** E-mail address used to receive order notifications */
    private String email;
    
    public Order()
    {
        // empty constructor
    }
    
    public Order(Bille bille, int quantity, String address, String email)
    {
        this.bille = bille;
        this.quantity = quantity;
        this.address = address;
        this.email = email;
    }
    
    public Bille getBille()
    {
        return bille;
    }

    public void setBille(Bille bille)
    {
        this.bille = bille;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
