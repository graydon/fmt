/**
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * <p>
 * {description}
 * Copyright (C) 2014  pascalpoizat
 * emails: pascal.poizat@lip6.fr
 */

package models.choreography.stg;

import models.base.AbstractModel;
import models.base.AbstractStringModelWriter;
import models.base.IllegalModelException;
import models.base.IllegalResourceException;

public class DotStgWriter extends AbstractStringModelWriter {
    @Override
    public String getSuffix() {
        return "dot";
    }

    @Override
    public String modelToString(AbstractModel model) throws IllegalModelException {
        if (!(model instanceof StgModel)) {
            throw new IllegalModelException(String.format("Wrong kind of model (%s), should be %s",
                    model.getClass().toString(),
                    StgModel.class.toString()));
        }
        StgModel stgModel = (StgModel)model;
        return stgModel.toDot();
    }
}