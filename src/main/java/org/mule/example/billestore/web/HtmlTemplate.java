/*
 * $Id: HtmlTemplate.java 20320 2010-11-24 15:03:31Z dfeist $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.example.billestore.web;

/**
 * Poor man's CSS stylesheet
 */
public class HtmlTemplate
{
    public static String wrapHtmlBody(String body)
    {
        String output = "";
        
        output += "<html>";
        output += "<head>";
        output += "<meta http-equiv=\"Content-Language\" content=\"en-us\"/>";
        output += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\"/>";
        output += "<title>Billestore Administration Console</title>";
        output += "</head>";

        output += "<body link=\"#FFFFFF\" vlink=\"#FFFFFF\" alink=\"#FFFFFF\" bgcolor=\"#990000\" text=\"#FFFFFF\">";            
        output += body;            
        output += "</body>";

        output += "<br/><a href=\"/billestore-admin/\">Return to Home Page</a>";
        output += "</html>";
        
        return output;
    }
}


