/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2002-2008, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.gml2.bindings;

import org.geotools.gml2.GML;
import org.geotools.xml.Binding;
import org.w3c.dom.Document;

import com.vividsolutions.jts.geom.MultiLineString;


/**
 * 
 *
 * @source $URL$
 */
public class GMLMultiLineStringTypeBinding2Test extends GMLTestSupport {
    public void testType() {
        assertEquals(MultiLineString.class, binding(GML.MultiLineStringType).getType());
    }

    public void testExecutionMode() {
        assertEquals(Binding.OVERRIDE, binding(GML.MultiLineStringType).getExecutionMode());
    }

    public void testParse() throws Exception {
        GML2MockData.multiLineString(document, document);

        MultiLineString mp = (MultiLineString) parse();
        assertEquals(2, mp.getNumGeometries());
    }

    public void testEncode() throws Exception {
        Document doc = encode(GML2MockData.multiLineString(), GML.MultiLineString);

        assertEquals(2,
            doc.getElementsByTagNameNS(GML.NAMESPACE, GML.lineStringMember.getLocalPart())
               .getLength());
    }
}
