/**
 * FilmResourcesServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package rest.services.resources;

public class FilmResourcesServiceLocator extends org.apache.axis.client.Service implements rest.services.resources.FilmResourcesService {

    public FilmResourcesServiceLocator() {
    }


    public FilmResourcesServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FilmResourcesServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FilmResources
    private java.lang.String FilmResources_address = "http://localhost:8080/SOAPImplementation/services/FilmResources";

    public java.lang.String getFilmResourcesAddress() {
        return FilmResources_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FilmResourcesWSDDServiceName = "FilmResources";

    public java.lang.String getFilmResourcesWSDDServiceName() {
        return FilmResourcesWSDDServiceName;
    }

    public void setFilmResourcesWSDDServiceName(java.lang.String name) {
        FilmResourcesWSDDServiceName = name;
    }

    public rest.services.resources.FilmResources getFilmResources() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FilmResources_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFilmResources(endpoint);
    }

    public rest.services.resources.FilmResources getFilmResources(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            rest.services.resources.FilmResourcesSoapBindingStub _stub = new rest.services.resources.FilmResourcesSoapBindingStub(portAddress, this);
            _stub.setPortName(getFilmResourcesWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFilmResourcesEndpointAddress(java.lang.String address) {
        FilmResources_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (rest.services.resources.FilmResources.class.isAssignableFrom(serviceEndpointInterface)) {
                rest.services.resources.FilmResourcesSoapBindingStub _stub = new rest.services.resources.FilmResourcesSoapBindingStub(new java.net.URL(FilmResources_address), this);
                _stub.setPortName(getFilmResourcesWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("FilmResources".equals(inputPortName)) {
            return getFilmResources();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://resources.services.rest", "FilmResourcesService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://resources.services.rest", "FilmResources"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("FilmResources".equals(portName)) {
            setFilmResourcesEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
