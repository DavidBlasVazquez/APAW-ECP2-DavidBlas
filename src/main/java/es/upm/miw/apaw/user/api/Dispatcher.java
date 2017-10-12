package es.upm.miw.apaw.user.api;

import es.upm.miw.apaw.user.api.resources.SportResource;
import es.upm.miw.apaw.user.api.resources.UserResource;
import es.upm.miw.apaw.user.http.HttpRequest;
import es.upm.miw.apaw.user.http.HttpResponse;
import es.upm.miw.apaw.user.http.HttpStatus;

public class Dispatcher {

   // private UserResource userResource = new UserResource();
   // private SportResource sportResource = new SportResource();

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(SportResource.SPORT + SportResource.ID)) { 
                // TODO read Sport 
            	response.setBody("{\"id\":1,\"sport\":\"tennis\"}");
           	    // response.setBody("{\"id\":1,\"sport\":\"tennis\",\"category\":\"senior\"}");
            } else if (request.isEqualsPath(UserResource.USER + SportResource.ID)) {   
            	// TODO read User
           	    response.setBody("{\"id\":1,\"username\":\"David\",\"active\":\"false\"}");
           	    // response.setBody("{\"id\":1,\"username\":\"David\",\"active\":\"true\"}");
           	    // response.setBody("{\"id\":1,\"username\":\"David\",\"active\":\"true\", \"sport\":[ {\"title\":\"tennis\", \"category\":\"junior\"} ]}");
            } else {
               // throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(SportResource.SPORT)) {
            	// TODO: create sport 
                response.setStatus(HttpStatus.CREATED);
            } else if (request.isEqualsPath(UserResource.USER)) {
            	// TODO create User 
                response.setStatus(HttpStatus.CREATED);
            } else {
               // throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doPut(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(UserResource.USER + UserResource.ID + SportResource.SPORT)) {
            	// TODO : link user to sport.
                response.setStatus(HttpStatus.OK);
            } else {
               // throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doPatch(HttpRequest request, HttpResponse response) {
    	 try {
             if (request.isEqualsPath(UserResource.USER + UserResource.ID + UserResource.ACTIVE) ) {
            	 // TODO: modify active in user
                 response.setStatus(HttpStatus.OK);
             } else if (request.isEqualsPath(SportResource.SPORT + UserResource.ID + SportResource.CATEGORY) ) {
            	 // TODO: modify category in sport
            	 response.setStatus(HttpStatus.OK);
             } else {
                // throw new RequestInvalidException(request.getPath());
             }
         } catch (Exception e) {
             responseError(response, e);
         }
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
        // responseError(response, new RequestInvalidException(request.getPath()));
    }

}