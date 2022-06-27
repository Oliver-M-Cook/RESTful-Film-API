/**
 * FilmResourcesService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package rest.services.resources;

public interface FilmResourcesService extends javax.xml.rpc.Service {
    public java.lang.String getFilmResourcesAddress();

    public rest.services.resources.FilmResources getFilmResources() throws javax.xml.rpc.ServiceException;

    public rest.services.resources.FilmResources getFilmResources(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
