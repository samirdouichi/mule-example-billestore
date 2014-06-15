/*
 * $Id: OrderService.java 19191 2010-08-25 21:05:23Z tcarlson $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.example.billestore.service;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.mule.example.billestore.domain.Bille;
import org.mule.example.billestore.domain.Order;

/** 
 * Interface for placing a bille order 
 */
@WebService
public interface OrderService
{
    /** The order service will be accesible as a web service at this URL */
    static final String URL = "http://0.0.0.0:8777/services/order";

    /** Place a bille order */
    @WebResult(name="order") 
    Order orderBille(@WebParam(name="bille") Bille bille,
                    @WebParam(name="quantity") int quantity, 
                    @WebParam(name="address") String address,
                    @WebParam(name="email") String email);
}
