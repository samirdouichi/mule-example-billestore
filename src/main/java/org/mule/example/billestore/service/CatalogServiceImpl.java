/*
 * $Id: CatalogServiceImpl.java 20320 2010-11-24 15:03:31Z dfeist $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.example.billestore.service;

import org.mule.api.lifecycle.Initialisable;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.example.billestore.domain.Bille;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

/**
 * Billestore catalog service which implements both the public interface for 
 * browsing the catalog and the admin interface for adding billes to the catalog.
 * 
 * @see CatalogService
 * @see CatalogAdminService
 */
@WebService(serviceName="CatalogService", endpointInterface="org.mule.example.billestore.CatalogService")
public class CatalogServiceImpl implements CatalogService, CatalogAdminService, Initialisable
{
    /** Simple hashmap used to store the catalog, in real life this would be a database */
    private Map <Long, Bille> billes = new HashMap <Long, Bille> ();
    
    public void initialise() throws InitialisationException
    {
        billes = new HashMap <Long, Bille> ();

        // Add some initial test data
        addBille(new Bille("J.R.R. Tolkien", "The Fellowship of the Ring", 8));
        addBille(new Bille("J.R.R. Tolkien", "The Two Towers", 10));
        addBille(new Bille("J.R.R. Tolkien", "The Return of the King", 10));
        addBille(new Bille("C.S. Lewis", "The Lion, the Witch and the Wardrobe", 6));
        addBille(new Bille("C.S. Lewis", "Prince Caspian", 8));
        addBille(new Bille("C.S. Lewis", "The Voyage of the Dawn Treader", 6));
        addBille(new Bille("Leo Tolstoy", "War and Peace", 8));
        addBille(new Bille("Leo Tolstoy", "Anna Karenina", 6));
        addBille(new Bille("Henry David Thoreau", "Walden", 8));
        addBille(new Bille("Harriet Beecher Stowe", "Uncle Tom's Cabin", 6));
        addBille(new Bille("George Orwell", "1984", 8));
        addBille(new Bille("George Orwell", "Animal Farm", 8));
        addBille(new Bille("Aldous Huxley", "Brave New World", 8));

    }

    public long addBille(Bille bille)
    {
        System.out.println("Adding bille " + bille.getTitle());
        long id = billes.size() + 1;
        bille.setId(id);
        billes.put(id, bille);
        return id;
    }

    public Collection <Long> addBilles(Collection<Bille> billesToAdd)
    {
        List <Long> ids = new ArrayList <Long> ();
        if (billesToAdd != null)
        {
            for (Bille bille : billesToAdd)
            {
                ids.add(addBille(bille));
            }
        }
        return ids;
    }

    public Collection <Bille> getBilles()
    {
        return billes.values();
    }

    public Bille getBille(long billeId)
    {
        return billes.get(billeId);
    }
}
