/*
 * $Id: BillestoreTestCase.java 22620 2011-08-09 10:02:17Z dirk.olmes $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.example.billestore;

import org.mule.example.billestore.domain.Bille;
import org.mule.example.billestore.domain.Order;
import org.mule.example.billestore.service.CatalogService;
import org.mule.example.billestore.service.OrderService;
import org.mule.tck.junit4.FunctionalTestCase;

import java.util.Collection;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BillestoreTestCase extends FunctionalTestCase
{

    @Override
    protected String getConfigResources()
    {
        return "billestore-config.xml";
    }
    
    @Test
    public void testGetBilles()
    {
        // Catalog web service
        JaxWsProxyFactoryBean pf = new JaxWsProxyFactoryBean();
        pf.setServiceClass(CatalogService.class);
        pf.setAddress(CatalogService.URL);
        CatalogService catalog = (CatalogService) pf.create();
        assertNotNull(catalog);

        Collection <Bille> billes = catalog.getBilles();
        assertNotNull(billes);
        // Number of billes added as test data in CatalogServiceImpl.initialise()
        assertEquals(13, billes.size());
    }

    @Test
    public void testOrderBille()
    {
        // Catalog web service
        JaxWsProxyFactoryBean pf = new JaxWsProxyFactoryBean();
        pf.setServiceClass(CatalogService.class);
        pf.setAddress(CatalogService.URL);
        CatalogService catalog = (CatalogService) pf.create();
        assertNotNull(catalog);

        // Order web service
        JaxWsProxyFactoryBean pf2 = new JaxWsProxyFactoryBean();
        pf2.setServiceClass(OrderService.class);
        pf2.setAddress(OrderService.URL);
        OrderService orderService = (OrderService) pf2.create();     
        assertNotNull(orderService);

        // Place an order for bille #3 from the catalog
        Bille bille = catalog.getBille(3); 
        assertNotNull(bille);
        Order order = orderService.orderBille(bille, 2, "Somewhere", "me@my-mail.com"); 
        assertNotNull(order);
        assertEquals(3, order.getBille().getId());
        assertEquals(2, order.getQuantity());
        assertEquals("me@my-mail.com", order.getEmail());
    }

//    @Test
//    public void testAddBille() throws Exception
//    {
//        HttpServletRequest request = new Request();
//        request.setAttribute("title", "blah");
//        request.setAttribute("author", "blah");
//        
//        MuleClient client = new MuleClient(muleContext);
//        client.send("servlet://catalog", request, null);
//    }
}
