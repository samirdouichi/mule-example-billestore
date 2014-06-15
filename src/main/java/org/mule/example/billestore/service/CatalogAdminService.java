/*
 * $Id: CatalogAdminService.java 20320 2010-11-24 15:03:31Z dfeist $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.example.billestore.service;

import java.util.Collection;

import org.mule.example.billestore.domain.Bille;

/** 
 * Administration interface for adding new billes to the billestore's catalog 
 */
public interface CatalogAdminService
{
    /** Add a new bille to the catalog */
    long addBille(Bille bille);

    /** Add a group of new billes to the catalog */
    Collection <Long> addBilles(Collection <Bille> billes);
}
