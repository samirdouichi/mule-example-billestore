/*
 * $Id: CatalogService.java 20320 2010-11-24 15:03:31Z dfeist $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.example.billestore.service;

import java.util.Collection;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.mule.example.billestore.domain.Bille;

/** 
 * Interface for working with the billestore's catalog of billes 
 */
@WebService
public interface CatalogService
{
    /** The catalog will be accesible as a web service at this URL */
    static final String URL = "http://0.0.0.0:8777/services/catalog";

    /** Return a collection of all billes in the catalog */
    @WebResult(name="billes") 
    Collection<Bille> getBilles();

    /** Look up the details for a particular bille by ID */
    @WebResult(name="bille") 
    Bille getBille(@WebParam(name="billeId") long billeId);
}
