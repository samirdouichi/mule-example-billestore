/*
 * $Id: DataWarehouse.java 19418 2010-09-08 07:22:48Z dirk.olmes $
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
import org.mule.example.billestore.web.HtmlTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Tracks statistics on bille orders.
 */
public class DataWarehouse
{
    int billesOrdered = 0;
    double totalRevenue = 0;
    double averagePrice = 0;
    Map <String, Integer> sales = new HashMap <String, Integer> ();
    String bestSeller = "";
    
    public String updateStats(Order order)
    {
        Bille bille = order.getBille();
        billesOrdered += order.getQuantity();
        totalRevenue += (bille.getPrice() * order.getQuantity());
        averagePrice = totalRevenue / billesOrdered;

        String title = bille.getTitle();
        Integer quantity = sales.get(title);
        if (quantity == null)
        {
            sales.put(title, order.getQuantity());
        }
        else
        {
            sales.put(title, quantity + order.getQuantity());
        }
        bestSeller = getBestSeller();
        
        System.out.println("Updating stats");
        return HtmlTemplate.wrapHtmlBody(printHtmlStats());
    }

    protected String getBestSeller()
    {
        String title = "";
        int quantity = 0;
        for (Entry<String, Integer> entry : sales.entrySet())
        {
            if (entry.getValue() > quantity)
            {
                title = entry.getKey();
                quantity = entry.getValue();
            }
        }
        return title;
    }
    
    protected String printHtmlStats()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("<h2>Data Warehouse Statistics</h2>");
        sb.append("<table>");
        sb.append("  <tr><th>Billes sold</th> <td>").append(billesOrdered).append("</td></tr>");
        sb.append(String.format("  <tr><th>Total revenue</th> <td>$%.2f</td></tr>", totalRevenue));
        sb.append(String.format("  <tr><th>Average price</th> <td>$%.2f</td></tr>", averagePrice));
        sb.append("<tr><th>Best seller</th> <td>").append(bestSeller).append("</td></tr>");
        sb.append("</table>");

        return sb.toString();
    }
}
