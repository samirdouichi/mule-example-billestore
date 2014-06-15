/*
 * $Id: OrderToEmailTransformer.java 22714 2011-08-22 15:43:51Z dirk.olmes $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.example.billestore.transformers;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.example.billestore.domain.Bille;
import org.mule.example.billestore.domain.Order;
import org.mule.transformer.AbstractMessageTransformer;
import org.mule.transformer.types.DataTypeFactory;
import org.mule.transport.email.MailProperties;

/**
 * Composes an e-mail notification message to be sent based on the Bille Order.
 */
public class OrderToEmailTransformer extends AbstractMessageTransformer
{
    public OrderToEmailTransformer()
    {
        super();
        registerSourceType(DataTypeFactory.create(Order.class));
        setReturnDataType(DataTypeFactory.STRING);
    }

    @Override
    public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException
    {
        Order order = (Order) message.getPayload();
        Bille bille = order.getBille();

        String body =  "Thank you for placing your order for " +
                       bille.getTitle() + " with the Mule-powered On-line Billestore. " +
                       "Your order will be shipped  to " +
                       order.getAddress() + " by the next business day.";

        String email = order.getEmail();
        message.setOutboundProperty(MailProperties.TO_ADDRESSES_PROPERTY, email);

        logger.info("Sending e-mail notification to " + email);
        return body;
    }
}
