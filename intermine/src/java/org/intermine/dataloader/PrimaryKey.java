package org.flymine.dataloader;

/*
 * Copyright (C) 2002-2003 FlyMine
 *
 * This code may be freely distributed and modified under the
 * terms of the GNU Lesser General Public Licence.  This should
 * be distributed with the code.  See the LICENSE file for more
 * information or http://www.gnu.org/copyleft/lesser.html.
 *
 */

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/**
 * Class represing a primary key as a list of field names
 *
 * @author Andrew Varley
 * @author Mark Woodbridge
 */
public class PrimaryKey
{
    Set fieldNames = new LinkedHashSet();

    /**
     * Constructor
     *
     * @param fields a comma-delimited list of field names
     */
    public PrimaryKey(String fields) {
        if (fields == null) {
            throw new NullPointerException("fields parameter cannot be null");
        }
        for (StringTokenizer st = new StringTokenizer(fields, ", "); st.hasMoreTokens();) {
            fieldNames.add(st.nextToken());
        }
    }
    
    /**
     * Return the Set of field names
     *
     * @return the Set of field names
     */
    public Set getFieldNames() {
        return fieldNames;
    }

    /**
     * @see Object#equals
     */
    public boolean equals(Object o) {
        if (o instanceof PrimaryKey) {
            return fieldNames.equals(((PrimaryKey) o).fieldNames);
        }
        return false;
    }

    /**
     * @see Object#hashCode
     */
    public int hashCode() {
        return fieldNames.hashCode();
    }
}
