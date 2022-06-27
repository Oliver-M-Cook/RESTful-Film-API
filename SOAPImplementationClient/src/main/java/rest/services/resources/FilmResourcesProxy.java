package rest.services.resources;

public class FilmResourcesProxy implements rest.services.resources.FilmResources {
  private String _endpoint = null;
  private rest.services.resources.FilmResources filmResources = null;
  
  public FilmResourcesProxy() {
    _initFilmResourcesProxy();
  }
  
  public FilmResourcesProxy(String endpoint) {
    _endpoint = endpoint;
    _initFilmResourcesProxy();
  }
  
  private void _initFilmResourcesProxy() {
    try {
      filmResources = (new rest.services.resources.FilmResourcesServiceLocator()).getFilmResources();
      if (filmResources != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)filmResources)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)filmResources)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (filmResources != null)
      ((javax.xml.rpc.Stub)filmResources)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public rest.services.resources.FilmResources getFilmResources() {
    if (filmResources == null)
      _initFilmResourcesProxy();
    return filmResources;
  }
  
  public java.lang.String getFilmByIDAsString(int id) throws java.rmi.RemoteException{
    if (filmResources == null)
      _initFilmResourcesProxy();
    return filmResources.getFilmByIDAsString(id);
  }
  
  public java.lang.String getAllFilmsAsString() throws java.rmi.RemoteException{
    if (filmResources == null)
      _initFilmResourcesProxy();
    return filmResources.getAllFilmsAsString();
  }
  
  public java.lang.String getFilmByYearAsString(int year) throws java.rmi.RemoteException{
    if (filmResources == null)
      _initFilmResourcesProxy();
    return filmResources.getFilmByYearAsString(year);
  }
  
  public java.lang.String getFilmByNameAsString(java.lang.String name) throws java.rmi.RemoteException{
    if (filmResources == null)
      _initFilmResourcesProxy();
    return filmResources.getFilmByNameAsString(name);
  }
  
  public rest.services.models.Film[] getAllFilms() throws java.rmi.RemoteException{
    if (filmResources == null)
      _initFilmResourcesProxy();
    return filmResources.getAllFilms();
  }
  
  public void updateFilm(rest.services.models.Film film) throws java.rmi.RemoteException{
    if (filmResources == null)
      _initFilmResourcesProxy();
    filmResources.updateFilm(film);
  }
  
  public rest.services.models.Film[] getFilmByID(int id) throws java.rmi.RemoteException{
    if (filmResources == null)
      _initFilmResourcesProxy();
    return filmResources.getFilmByID(id);
  }
  
  public rest.services.models.Film[] getFilmByYear(int year) throws java.rmi.RemoteException{
    if (filmResources == null)
      _initFilmResourcesProxy();
    return filmResources.getFilmByYear(year);
  }
  
  public rest.services.models.Film[] getFilmByName(java.lang.String name) throws java.rmi.RemoteException{
    if (filmResources == null)
      _initFilmResourcesProxy();
    return filmResources.getFilmByName(name);
  }
  
  public java.lang.String getNextID() throws java.rmi.RemoteException{
    if (filmResources == null)
      _initFilmResourcesProxy();
    return filmResources.getNextID();
  }
  
  public void insertFilm(rest.services.models.Film film) throws java.rmi.RemoteException{
    if (filmResources == null)
      _initFilmResourcesProxy();
    filmResources.insertFilm(film);
  }
  
  public void deleteFilm(java.lang.String id) throws java.rmi.RemoteException{
    if (filmResources == null)
      _initFilmResourcesProxy();
    filmResources.deleteFilm(id);
  }
  
  
}