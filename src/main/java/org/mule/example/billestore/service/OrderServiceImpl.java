/*
 * $Id: OrderServiceImpl.java 19418 2010-09-08 07:22:48Z dirk.olmes $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.example.billestore.service;

import javax.jws.WebService;

import org.mule.example.billestore.domain.Bille;
import org.mule.example.billestore.domain.Order;

/**
 * Service for placing a Bille order.
 * @see OrderService
 */
@WebService(serviceName="OrderService", endpointInterface="org.mule.example.Billestore.OrderService")
public class OrderServiceImpl implements OrderService
{
    public Order orderBille(Bille Bille, int quantity, String address, String email)
    {
        System.out.println("Order has been placed for Bille: " + Bille.getTitle());
        return new Order(Bille, quantity, address, email);
    }
}
