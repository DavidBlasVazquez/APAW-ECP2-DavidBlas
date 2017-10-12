package es.upm.miw.apaw.user.api;

import es.upm.miw.apaw.user.api.resources.SportResource;
import es.upm.miw.apaw.user.api.resources.UserResource;
import es.upm.miw.apaw.user.http.HttpRequest;
import es.upm.miw.apaw.user.http.HttpResponse;
import es.upm.miw.apaw.user.http.HttpStatus;
import es.upm.miw.user.api.resources.exceptions.RequestInvalidException;
import es.upm.miw.user.api.resources.exceptions.SportIdNotFoundException;
import es.upm.miw.user.api.resources.exceptions.UserFieldInvalidException;
import es.upm.miw.user.api.resources.exceptions.UserIdNotFoundException;


public class Dispatcher {
    private UserResource userResource = new UserResource();
    private SportResource sportResource = new SportResource();
    
    //TODO remove it to next phase.
    private void validateField(String field) throws UserFieldInvalidException {
        if (field == null || field.isEmpty()) {
            throw new UserFieldInvalidException(field);
        }
    }
    
    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(SportResource.SPORT + SportResource.ID)) { 
            	Integer sportId = Integer.valueOf(request.paths()[1]);
            	if (sportId != 1) throw new SportIdNotFoundException();
            	response.setBody("{\"id\":1,\"sport\":\"tennis\",\"category\":\"junior\"}");
            } else if (request.isEqualsPath(UserResource.USER + UserResource.ID)) {
            	Integer userId = Integer.valueOf(request.paths()[1]);
            	if (userId != 1) throw new SportIdNotFoundException(); 
                response.setBody("{\"id\":1,\"username\":\"David\",\"active\":\"true\"}");
            } else {
               throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(SportResource.SPORT)) {
            	String sportName = request.getBody();
            	validateField(sportName);
                response.setStatus(HttpStatus.CREATED);
            } else if (request.isEqualsPath(UserResource.USER)) {
            	String userName = request.getBody();
            	validateField(userName);
                response.setStatus(HttpStatus.CREATED);
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doPut(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(UserResource.USER + UserResource.ID + UserResource.SPORT)) {
            	Integer userId = Integer.valueOf(request.paths()[1]);
                Integer sportId = Integer.valueOf(request.getBody()); 
            	if (userId  != 1) throw new UserIdNotFoundException();
            	if (sportId != 1) throw new SportIdNotFoundException();
            	response.setBody("{\"id\":1,\"username\":\"David\",\"active\":\"true\", \"sport\":[ {\"title\":\"tennis\", \"category\":\"junior\"} ]}");
                response.setStatus(HttpStatus.OK);
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doPatch(HttpRequest request, HttpResponse response) {
    	 try {
             if (request.isEqualsPath(UserResource.USER + UserResource.ID + UserResource.ACTIVE) ) {
            	 Integer userId = Integer.valueOf(request.paths()[1]);
              	 boolean activeState = Boolean.valueOf(request.getBody());
               	 if (userId != 1) throw new UserIdNotFoundException();
        		 response.setBody("{\"id\":1,\"username\":\"David\",\"active\":\"" + activeState + "\"}");
                 response.setStatus(HttpStatus.OK);
             } else if (request.isEqualsPath(SportResource.SPORT + SportResource.ID + SportResource.CATEGORY) ) {
            	 Integer sportId = Integer.valueOf(request.paths()[1]);
            	 String  category = request.getBody();
             	 if (sportId != 1) throw new SportIdNotFoundException();
            	 response.setBody("{\"id\":1,\"sport\":\"tennis\",\"category\":\"" + category + "\"}");
            	 response.setStatus(HttpStatus.OK);
             } else {
                 throw new RequestInvalidException(request.getPath());
             }
         } catch (Exception e) {
             responseError(response, e);
         }
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
          responseError(response, new RequestInvalidException(request.getPath()));
    }

}
