/**
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * fmt
 * Copyright (C) 2014 Pascal Poizat (@pascalpoizat)
 * emails: pascal.poizat@lip6.fr
 */

package models.base;

import java.io.File;
import java.io.IOException;

public abstract class AbstractModel {

    private static final String SUFFIX_SEPARATOR = ".";

    private File resource;

    public AbstractModel() {
        resource = null;
    }

    // sets resource
    public void setResource(final File resource) throws IllegalResourceException {
        if (resource == null) {
            throw new IllegalResourceException("No resource given");
        }
        this.resource = resource;
    }

    // gets resource
    public File getResource() {
        return resource;
    }

    // gets suffix (part of the file name after the last ".", ie gives "zzz" for "xxx.yyy.zzz")
    public String getSuffix() throws IllegalResourceException {
        if (resource == null) {
            throw new IllegalResourceException("Resource is not set");
        }
        int indexSeparator = resource.getName().lastIndexOf(SUFFIX_SEPARATOR);
        if (indexSeparator == -1) {
            return "";
        }
        return resource.getName().substring(indexSeparator + 1, resource.getName().length());
    }

    // gets suffix (part of the file name after the last ".", ie gives "zzz" for "xxx.yyy.zzz")
    public String getNameWithoutSuffix() throws IllegalResourceException {
        if (resource == null) {
            throw new IllegalResourceException("Resource is not set");
        }
        int indexSeparator = resource.getName().lastIndexOf(SUFFIX_SEPARATOR);
        if (indexSeparator == -1) {
            return resource.getName();
        }
        return resource.getName().substring(0, resource.getName().lastIndexOf(SUFFIX_SEPARATOR));
    }

    // writes model to a file
    public final void modelToFile(final AbstractModelWriter writer) throws IOException, IllegalResourceException, IllegalModelException {
        writer.modelToFile(this);
    }

    // reads model from a file
    public final void modelFromFile(final AbstractModelReader reader) throws IOException, IllegalResourceException, IllegalModelException {
        reader.modelFromFile(this);
    }

    // writes model to a string
    public final String modelToString(final AbstractStringModelWriter writer) throws IllegalResourceException, IllegalModelException {
        return writer.modelToString(this);
    }

    // finalization (cleans up resources)
    public void cleanUp() {
        resource = null;
    }

}
