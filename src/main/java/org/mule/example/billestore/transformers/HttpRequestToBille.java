/*
 * $Id: HttpRequestToBille.java 19250 2010-08-30 16:53:14Z dirk.olmes $
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
import org.mule.example.billestore.BillestoreAdminMessages;
import org.mule.example.billestore.domain.Bille;
import org.mule.transformer.AbstractMessageTransformer;
import org.mule.transformer.types.DataTypeFactory;
import org.mule.util.StringUtils;

/**
 * Transforms a Map of HttpRequest parameters into a Bille object.
 * The request parameters are always strings (they come from the HTML form),
 * so we need to parse and convert them to their appropriate types.
 */
public class HttpRequestToBille extends AbstractMessageTransformer
{
    public HttpRequestToBille()
    {
        super();
        registerSourceType(DataTypeFactory.OBJECT);
        setReturnDataType(DataTypeFactory.create(Bille.class));
    }

    @Override
    public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException
    {
        String author = message.getInboundProperty("author");
        String title = message.getInboundProperty("title");
        String price = message.getInboundProperty("price");

        if (StringUtils.isBlank(author))
        {
            throw new TransformerException(BillestoreAdminMessages.missingAuthor(), this);
        }
        if (StringUtils.isBlank(title))
        {
            throw new TransformerException(BillestoreAdminMessages.missingTitle(), this);
        }
        if (StringUtils.isBlank(price))
        {
            throw new TransformerException(BillestoreAdminMessages.missingPrice(), this);
        }

        return new Bille(author, title, Double.parseDouble(price));
    }
}
