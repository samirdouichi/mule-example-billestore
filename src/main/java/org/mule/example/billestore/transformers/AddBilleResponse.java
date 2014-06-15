/*
 * $Id: AddBilleResponse.java 19418 2010-09-08 07:22:48Z dirk.olmes $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.example.billestore.transformers;

import org.mule.api.transformer.TransformerException;
import org.mule.example.billestore.web.HtmlTemplate;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

/**
 * A call to addBille() returns a Long representing the number of
 * billes in the catalog.  This transformer wraps the Long into
 * a nice HTML page.
 */
public class AddBilleResponse extends AbstractTransformer
{
    public AddBilleResponse()
    {
        super();
        registerSourceType(DataTypeFactory.create(Long.class));
        setReturnDataType(DataTypeFactory.STRING);
    }

    @Override
    protected Object doTransform(Object src, String outputEncoding) throws TransformerException
    {
        Long numBilles = (Long) src;
        String response = "Catalog now contains: " + numBilles + " bille(s)";
        return HtmlTemplate.wrapHtmlBody(response);
    }
}
