/**
 * FilmResources.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package rest.services.resources;

public interface FilmResources extends java.rmi.Remote {
    public java.lang.String getFilmByIDAsString(int id) throws java.rmi.RemoteException;
    public java.lang.String getAllFilmsAsString() throws java.rmi.RemoteException;
    public java.lang.String getFilmByYearAsString(int year) throws java.rmi.RemoteException;
    public java.lang.String getFilmByNameAsString(java.lang.String name) throws java.rmi.RemoteException;
    public rest.services.models.Film[] getAllFilms() throws java.rmi.RemoteException;
    public void updateFilm(rest.services.models.Film film) throws java.rmi.RemoteException;
    public rest.services.models.Film[] getFilmByID(int id) throws java.rmi.RemoteException;
    public rest.services.models.Film[] getFilmByYear(int year) throws java.rmi.RemoteException;
    public rest.services.models.Film[] getFilmByName(java.lang.String name) throws java.rmi.RemoteException;
    public java.lang.String getNextID() throws java.rmi.RemoteException;
    public void insertFilm(rest.services.models.Film film) throws java.rmi.RemoteException;
    public void deleteFilm(java.lang.String id) throws java.rmi.RemoteException;
}
