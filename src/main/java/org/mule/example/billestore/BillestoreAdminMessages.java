/*
 * $Id: BillestoreAdminMessages.java 19418 2010-09-08 07:22:48Z dirk.olmes $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.example.billestore;

import org.mule.config.i18n.Message;
import org.mule.config.i18n.MessageFactory;

public class BillestoreAdminMessages extends MessageFactory
{
    private static final BillestoreAdminMessages factory = new BillestoreAdminMessages();
    
    private static final String BUNDLE_PATH = "messages.billestore-admin-messages";

    public static Message missingAuthor()
    {
        return factory.createMessage(BUNDLE_PATH, 1);
    }

    public static Message missingTitle()
    {
        return factory.createMessage(BUNDLE_PATH, 2);
    }

    public static Message missingPrice()
    {
        return factory.createMessage(BUNDLE_PATH, 3);
    }
}
